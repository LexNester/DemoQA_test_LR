package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {
    private final By confirmButton = By.id("confirmButton");
    private final By promptButton = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/alerts");
    }

    public void clickConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    public void clickPrompt() {
        wait.until(ExpectedConditions.elementToBeClickable(promptButton)).click();
    }

    public String getConfirmResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmResult)).getText();
    }

    public String getPromptResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promptResult)).getText();
    }
}
