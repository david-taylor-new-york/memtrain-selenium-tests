package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenuPage extends BasePage {

    private final By changeSubjectButton = By.id("change-subject-button");
    private final By updateCardsbutton = By.id("update-cards-button");
    private final By trainingMenuButton = By.id("training-menu-button");

    public MainMenuPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void clickChangeSubject()
    {
        clickElement(changeSubjectButton);
    }

    public void clickUpdateCardsButton()
    {
        clickElement(updateCardsbutton);
    }

    public void clickTrainingMenuButton()
    {
        clickElement(trainingMenuButton);
    }
}
