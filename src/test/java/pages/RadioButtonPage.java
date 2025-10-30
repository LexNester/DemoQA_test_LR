package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RadioButtonPage extends BasePage {

    private final By yesRadio = By.xpath("//label[@for='yesRadio']");
    private final By impressiveRadio = By.xpath("//label[@for='impressiveRadio']");
    private final By noRadio = By.xpath("//label[@for='noRadio']");
    private final By resultText = By.xpath("//span[@class='text-success']");

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/radio-button");
    }

    public void clickYesRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(yesRadio)).click();
    }

    public void clickImpressiveRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(impressiveRadio)).click();
    }

    public void clickNoRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(noRadio)).click();
    }

    public String getResultText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }

    public boolean isYesSelected() {
        By yesInput = By.id("yesRadio");
        return driver.findElement(yesInput).isSelected();
    }

}

