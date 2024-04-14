package page_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(description = "Verify error msg - no userid or pwd")
    public void NoUserIdOrPasswordFails() {
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getToastMessage(), "Enter username and password");
    }

    @Test(description = "Verify error msg - no pwd")
    public void WithUserIdButNoPasswordFails() {
        loginPage.setUserName(uuidUser);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getToastMessage(), "Enter username and password");
    }

    @Test(description = "Verify error msg - userid not found")
    public void WithNonExistentUserFails() {
        loginPage.loginAs(uuidUser, uuidPwd);
        Assert.assertEquals(loginPage.getToastMessage(), "User " + uuidUser + " not found!");
    }

    @Test(description = "Verify error msg - create userid that already exists")
    public void CreateUserThatAlreadyExistsFails() {
        loginPage.createUser(uuidUser, uuidPwd);
        Assert.assertTrue(subjectPage.elementExists(subjectPageId));
        Assert.assertTrue(subjectPage.pageTitleIs("Subject"));
        Assert.assertTrue(subjectPage.pageSubjectIs("Subject: unselected"));
        Assert.assertTrue(subjectPage.subjectsDropdownIsEmpty());
        subjectPage.clickLogoutButton();
        Assert.assertTrue(loginPage.elementExists(loginPageId));
        loginPage.createUser(uuidUser, uuidPwd);
        Assert.assertEquals(loginPage.getToastMessage(), "User " + uuidUser + " already exists!");
    }

    @Test(description = "Verify PASS - create new user")
    public void CreateNewUserPasses() {
        loginPage.createUser(uuidUser, uuidPwd);
        Assert.assertTrue(subjectPage.elementExists(subjectPageId));
        Assert.assertTrue(subjectPage.pageTitleIs("Subject"));
        Assert.assertTrue(subjectPage.pageSubjectIs("Subject: unselected"));
        Assert.assertTrue(subjectPage.subjectsDropdownIsEmpty());
    }

    @Test(description = "Verify PASS - login existing user")
    public void LoginPasses() {
        loginPage.createUser(uuidUser, uuidPwd);
        Assert.assertTrue(subjectPage.elementExists(subjectPageId));
        Assert.assertTrue(subjectPage.pageTitleIs("Subject"));
        Assert.assertTrue(subjectPage.subjectsDropdownIsEmpty());
        subjectPage.clickLogoutButton();
        Assert.assertTrue(loginPage.elementExists(loginPageId));
        loginPage.loginAs(uuidUser, uuidPwd);
        Assert.assertTrue(subjectPage.elementExists(subjectPageId));
        Assert.assertTrue(subjectPage.pageTitleIs("Subject"));
        Assert.assertTrue(subjectPage.pageSubjectIs("Subject: unselected"));
        Assert.assertTrue(subjectPage.subjectsDropdownIsEmpty());
    }
}