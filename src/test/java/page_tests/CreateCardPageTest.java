package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCardPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        loginPage.createUser(uuidUser, uuidPwd);
        subjectPage.createSubject(uuidSubject);
        mainMenuPage.clickAwayToastMessage();
        mainMenuPage.clickUpdateCardsButton();
        cardMenuPage.clickCreateCardsButton();
    }

    @Test(description = "Verify PASS - create three cards")
    public void ClickCancel() {
        Assert.assertTrue(createCardsPage.elementExists(createCardsPageId));
        Assert.assertTrue(createCardsPage.pageTitleIs("Create Cards"));
        Assert.assertTrue(createCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        createCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Card Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - create three cards")
    public void CreateSomeCards() {
        createCardsPage.createCard(uuidCard1Question, uuidCard1Answer);
        Assert.assertEquals(createCardsPage.getNumberOfContentTableElements(), 1);
        createCardsPage.createCard(uuidCard2Question, uuidCard2Answer);
        Assert.assertEquals(createCardsPage.getNumberOfContentTableElements(), 2);
        createCardsPage.createCard(uuidCard3Question, uuidCard3Answer);
        Assert.assertEquals(createCardsPage.getNumberOfContentTableElements(), 3);
        createCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Card Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }
}