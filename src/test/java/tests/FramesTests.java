package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;

public class FramesTests extends BaseTest {

    @Test
    public void testFramesContent() {
        FramesPage p = new FramesPage(driver);
        p.open();
        String t1 = p.getTextFromFrame1();
        String t2 = p.getTextFromFrame2();
        Assert.assertTrue(t1.length() > 0);
        Assert.assertTrue(t2.length() > 0);
    }
}
