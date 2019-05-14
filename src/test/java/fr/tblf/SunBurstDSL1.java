package fr.tblf;

import org.junit.Test;

import java.io.File;

public class SunBurstDSL1 {

    @Test
    public void display() {
        File f = new File("src/main/resources/xdsml1Values.txt");
        Sunburst.show(f);
    }
}
