package fr.tblf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.tblf.model.Slice;

import java.io.File;
import java.io.IOException;

/**
 * Manage serialization and de-serialization of {@link Slice} objects
 */
public class SliceSerialisation {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Serialize {@link Slice} to Json String
     * @param slice a {@link Slice}
     * @return the {@link String} slice
     */
    public static String toJson(Slice slice) {
        try {
            return objectMapper.writeValueAsString(slice);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Serialize {@link Slice} to Json String into a {@link File}
     * @param slice the {@link Slice} to serialize
     * @param output the {@link File} in which write
     * @return the {@link File} containing the output json
     */
    public static File toJsonFile(Slice slice, File output) {
        try {
            objectMapper.writeValue(output, slice);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    /**
     * Read a {@link String} json and generate the corresponding {@link Slice}
     * @param input a Json {@link String}
     * @return The de-serialized {@link Slice}
     */
    public static Slice fromJson(String input) {
        try {
            return objectMapper.readValue(input, Slice.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Read a {@link File} containing a JSON input and generate the corresponding {@link Slice}
     * @param input a {@link File} (with UTF-8 {@link java.nio.charset.Charset}
     * @return the de-serialized {@link Slice}
     */
    public static Slice fromJsonFile(File input) {
        try {
            return objectMapper.readValue(input, Slice.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
