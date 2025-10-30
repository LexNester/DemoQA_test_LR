package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesPage extends BasePage {
    private final By frame1 = By.id("frame1");
    private final By frame2 = By.id("frame2");
    private final By sampleHeading = By.id("sampleHeading");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/frames");
    }

    public String getTextFromFrame1() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame1));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(sampleHeading)).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getTextFromFrame2() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame2));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(sampleHeading)).getText();
        driver.switchTo().defaultContent();
        return text;
    }
}
