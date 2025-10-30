package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragDropPage;

public class DragDropTests extends BaseTest {

    @Test
    public void testDragDropPositive() {
        DragDropPage p = new DragDropPage(driver);
        p.open();
        p.dragToTarget();
        Assert.assertTrue(p.getTargetText().toLowerCase().contains("dropped"));
    }
}
