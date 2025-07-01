public class Flashcard {
    private String question;
    private String answer;
    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    @Override
    public String toString() {
        return question + "|" + answer; // For file saving
    }
    public static Flashcard fromString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 2) {
            return new Flashcard(parts[0], parts[1]);
        }
        return null;
    }
}
