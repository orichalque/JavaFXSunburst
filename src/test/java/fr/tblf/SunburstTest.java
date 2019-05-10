package fr.tblf;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SunburstTest {
    @Test
    public void checkShowSunburst() throws InterruptedException {
        String s =                 "{\n" +
                "    \"name\":\"name\",\n" +
                "    \"color\":\"green\",\n" +
                "    \"children\":\n" +
                "        [\n" +
                "            {\n" +
                "                \"name\":\"name2\",\n" +
                "                \"color\":\"blue\",\n" +
                "                \"children\":[],\n" +
                "                \"size\":1.0\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\":\"name3\",\n" +
                "                \"color\":\"red\",\n" +
                "                \"children\": [\n" +
                "                                {\n" +
                "                                    \"name\":\"name4\",\n" +
                "                                    \"color\":\"purple\",\n" +
                "                                    \"children\":[],\n" +
                "                                    \"size\":1.0\n" +
                "                                },\n" +
                "                                {\n" +
                "                                    \"name\":\"name5\",\n" +
                "                                    \"color\":\"yellow\",\n" +
                "                                    \"children\":[],\n" +
                "                                    \"size\":3.0\n" +
                "                                }    \n" +
                "                            ]            \n" +
                "            }       \n" +
                "        ],\n" +
                "    \"size\":0.0\n" +
                "}";
        System.out.println(s);
        Sunburst.show(SliceSerialisation.fromJson(s));
    }
}
