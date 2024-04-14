package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class EditCardsPage extends BasePage {
    private final By cardIdToEdit = By.id("id-input-field");
    private final By cardQuestion = By.id("card-question");
    private final By cardAnswer = By.id("card-answer");
    private final By cardIdToFollow = By.id("card-id-to-follow");
    private final By submitEditsButton = By.id("create-update-card-button");

    public EditCardsPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public boolean cardwasEdited(int index, String expectedQuestion, String expectedAnswer) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentTable));
        WebElement table = webDriver.findElement(contentTable);
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        String editedCard = tableRows.get(index).getText();
        return editedCard.contains(expectedQuestion) && editedCard.contains(expectedAnswer);
    }

    public void setQuestion(String question) {
        setText(cardQuestion, question);
    }

    public void setAnswer(String answer) {
        setText(cardAnswer, answer);
    }

    public void setCardToFollow(String cardToFollow) {
        setText(cardIdToFollow, cardToFollow);
    }

    public void clickSubmitEditsButton() {
        clickElement(submitEditsButton);
    }

    public void setCardToEdit(String id) {
        setText(cardIdToEdit, id);
        clickElement(submitButton);
    }
}

