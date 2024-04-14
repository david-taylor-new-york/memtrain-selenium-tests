package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardMenuPage extends BasePage {

    private final By createSomeCardsMsg = By.id("create-some-cards-text");
    private final By createCardsButton = By.id("create-cards-button");
    private final By editCardsButton = By.id("edit-cards-button");
    private final By deleteCardsButton = By.id("delete-cards-button");

    public CardMenuPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public boolean createSomeCardsMsgExists()
    {
        return elementExists(createSomeCardsMsg);
    }

    public boolean createCardsButtonExists()
    {
        return elementExists(createCardsButton);
    }

    public void clickCreateCardsButton()
    {
        clickElement(createCardsButton);
    }

    public void clickEditCardsButton()
    {
        clickElement(editCardsButton);
    }

    public void clickDeleteCardsButton()
    {
        clickElement(deleteCardsButton);
    }

}

