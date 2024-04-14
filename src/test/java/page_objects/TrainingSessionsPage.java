package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingSessionsPage extends BasePage {

    private final By trainingSessionId = By.id("id-input-field");

    public TrainingSessionsPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void enterTrainingSessionId(String cardId) {
        setText(trainingSessionId, cardId);
        clickElement(submitButton);
    }
}
