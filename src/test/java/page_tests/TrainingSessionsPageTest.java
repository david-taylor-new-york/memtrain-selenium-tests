package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrainingSessionsPageTest extends BaseTest {

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
        cardMenuPage.clickCancelButton();
        mainMenuPage.clickTrainingMenuButton();

        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickTrainButton();
        Assert.assertTrue(trainingSetupPage.elementExists(trainingSetupPageId));
        trainingSetupPage.clickRecordedRadiobutton();
        trainingSetupPage.clickTrainButton();
        Assert.assertTrue(trainingPage.elementExists(trainingPageId));
        trainingPage.enterAnswer(uuidCard1Answer);
        trainingPage.enterAnswer(uuidCard2Answer);
        trainingPage.enterAnswer(uuidCard3Answer);
        Assert.assertTrue(trainingPage.elementExists(doneWithRoundText));
        trainingPage.clickEnter();
        Assert.assertTrue(trainingPage.elementExists(doneWithTrainingText));
        trainingPage.clickEnter();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickTrainingSessionsButton();
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void VerifyOneTrainingSessionInTableAndClickCancel() {
        Assert.assertTrue(trainingSessionsPage.elementExists(trainingSessionsPageId));
        Assert.assertTrue(trainingSessionsPage.pageTitleIs("Training Sessions"));
        Assert.assertTrue(trainingSessionsPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertEquals(trainingSessionsPage.getNumberOfContentTableElements(), 1);
        trainingSessionsPage.clickCancelButton();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickCancelButton();
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void VerifyViewTrainingSession() {
        Assert.assertTrue(trainingSessionsPage.elementExists(trainingSessionsPageId));
        String trainingSessionId = trainingSessionsPage.getTableCellByRowAndColumn(1, 0);
        trainingSessionsPage.enterTrainingSessionId(trainingSessionId);
        Assert.assertTrue(trainingSessionPage.elementExists(trainingSessionPageId));
        Assert.assertTrue(trainingSessionPage.pageTitleIs("Training Session"));
        Assert.assertTrue(trainingSessionPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertEquals(trainingSessionPage.getNumberOfContentTableElements(), 3);
    }

}