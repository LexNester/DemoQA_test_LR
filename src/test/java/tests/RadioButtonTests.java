package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RadioButtonPage;

public class RadioButtonTests extends BaseTest {

    @Test
    public void testRadioButtonYesSelection() {
        RadioButtonPage p = new RadioButtonPage(driver);
        p.open();
        p.clickYesRadio();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String result = p.getResultText();
        Assert.assertEquals(result, "Yes", "Результат должен быть 'Yes'");
    }

    @Test
    public void testRadioButtonImpressiveSelection() {
        RadioButtonPage p = new RadioButtonPage(driver);
        p.open();
        p.clickImpressiveRadio();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        String result = p.getResultText();
        Assert.assertEquals(result, "Impressive", "Результат должен быть 'Impressive'");
    }

    @Test
    public void testRadioButtonSwitchSelection() {
        RadioButtonPage p = new RadioButtonPage(driver);
        p.open();
        
        p.clickYesRadio();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result1 = p.getResultText();
        Assert.assertEquals(result1, "Yes", "После выбора Yes результат должен быть 'Yes'");
        
        p.clickImpressiveRadio();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result2 = p.getResultText();
        Assert.assertEquals(result2, "Impressive", "После выбора Impressive результат должен быть 'Impressive'");
    }
}

