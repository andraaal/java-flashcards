package muth.andreas.flashcards;

public class Card {
    private String question;
    private String answer;
    private final int id;

    public Card(String question, String answer, int id) {
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
