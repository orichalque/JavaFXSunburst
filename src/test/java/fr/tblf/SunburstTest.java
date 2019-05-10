package fr.tblf;

import fr.tblf.model.Slice;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SunburstTest {
    @Test
    public void checkShowSunburst() throws InterruptedException {
        Sunburst.showSunburst(new Slice("name", "green", new Slice[]{new Slice("name2", "blue", 1), new Slice("name3", "red", 3)}));
    }
}
