package muth.andreas.flashcards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label cardLabel;
    @FXML
    private TextField questionInput;
    @FXML
    private TextField answerInput;

    private int currentCardID = 1;
    private boolean onQuestionSide = true;

    @FXML
    protected void onAddButtonClick() {
        String question = questionInput.getText();
        String answer = answerInput.getText();

        DBUtils.addCard(question, answer);
    }

    @FXML
    protected void onNextButtonClick() {
        currentCardID++;
        reloadCard();
    }

    @FXML
    protected void onPreviousButtonClick() {
        currentCardID--;
        reloadCard();
    }

    protected void reloadCard() {
        currentCardID = Math.clamp(currentCardID, 1, DBUtils.getCardCount());

        Card card = DBUtils.getCardByID(currentCardID);
        if(onQuestionSide) {
            cardLabel.setText(card.getQuestion());
        } else {
            cardLabel.setText(card.getAnswer());
        }
    }

    @FXML
    protected void onFlipButtonClick() {
        onQuestionSide = !onQuestionSide;
        reloadCard();
    }
}