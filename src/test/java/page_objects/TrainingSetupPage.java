package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrainingSetupPage extends BasePage {
    private final By practiceRadiobutton = By.id("practice-radiobutton");
    private final By recordedRadiobutton = By.id("recorded-radiobutton");
    private final By trainButton = By.id("train-button");

    public TrainingSetupPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void clickTrainButton() {
        clickElement(trainButton);
    }

    public void clickPracticeOnlyRadiobutton() {
        clickElement(practiceRadiobutton);
    }

    public void clickRecordedRadiobutton() {
        clickElement(recordedRadiobutton);
    }
}
