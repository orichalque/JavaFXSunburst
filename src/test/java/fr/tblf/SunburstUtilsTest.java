package fr.tblf;

import org.junit.Assert;
import org.junit.Test;

public class SunburstUtilsTest {

    @Test
    public void checkGetRandomColor() {
        String color = SunburstUtils.getRandomColor();
        Assert.assertEquals(7, color.length());
        Assert.assertTrue(color.startsWith("#"));
    }
}
