package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DatePickerPage extends BasePage {

    private final By datePickerInput = By.id("datePickerMonthYearInput");
    private final By dateAndTimeInput = By.id("dateAndTimePickerInput");

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/date-picker");
    }

    public void selectDate(String date) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(datePickerInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(date);
    }

    public void selectDateAndTime(String dateTime) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(dateAndTimeInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        input.sendKeys(dateTime);
    }

    public String getSelectedDate() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(datePickerInput)).getAttribute("value");
    }

    public String getSelectedDateTime() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dateAndTimeInput)).getAttribute("value");
    }

    public void clearDateInput() {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(datePickerInput));
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
    }

    public boolean isDateInputEmpty() {
        String value = getSelectedDate();
        return value == null || value.trim().isEmpty();
    }
}

