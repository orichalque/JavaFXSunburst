package fr.tblf;

import fr.tblf.model.Slice;
import org.junit.Assert;
import org.junit.Test;

public class SliceSerialisationTest {

    @Test
    public void checkToJsonNoArrayOK() {
        String json = "{" +
                "\"name\": \"name\"," +
                "\"color\": \"green\","+
                "\"size\": 1 "+
                "}";

        Slice slice = SliceSerialisation.fromJson(json);
        Assert.assertNotNull(slice);
        Assert.assertEquals("name", slice.getName());
        Assert.assertEquals("green", slice.getColor());
        Assert.assertEquals(1, slice.getSize(), 0.0001);
    }

    @Test
    public void checkToJsonArrayOK() {
        String json = "{" +
                "\"name\": \"name\"," +
                "\"color\": \"green\","+
                "\"size\": 1, "+
                "\"children\": []"+
                "}";

        Slice slice = SliceSerialisation.fromJson(json);
        Assert.assertNotNull(slice);
        Assert.assertEquals("name", slice.getName());
        Assert.assertEquals("green", slice.getColor());
        Assert.assertEquals(1, slice.getSize(), 0.0001);
        Assert.assertTrue(slice.getChildren().length == 0);
    }


    @Test
    public void checkToStringNoArrayOk() {
        Slice slice = new Slice("name", "green", new Slice[0]);
        String value = SliceSerialisation.toJson(slice);
        Slice slice2 = SliceSerialisation.fromJson(value);
        Assert.assertEquals(slice, slice2);
    }

    @Test
    public void checkToStringArrayOk() {
        Slice[] children = new Slice[2];

        Slice child1 = new Slice("child1", "blue");
        Slice child2 = new Slice("child2", "red");
        children[0] = child1;
        children[1] = child2;
        Slice parent = new Slice("name", "green", children);

        String value = SliceSerialisation.toJson(parent);
        Slice slice2 = SliceSerialisation.fromJson(value);
        Assert.assertEquals(parent, slice2);
    }

}