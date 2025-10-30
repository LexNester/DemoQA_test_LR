package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TextBoxPage extends BasePage {

    private final By fullName = By.id("userName");
    private final By email = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By outputName = By.id("name");
    private final By outputEmail = By.id("email");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void enterFullName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(fullName)).sendKeys(name);
    }

    public void enterEmail(String emailText) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(emailText);
    }

    public void enterCurrentAddress(String text) {
        driver.findElement(currentAddress).sendKeys(text);
    }

    public void enterPermanentAddress(String text) {
        driver.findElement(permanentAddress).sendKeys(text);
    }

    public void submit() {
        WebElement s = wait.until(ExpectedConditions.elementToBeClickable(submit));
        s.click();
    }

    public String getOutputName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(outputName)).getText();
    }

    public String getOutputEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(outputEmail)).getText();
    }
    public boolean isEmailValid() {
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return arguments[0].checkValidity();", e);
    }

    public String getEmailValidationMessage() {
        WebElement e = driver.findElement(email);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", e);
    }
}
