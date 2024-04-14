package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    public final By pageSubject = By.id("page-subject");
    public final By pageTitle = By.id("page-title");
    public final By contentTable = By.className("table-container");
    private final By logoutButton = By.id("logout-button");
    private final By cancelButton = By.id("cancel-button");
    public final By submitButton = By.id("submit-button");

    private final By toastMessage = By.id("1");
    private final By toastMessage2 = By.id("2");

    public final WebDriver webDriver;
    public final WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
//        this.webDriver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);

        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(6)); // Adjust timeout as needed
    }

    /* Basic actions - with wait */
    private String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void setText(By locator, String keysToSend) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(keysToSend);
    }

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public boolean elementExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)) != null;
    }
    /* Basic actions - with wait */


    public void clickAwayToastMessage() {
        clickElement(toastMessage);
    }

    public void clickAwayToastMessage2() {
        clickElement(toastMessage2);
    }

    public String getToastMessage() {
        return getText(toastMessage);
    }

    public String getToastMessage2() {
        return getText(toastMessage2);
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }

    public void clickCancelButton() {
        clickElement(cancelButton);
    }

    public boolean elementDoesNotExist(By locator) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        try {
            webDriver.findElement(locator);
            return false;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return true;
        }
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean elementTextIs(By locator, String expectedText) {
        String actualText = getText(locator);
        return actualText.equals(expectedText);
    }

    public boolean pageTitleIs(String expectedTitle) {
        return elementTextIs(pageTitle, expectedTitle);
    }

    public boolean pageSubjectIs(String expectedSubject) {
        return elementTextIs(pageSubject, expectedSubject);
    }

    public void selectDropdownItemByVisibleText(By locator, String visibleText) {
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
        dropdown.selectByVisibleText(visibleText);
    }

    public int getNumberOfDropdownElements(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select s = new Select(webDriver.findElement(locator));
        List<WebElement> options = s.getOptions();
        return options.size();
    }

    public boolean contentTableIsNotPresent() {
        return elementDoesNotExist(contentTable);
    }

    public int getNumberOfContentTableElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentTable));
        WebElement table = webDriver.findElement(contentTable);
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        return tableRows.size() - 1;
    }

    public String getTableCellByRowAndColumn(int index, int cell) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentTable));
        WebElement table = webDriver.findElement(contentTable);
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        WebElement row = tableRows.get(index);
        List<WebElement> cells = row.findElements(By.tagName("td"));
        return cells.get(cell).getText();
    }
}
