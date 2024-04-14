package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubjectPage extends BasePage {

    private final By subjectsDropdown = By.id("subjects-dropdown");
    private final By selectSubjectButton = By.id("select-subject-button");
    private final By newSubjectName = By.id("new-subject-name");
    private final By addSubjectButton = By.id("new-subject-button");

    public SubjectPage(WebDriver _webdriver)
    {
        super(_webdriver);
    }

    public void createSubject(String name)
    {
        setText(newSubjectName, name);
        clickElement(addSubjectButton);
    }

    public Boolean subjectsDropdownIsEmpty()
    {
        return ( getNumberOfDropdownElements() == 1 );
    }

    public int getNumberOfDropdownElements()
    {
        return getNumberOfDropdownElements(subjectsDropdown);
    }

    public void selectDropdownItemByVisibleText(String visibleText) {
        selectDropdownItemByVisibleText(subjectsDropdown, visibleText);
    }

        public void clickSelectButton()
    {
        clickElement(selectSubjectButton);
    }
}
