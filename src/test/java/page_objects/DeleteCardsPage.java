package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCardsPage extends BasePage {
    private final By cardIdToDelete = By.id("id-input-field");

    public DeleteCardsPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void deleteCard(String cardId) {
        setText(cardIdToDelete, cardId);
        clickElement(submitButton);
    }
}

