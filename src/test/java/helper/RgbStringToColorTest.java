package helper;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class RgbStringToColorTest {

    @Test
    public void testGetColorFormRGB() throws Exception {
        String colorString="r_123,g_211,b_232";

        Color color=new RgbStringToColor().getColorFormRGB(colorString);

        assertEquals(color,new Color(123,211,232));
    }
    @Test
    public void testGetColorFormRGBforR() throws Exception {
        String colorString="r_123";

        Color color= new RgbStringToColor().getColorFormRGB(colorString);

        assertEquals(color,new Color(123,0,0));
    }
    @Test
    public void testGetColorFormRGBforG() throws Exception {
        String colorString="g_123";

        Color color= new RgbStringToColor().getColorFormRGB(colorString);

        assertEquals(color,new Color(0,123,0));
    }
    @Test
    public void testGetColorFormRGBforB() throws Exception {
        String colorString="b_123";

        Color color= new RgbStringToColor().getColorFormRGB(colorString);

        assertEquals(color,new Color(0,0,123));
    }

}