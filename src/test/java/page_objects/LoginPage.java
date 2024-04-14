package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginUserName = By.id("login-user-name");
    private final By loginPassword = By.id("login-user-pwd");
    private final By loginButton = By.id("login-button");
    private final By newUserButton = By.id("new-user-button");

    public LoginPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void createUser(String userName, String password)
    {
        setText(loginUserName, userName);
        setText(loginPassword, password);
        clickElement(newUserButton);
    }

    public void loginAs(String userName, String password)
    {
        setText(loginUserName, userName);
        setText(loginPassword, password);
        clickElement(loginButton);
    }

    public void setUserName(String userName)
    {
        setText(loginUserName, userName);
    }

    public void clickLoginButton()
    {
        clickElement(loginButton);
    }
}