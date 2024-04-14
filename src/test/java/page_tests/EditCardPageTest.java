package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditCardPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        loginPage.createUser(uuidUser, uuidPwd);
        subjectPage.createSubject(uuidSubject);
        mainMenuPage.clickAwayToastMessage();
        mainMenuPage.clickUpdateCardsButton();
        cardMenuPage.clickCreateCardsButton();
        createCardsPage.createCard(uuidCard1Question, uuidCard1Answer);
        createCardsPage.createCard(uuidCard2Question, uuidCard2Answer);
        createCardsPage.createCard(uuidCard3Question, uuidCard3Answer);
        createCardsPage.clickCancelButton();
        cardMenuPage.clickEditCardsButton();
    }

    @Test(description = "Verify PASS - ClickCancel")
    public void ClickCancel() {
        Assert.assertTrue(editCardsPage.elementExists(editCardsPageId));
        Assert.assertTrue(editCardsPage.pageTitleIs("Edit Cards"));
        Assert.assertTrue(editCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        editCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Card Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - create three cards")
    public void CreateSomeCardsAndEditOne() {
        Assert.assertTrue(editCardsPage.elementExists(editCardsPageId));
        editCardsPage.setCardToEdit(editCardsPage.getTableCellByRowAndColumn(2, 0));
        editCardsPage.setQuestion("edited question");
        editCardsPage.setAnswer("edited answer");
        editCardsPage.setCardToFollow("7");
        editCardsPage.clickSubmitEditsButton();
        Assert.assertTrue(editCardsPage.elementExists(editCardsPageId));
        Assert.assertTrue(editCardsPage.pageTitleIs("Edit Cards"));
        Assert.assertTrue(editCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertTrue(editCardsPage.cardwasEdited(2, "edited question", "edited answer"));
    }
}