package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingMenuPage extends BasePage {
    private final By noCardsToTrainMsg = By.id("create-some-cards-text");
    private final By trainButton = By.id("train-button");
    private final By trainingSessionsButton = By.id("training-sessions-button");

    public TrainingMenuPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void clickTrainButton() {
        clickElement(trainButton);
    }

    public void clickTrainingSessionsButton() {
        clickElement(trainingSessionsButton);
    }

    public boolean noCardsToTrainMsgExists()
    {
        return elementExists(noCardsToTrainMsg);
    }

    public boolean trainingSessionsButtonDoesNotExist() {
        return elementDoesNotExist(trainingSessionsButton);
    }
}
