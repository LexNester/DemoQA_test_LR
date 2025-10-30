package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ButtonsPage extends BasePage {

    private final By doubleClickButton = By.id("doubleClickBtn");
    private final By rightClickButton = By.id("rightClickBtn");
    private final By clickMeButton = By.xpath("//button[text()='Click Me']");
    private final By doubleClickMessage = By.id("doubleClickMessage");
    private final By rightClickMessage = By.id("rightClickMessage");
    private final By dynamicClickMessage = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClickButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
    }

    public void rightClickButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(rightClickButton));
        Actions actions = new Actions(driver);
        actions.contextClick(button).perform();
    }

    public void clickMeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(clickMeButton)).click();
    }

    public String getDoubleClickMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickMessage)).getText();
    }

    public String getRightClickMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickMessage)).getText();
    }

    public String getDynamicClickMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dynamicClickMessage)).getText();
    }
}



