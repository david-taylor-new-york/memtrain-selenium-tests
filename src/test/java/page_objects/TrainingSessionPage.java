package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingSessionPage extends BasePage {

    private final By cardIdResultField = By.id("id-input-field");

    public TrainingSessionPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void enterCardResultsId(String cardId) {
        setText(cardIdResultField, cardId);
        clickElement(submitButton);
    }
}
