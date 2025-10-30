package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectMenuPage extends BasePage {

    private final By selectValueDropdown = By.id("withOptGroup");
    private final By selectOneDropdown = By.id("selectOne");
    private final By oldStyleSelect = By.id("oldSelectMenu");
    private final By multiselectDropdown = By.id("cars");
    private final By selectValueOption = By.xpath("//div[contains(@class, 'option') and text()='Group 1, option 1']");
    private final By selectOneOption = By.xpath("//div[contains(@class, 'option') and text()='Dr.']");

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void selectValueFromDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(selectValueDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectValueOption)).click();
    }

    public void selectOneFromDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(selectOneDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectOneOption)).click();
    }

    public void selectFromOldStyleSelect(String value) {
        Select select = new Select(driver.findElement(oldStyleSelect));
        select.selectByValue(value);
    }

    public void selectMultipleValues(String... values) {
        Select select = new Select(driver.findElement(multiselectDropdown));
        for (String value : values) {
            select.selectByValue(value);
        }
    }

    public String getSelectedValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectValueDropdown)).getText();
    }

    public String getSelectedOne() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectOneDropdown)).getText();
    }
}



