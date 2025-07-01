import java.io.*;
import java.util.ArrayList;
public class FlashcardManager {
    private ArrayList<Flashcard> studyCards = new ArrayList<>();
    private Flashcard[] masteredCards = new Flashcard[100]; // fixed size for simplicity
    private int masteredIndex = 0;
    private final String studyFile = "studycards.txt";
    private final String masteredFile = "masteredcards.txt";
    public FlashcardManager() {
        loadFlashcards();
    }
    public void addFlashcard(String question, String answer) {
        studyCards.add(new Flashcard(question, answer));
    }
    public Flashcard getNextCard() {
        if (studyCards.size() > 0) {
            return studyCards.get(0);
        }
        return null;
    }
    public void markAsMastered() {
        if (studyCards.size() > 0 && masteredIndex < masteredCards.length) {
            masteredCards[masteredIndex++] = studyCards.remove(0);
        }
    }
    public void saveFlashcards() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(studyFile))) {
            for (Flashcard fc : studyCards) {
                writer.write(fc.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving study cards: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(masteredFile))) {
            for (int i = 0; i < masteredIndex; i++) {
                writer.write(masteredCards[i].toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving mastered cards: " + e.getMessage());
        }
    }
    private void loadFlashcards() {
        try (BufferedReader reader = new BufferedReader(new FileReader(studyFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Flashcard fc = Flashcard.fromString(line);
                if (fc != null) studyCards.add(fc);
            }
        } catch (IOException e) {
            System.out.println("Study cards file not found. Starting fresh.");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(masteredFile))) {
            String line;
            while ((line = reader.readLine()) != null && masteredIndex < masteredCards.length) {
                Flashcard fc = Flashcard.fromString(line);
                if (fc != null) masteredCards[masteredIndex++] = fc;
            }
        } catch (IOException e) {
            System.out.println("Mastered cards file not found. Starting fresh.");
        }
    }
    public void listMasteredCards() {
        System.out.println("\n--- Mastered Cards ---");
        for (int i = 0; i < masteredIndex; i++) {
            System.out.println((i + 1) + ". " + masteredCards[i].getQuestion());
        }
    }
}
