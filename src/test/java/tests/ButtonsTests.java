package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ButtonsPage;

public class ButtonsTests extends BaseTest {

    @Test
    public void testDoubleClickButton() {
        ButtonsPage p = new ButtonsPage(driver);
        p.open();
        p.doubleClickButton();
        
        String message = p.getDoubleClickMessage();
        Assert.assertEquals(message, "You have done a double click", 
            "Сообщение должно быть 'You have done a double click'");
    }

    @Test
    public void testRightClickButton() {
        ButtonsPage p = new ButtonsPage(driver);
        p.open();
        p.rightClickButton();
        
        String message = p.getRightClickMessage();
        Assert.assertEquals(message, "You have done a right click", 
            "Сообщение должно быть 'You have done a right click'");
    }

    @Test
    public void testDynamicClickButton() {
        ButtonsPage p = new ButtonsPage(driver);
        p.open();
        p.clickMeButton();
        
        String message = p.getDynamicClickMessage();
        Assert.assertEquals(message, "You have done a dynamic click", 
            "Сообщение должно быть 'You have done a dynamic click'");
    }

    @Test
    public void testAllButtonActions() {
        ButtonsPage p = new ButtonsPage(driver);
        p.open();
        
        p.doubleClickButton();
        Assert.assertTrue(p.getDoubleClickMessage().contains("double click"));
        
        p.rightClickButton();
        Assert.assertTrue(p.getRightClickMessage().contains("right click"));
        
        p.clickMeButton();
        Assert.assertTrue(p.getDynamicClickMessage().contains("dynamic click"));
    }
}



