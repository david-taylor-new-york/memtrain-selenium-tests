package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingPage extends BasePage {
    private final By trainButton = By.id("train-button");
    private final By answerTextBox = By.id("answer-response");
    private final By submitAnswerButton = By.id("submit-answer-button");
    private final By clickEnter = By.id("click-enter");

    public TrainingPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void clickEnter() {
        clickElement(clickEnter);
    }

    public void clickTrainingButton() {
        clickElement(trainButton);
    }

    public void enterAnswer(String answer) {
        setText(answerTextBox, answer);
        clickElement(submitAnswerButton);
    }
}
