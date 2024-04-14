package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrainingMenuPageTest extends BaseTest {

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
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void VerifyNoCardsToTrainAndCancelButton() {
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickCancelButton();
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
        mainMenuPage.clickUpdateCardsButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        cardMenuPage.clickDeleteCardsButton();
        Assert.assertTrue(deleteCardsPage.elementExists(deleteCardsPageId));
        deleteCardsPage.deleteCard(deleteCardsPage.getTableCellByRowAndColumn(3, 0));
        deleteCardsPage.deleteCard(deleteCardsPage.getTableCellByRowAndColumn(2, 0));
        deleteCardsPage.deleteCard(deleteCardsPage.getTableCellByRowAndColumn(1, 0));
        deleteCardsPage.clickCancelButton();
        Assert.assertTrue(cardMenuPage.elementExists(cardMenuPageId));
        cardMenuPage.clickCancelButton();
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
        mainMenuPage.clickTrainingMenuButton();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        Assert.assertTrue(trainingMenuPage.pageTitleIs("Training Menu"));
        Assert.assertTrue(trainingMenuPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertTrue(trainingMenuPage.noCardsToTrainMsgExists());
        trainingMenuPage.clickCancelButton();
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
        Assert.assertTrue(mainMenuPage.pageTitleIs("Main Menu"));
        Assert.assertTrue(mainMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void VerifyClickTrain() {
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickTrainButton();
        Assert.assertTrue(trainingSetupPage.elementExists(trainingSetupPageId));
        Assert.assertTrue(trainingSetupPage.pageTitleIs("Training Setup"));
        Assert.assertTrue(trainingSetupPage.pageSubjectIs("Subject: " + uuidSubject));
        trainingSetupPage.clickCancelButton();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        Assert.assertTrue(trainingMenuPage.pageTitleIs("Training Menu"));
        Assert.assertTrue(trainingMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void VerifyPracticeDoesNotAddTrainingSession() {
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickTrainButton();
        Assert.assertTrue(trainingSetupPage.elementExists(trainingSetupPageId));
        trainingSetupPage.clickPracticeOnlyRadiobutton();
        trainingSetupPage.clickTrainButton();
        Assert.assertTrue(trainingPage.elementExists(trainingPageId));
        Assert.assertTrue(trainingPage.pageTitleIs("Training"));
        Assert.assertTrue(trainingPage.pageSubjectIs("Subject: " + uuidSubject));
        trainingPage.enterAnswer(uuidCard1Answer);
        trainingPage.enterAnswer(uuidCard2Answer);
        trainingPage.enterAnswer(uuidCard3Answer);
        Assert.assertTrue(trainingPage.elementExists(doneWithRoundText));
        trainingPage.clickEnter();
        Assert.assertTrue(trainingPage.elementExists(doneWithTrainingText));
        trainingPage.clickEnter();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        Assert.assertTrue(trainingMenuPage.trainingSessionsButtonDoesNotExist());
    }

    @Test(description = "Verify PASS - click ChangeSubject")
    public void VerifyViewTrainingSessions() {
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickTrainButton();
        Assert.assertTrue(trainingSetupPage.elementExists(trainingSetupPageId));
        trainingSetupPage.clickRecordedRadiobutton();
        trainingSetupPage.clickTrainButton();
        Assert.assertTrue(trainingPage.elementExists(trainingPageId));
        Assert.assertTrue(trainingPage.pageTitleIs("Training"));
        Assert.assertTrue(trainingPage.pageSubjectIs("Subject: " + uuidSubject));
        trainingPage.enterAnswer(uuidCard1Answer);
        trainingPage.enterAnswer(uuidCard2Answer);
        trainingPage.enterAnswer(uuidCard3Answer);
        Assert.assertTrue(trainingPage.elementExists(doneWithRoundText));
        trainingPage.clickEnter();
        Assert.assertTrue(trainingPage.elementExists(doneWithTrainingText));
        trainingPage.clickEnter();
        Assert.assertTrue(trainingMenuPage.elementExists(trainingMenuPageId));
        trainingMenuPage.clickTrainingSessionsButton();
        Assert.assertTrue(trainingSessionsPage.elementExists(trainingSessionsPageId));
        Assert.assertTrue(trainingSessionsPage.pageTitleIs("Training Sessions"));
        Assert.assertTrue(trainingSessionsPage.pageSubjectIs("Subject: " + uuidSubject));
        Assert.assertEquals(trainingSessionsPage.getNumberOfContentTableElements(), 1);
    }

}