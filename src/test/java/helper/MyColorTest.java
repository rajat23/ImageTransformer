package helper;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MyColorTest {



    @Test
    public void testGetColor() throws Exception {
        String color="0x123456";

        Color returnedColor= MyColor.getColor(color);

        assertEquals(returnedColor,Color.decode("0x123456"));

    }

    @Test
    public void testGetColorFormRGB() throws Exception {
        String colorString="r_123,g_211,b_232";

        Color color=MyColor.getColorFormRGB(colorString);

        assertEquals(color,new Color(123,211,232));
    }
    @Test
    public void testGetColorFormRGBforR() throws Exception {
        String colorString="r_123";

        Color color=MyColor.getColorFormRGB(colorString);

        assertEquals(color,new Color(123,0,0));
    }
    @Test
    public void testGetColorFormRGBforG() throws Exception {
        String colorString="g_123";

        Color color=MyColor.getColorFormRGB(colorString);

        assertEquals(color,new Color(0,123,0));
    }
    @Test
    public void testGetColorFormRGBforB() throws Exception {
        String colorString="b_123";

        Color color=MyColor.getColorFormRGB(colorString);

        assertEquals(color,new Color(0,0,123));
    }
}