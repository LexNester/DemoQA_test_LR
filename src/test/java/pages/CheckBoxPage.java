package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckBoxPage extends BasePage {

    private final By homeCheckbox = By.xpath("//span[contains(@class, 'rct-checkbox')]//input[@type='checkbox']");
    private final By resultText = By.id("result");
    private final By expandAllButton = By.xpath("//button[@title='Expand all']");
    private final By collapseAllButton = By.xpath("//button[@title='Collapse all']");
    private final By allCheckboxes = By.xpath("//span[contains(@class, 'rct-checkbox')]//input[@type='checkbox']");
    private final By checkboxLabels = By.xpath("//span[contains(@class, 'rct-title')]");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void clickHomeCheckbox() {
        // Используем более простой подход - кликаем по label
        By homeLabel = By.xpath("//span[contains(@class, 'rct-title') and text()='Home']");
        wait.until(ExpectedConditions.elementToBeClickable(homeLabel)).click();
    }

    public String getResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }

    public void expandAll() {
        wait.until(ExpectedConditions.elementToBeClickable(expandAllButton)).click();
    }

    public void collapseAll() {
        wait.until(ExpectedConditions.elementToBeClickable(collapseAllButton)).click();
    }

    public List<WebElement> getAllCheckboxes() {
        return driver.findElements(allCheckboxes);
    }

    public void clickCheckboxByText(String text) {
        // Используем более простой подход - кликаем по label
        By checkboxLabel = By.xpath("//span[contains(@class, 'rct-title') and text()='" + text + "']");
        wait.until(ExpectedConditions.elementToBeClickable(checkboxLabel)).click();
    }

    public List<WebElement> getCheckboxLabels() {
        return driver.findElements(checkboxLabels);
    }

    public boolean isCheckboxSelected(String text) {
        By checkbox = By.xpath("//span[contains(@class, 'rct-title') and text()='" + text + "']/preceding-sibling::span[contains(@class, 'rct-checkbox')]//input");
        WebElement element = driver.findElement(checkbox);
        return element.isSelected();
    }
}
