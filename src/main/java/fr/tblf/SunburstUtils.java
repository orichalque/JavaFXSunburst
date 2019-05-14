package fr.tblf;

import java.util.Random;

public class SunburstUtils {

    private static final String[] HEX_VALUES= new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    private static Random RANDOM = new Random();

    public static String getRandomColor() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (int i = 0; i < 6; ++i) {
            stringBuilder.append(HEX_VALUES[RANDOM.nextInt(16)]);
        }
        return stringBuilder.toString();
    }
}
