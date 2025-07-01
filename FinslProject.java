/*This is the main code, to test run using "java FinslProject"
(Please mind the typo)
*/
import java.util.Scanner;
public class FinslProject {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FlashcardManager manager = new FlashcardManager();
        boolean running = true;
        System.out.println("Welcome to the Flashcard Study App!");
        while (running) {
            printMenu();
            int choice = getValidatedMenuInput();
            switch (choice) {
                case 1:
                    addFlashcard(manager);
                    break;
                case 2:
                    studyFlashcard(manager);
                    break;
                case 3:
                    manager.listMasteredCards();
                    break;
                case 4:
                    manager.saveFlashcards();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye!");
    }
    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a flashcard");
        System.out.println("2. Study next flashcard");
        System.out.println("3. View mastered flashcards");
        System.out.println("4. Exit and save");
        System.out.print("Choose an option: ");
    }
    private static int getValidatedMenuInput() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("That's not a number. Try again.");
            return getValidatedMenuInput(); // recursive error checking
        }
    }
    private static void addFlashcard(FlashcardManager manager) {
        System.out.print("Enter the question: ");
        String question = scanner.nextLine();
        System.out.print("Enter the answer: ");
        String answer = scanner.nextLine();
        manager.addFlashcard(question, answer);
        System.out.println("Flashcard added!");
    }
    private static void studyFlashcard(FlashcardManager manager) {
        Flashcard fc = manager.getNextCard();
        if (fc == null) {
            System.out.println("No flashcards left to study!");
            return;
        }
        System.out.println("\nQuestion: " + fc.getQuestion());
        System.out.print("Press Enter to show answer...");
        scanner.nextLine();
        System.out.println("Answer: " + fc.getAnswer());
        System.out.print("Did you get it right? (y/n): ");
        String input = scanner.nextLine().toLowerCase();
        if (input.equals("y")) {
            manager.markAsMastered();
            System.out.println("Great! Card marked as mastered.");
        } else {
            System.out.println("Keep practicing this one.");
        }
    }
}
