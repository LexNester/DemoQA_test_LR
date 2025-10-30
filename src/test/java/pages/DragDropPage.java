package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DragDropPage extends BasePage {
    private final By source = By.id("draggable");
    private final By target = By.id("droppable");

    public DragDropPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/droppable");
    }

    public void dragToTarget() {
        WebElement s = wait.until(ExpectedConditions.visibilityOfElementLocated(source));
        WebElement t = wait.until(ExpectedConditions.visibilityOfElementLocated(target));
        new Actions(driver).dragAndDrop(s, t).perform();
    }

    public String getTargetText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(target)).getText();
    }
}
