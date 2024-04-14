package page_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubjectPageTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        loginPage.createUser(uuidUser, uuidPwd);
        subjectPage.createSubject(uuidSubject);
    }

    @Test(description = "Verify PASS - create new subject")
    public void CreateNewUserNewSubject() {
        Assert.assertEquals(mainMenuPage.getToastMessage(), "Subject " + uuidSubject + " added!");
        mainMenuPage.clickAwayToastMessage();
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
        Assert.assertTrue(mainMenuPage.pageTitleIs("Main Menu"));
        Assert.assertTrue(mainMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - create new subject, change, then hit select button")
    public void SelectCurrentSubject() {
        mainMenuPage.clickAwayToastMessage();
        mainMenuPage.clickChangeSubject();
        subjectPage.clickSelectButton();
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
        Assert.assertTrue(mainMenuPage.pageTitleIs("Main Menu"));
        Assert.assertTrue(mainMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }

    @Test(description = "Verify PASS - create new subject")
    public void SelectDropdownItemByVisibleText() {
        mainMenuPage.clickAwayToastMessage();
        mainMenuPage.clickChangeSubject();
        subjectPage.createSubject(uuidSubject + "1");
        mainMenuPage.clickAwayToastMessage2();
        mainMenuPage.clickChangeSubject();
        subjectPage.selectDropdownItemByVisibleText(uuidSubject);
        Assert.assertTrue(mainMenuPage.elementExists(mainMenuPageId));
        Assert.assertTrue(mainMenuPage.pageTitleIs("Main Menu"));
        Assert.assertTrue(mainMenuPage.pageSubjectIs("Subject: " + uuidSubject));
    }
}