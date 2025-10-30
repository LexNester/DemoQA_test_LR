package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsTests extends BaseTest {

    @Test
    public void testConfirmAlertAccept() {
        AlertsPage p = new AlertsPage(driver);
        p.open();
        p.clickConfirm();
        driver.switchTo().alert().accept();
        Assert.assertTrue(p.getConfirmResult().contains("Ok"));
    }

    @Test
    public void testPromptAlertSendText() {
        AlertsPage p = new AlertsPage(driver);
        p.open();
        p.clickPrompt();
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        Assert.assertTrue(p.getPromptResult().contains("hello"));
    }
}
