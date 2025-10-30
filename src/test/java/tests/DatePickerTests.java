package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DatePickerPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerTests extends BaseTest {

    @Test
    public void testDatePickerInput() {
        DatePickerPage p = new DatePickerPage(driver);
        p.open();
        
        String testDate = "12/25/2023";
        p.selectDate(testDate);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String selectedDate = p.getSelectedDate();
        Assert.assertTrue(selectedDate.contains("12/25/2023"), 
            "Выбранная дата должна содержать '12/25/2023', получено: " + selectedDate);
    }

    @Test
    public void testDateAndTimePicker() {
        DatePickerPage p = new DatePickerPage(driver);
        p.open();
        
        String testDateTime = "December 25, 2023 2:30 PM";
        p.selectDateAndTime(testDateTime);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String selectedDateTime = p.getSelectedDateTime();
        Assert.assertTrue(selectedDateTime.contains("December 25, 2023"), 
            "Выбранная дата и время должны содержать 'December 25, 2023', получено: " + selectedDateTime);
    }

    @Test
    public void testDatePickerClear() {
        DatePickerPage p = new DatePickerPage(driver);
        p.open();
        
        p.selectDate("12/25/2023");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String dateAfterInput = p.getSelectedDate();
        Assert.assertFalse(dateAfterInput.isEmpty(), "Дата должна быть введена, получено: " + dateAfterInput);
        
        p.clearDateInput();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        boolean isEmpty = p.isDateInputEmpty();
        Assert.assertTrue(isEmpty, "Поле даты должно быть пустым после очистки");
    }

    @Test
    public void testDatePickerCurrentDate() {
        DatePickerPage p = new DatePickerPage(driver);
        p.open();
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String currentDateString = currentDate.format(formatter);
        
        p.selectDate(currentDateString);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String selectedDate = p.getSelectedDate();
        Assert.assertTrue(selectedDate.contains(currentDateString), 
            "Выбранная дата должна содержать текущую дату " + currentDateString + ", получено: " + selectedDate);
    }
}

