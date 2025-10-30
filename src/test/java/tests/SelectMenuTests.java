package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SelectMenuPage;

public class SelectMenuTests extends BaseTest {

    @Test
    public void testSelectValueDropdown() {
        SelectMenuPage p = new SelectMenuPage(driver);
        p.open();
        p.selectValueFromDropdown();
        
        String selectedValue = p.getSelectedValue();
        Assert.assertTrue(selectedValue.contains("Group 1, option 1"), 
            "Выбранное значение должно содержать 'Group 1, option 1'");
    }

    @Test
    public void testSelectOneDropdown() {
        SelectMenuPage p = new SelectMenuPage(driver);
        p.open();
        p.selectOneFromDropdown();
        
        String selectedOne = p.getSelectedOne();
        Assert.assertTrue(selectedOne.contains("Dr."), 
            "Выбранное значение должно содержать 'Dr.'");
    }

    @Test
    public void testOldStyleSelect() {
        SelectMenuPage p = new SelectMenuPage(driver);
        p.open();
        p.selectFromOldStyleSelect("3");

        Assert.assertTrue(driver.getCurrentUrl().contains("select-menu"));
    }

    @Test
    public void testMultipleSelection() {
        SelectMenuPage p = new SelectMenuPage(driver);
        p.open();
        p.selectMultipleValues("volvo", "audi");
        
        Assert.assertTrue(driver.getCurrentUrl().contains("select-menu"));
    }
}



