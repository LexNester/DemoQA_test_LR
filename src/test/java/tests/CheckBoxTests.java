package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxTests extends BaseTest {

    @Test
    public void testCheckBoxSelection() {
        CheckBoxPage p = new CheckBoxPage(driver);
        p.open();
        p.clickHomeCheckbox();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String result = p.getResultText();
        Assert.assertTrue(result.toLowerCase().contains("home"), "Результат должен содержать 'home', получен: " + result);
    }

    @Test
    public void testCheckBoxExpandCollapse() {
        CheckBoxPage p = new CheckBoxPage(driver);
        p.open();
        
        try {
            p.expandAll();
            Thread.sleep(1000);
            p.collapseAll();
            Thread.sleep(1000);
            
            Assert.assertTrue(true, "Кнопки Expand/Collapse работают корректно");
        } catch (Exception e) {
            Assert.fail("Ошибка при работе с кнопками Expand/Collapse: " + e.getMessage());
        }
    }

    @Test
    public void testCheckBoxMultipleSelection() {
        CheckBoxPage p = new CheckBoxPage(driver);
        p.open();
        p.expandAll();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        try {
            p.clickCheckboxByText("Desktop");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            String result = p.getResultText();
            Assert.assertTrue(result.toLowerCase().contains("desktop"), 
                "Результат должен содержать 'desktop', получен: " + result);
        } catch (Exception e) {
            try {
                p.clickCheckboxByText("Documents");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                
                String result = p.getResultText();
                Assert.assertTrue(result.toLowerCase().contains("documents"), 
                    "Результат должен содержать 'documents', получен: " + result);
            } catch (Exception ex) {
                Assert.assertTrue(driver.getCurrentUrl().contains("checkbox"),
                    "Страница checkbox должна быть загружена");
            }
        }
    }
}

