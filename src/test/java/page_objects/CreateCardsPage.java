package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCardsPage extends BasePage {
    private final By cardQuestion = By.id("card-question");
    private final By cardAnswer = By.id("card-answer");
    private final By cardIdToFollow = By.id("card-id-to-follow");
    private final By createCardsButton = By.id("create-update-card-button");

    public CreateCardsPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void createCard(String question, String answer) {
        setText(cardQuestion, question);
        setText(cardAnswer, answer);
        clickElement(createCardsButton);
    }

    public void createCard(String question, String answer, String idToFollow) {
        setText(cardQuestion, question);
        setText(cardAnswer, answer);
        setText(cardIdToFollow, idToFollow);
        clickElement(createCardsButton);
    }

}

