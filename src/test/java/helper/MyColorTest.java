package helper;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MyColorTest {



    @Test
    public void testGetColor() throws Exception {
        String color="0x123456";

        Color returnedColor= ColorFactory.createColor(color);

        assertEquals(returnedColor,Color.decode("0x123456"));

    }
}