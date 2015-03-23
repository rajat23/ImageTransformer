package effect;

import helper.ExpectedImage;
import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class PixelateTest {
    @Test
    public void testGetEffectDefault() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        image.setRGB(0,0,new Color(123,200,250).getRGB());

        Effectible effectible =new EffectFactory().create("pixelate");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(123,200,250);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));
    }

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        image.setRGB(0,0,new Color(123,200,250).getRGB());

        Effectible effectible =new EffectFactory().create("pixelate_10");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(123,200,250);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));
    }
}
