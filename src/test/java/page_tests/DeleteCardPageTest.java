package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteCardPageTest extends BaseTest {

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
        cardMenuPage.clickDeleteCardsButton();
    }

    @Test(description = "Verify PASS - create three cards")
    public void ClickCancel() {
        Assert.assertTrue(deleteCardsPage.elementExists(deleteCardsPageId));
        Assert.assertTrue(deleteCardsPage.pageTitleIs("Delete Cards"));
        Assert.assertTrue(deleteCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        deleteCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Card Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - create three cards")
    public void DeleteOneCard() {
        Assert.assertTrue(deleteCardsPage.elementExists(deleteCardsPageId));
        Assert.assertTrue(deleteCardsPage.pageTitleIs("Delete Cards"));
        Assert.assertTrue(createCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        String cardId = deleteCardsPage.getTableCellByRowAndColumn(2, 0);
        deleteCardsPage.deleteCard(cardId);
        Assert.assertEquals(deleteCardsPage.getToastMessage2(), "CARD " + cardId + " DELETED!");
        deleteCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertEquals(cardMenuPage.getNumberOfContentTableElements(), 2);
    }
}