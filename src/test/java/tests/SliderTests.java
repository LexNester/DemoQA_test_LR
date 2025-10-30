package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SliderPage;

public class SliderTests extends BaseTest {

    @Test
    public void testSliderMove() throws InterruptedException {
        SliderPage p = new SliderPage(driver);
        p.open();
        p.moveSliderTo(80);
        Thread.sleep(500);
        Assert.assertTrue(p.getSliderValue() >= 75);
    }
}
