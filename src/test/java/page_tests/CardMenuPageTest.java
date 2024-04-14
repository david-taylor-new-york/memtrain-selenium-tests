package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardMenuPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        loginPage.createUser(uuidUser, uuidPwd);
        subjectPage.createSubject(uuidSubject);
        mainMenuPage.clickAwayToastMessage();
        mainMenuPage.clickUpdateCardsButton();
    }

    @Test(description = "Verify PASS - DefaultElementsExistThenClickCancel")
    public void DefaultElementsExistThenClickCancel() {
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Card Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertTrue(cardMenuPage.createSomeCardsMsgExists());
        Assert.assertTrue(cardMenuPage.createCardsButtonExists());
        cardMenuPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(mainMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Main Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - NavigateToCreateCardsPage")
    public void NavigateToCreateCardsPage() {
        cardMenuPage.clickCreateCardsButton();
        Assert.assertTrue(createCardsPage.elementExists(createCardsPageId));
        Assert.assertTrue(createCardsPage.pageTitleIs("Create Cards"));
        Assert.assertTrue(createCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertTrue(createCardsPage.contentTableIsNotPresent());
    }

    @Test(description = "Verify PASS - NavigateToEditCardsPage")
    public void NavigateToEditCardsPage() {
        cardMenuPage.clickCreateCardsButton();
        Assert.assertTrue(createCardsPage.elementExists(createCardsPageId));
        createCardsPage.createCard(uuidCard1Question, uuidCard1Answer);
        Assert.assertEquals(createCardsPage.getNumberOfContentTableElements(), 1);
        createCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        cardMenuPage.clickEditCardsButton();
        Assert.assertTrue(editCardsPage.elementExists(editCardsPageId));
        Assert.assertTrue(editCardsPage.pageTitleIs("Edit Cards"));
        Assert.assertTrue(editCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertEquals(editCardsPage.getNumberOfContentTableElements(), 1);
    }

    @Test(description = "Verify PASS - NavigateToDeleteCardsPage")
    public void NavigateToDeleteCardsPage() {
        cardMenuPage.clickCreateCardsButton();
        Assert.assertTrue(createCardsPage.elementExists(createCardsPageId));
        createCardsPage.createCard(uuidCard2Question, uuidCard2Answer);
        createCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        cardMenuPage.clickDeleteCardsButton();
        Assert.assertTrue(deleteCardsPage.elementExists(deleteCardsPageId));
        Assert.assertTrue(deleteCardsPage.pageTitleIs("Delete Cards"));
        Assert.assertTrue(deleteCardsPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertEquals(deleteCardsPage.getNumberOfContentTableElements(), 1);
    }
}