package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainMenuPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        loginPage.createUser(uuidUser, uuidPwd);
        subjectPage.createSubject(uuidSubject);
        mainMenuPage.clickAwayToastMessage();
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void ChangeSubject() {
        mainMenuPage.clickChangeSubject();
        Assert.assertTrue(subjectPage.elementExists(subjectPageId));
        Assert.assertTrue(subjectPage.pageTitleIs("Subject"));
        Assert.assertTrue(subjectPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertEquals(subjectPage.getNumberOfDropdownElements(), 2);
    }

    @Test(description = "Verify PASS - click UpdateCardsButton")
    public void UpdateCardsButton() {
        mainMenuPage.clickUpdateCardsButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        Assert.assertTrue(cardMenuPage.pageTitleIs("Card Menu"));
        Assert.assertTrue(cardMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - click TrainingButton")
    public void TrainingButton() {
        mainMenuPage.clickTrainingMenuButton();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        Assert.assertEquals(trainingMenuPage.getPageTitle(), "Training Menu");
        Assert.assertTrue(trainingMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }
}