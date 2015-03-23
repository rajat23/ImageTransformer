package effect;

import helper.ExpectedImage;
import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class SepiaTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);

        Effectible effectible =new EffectFactory().create("sepia");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(140,120,70);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }
    @Test
    public void testGetEffectLargerValues() throws Exception {
        BufferedImage image=new SampleImage().get10by10(255);

        Effectible effectible =new EffectFactory().create("sepia");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(255,255,225);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }
    @Test
    public void testGetEffectLesserValues() throws Exception {
        BufferedImage image=new SampleImage().get10by10(0);

        Effectible effectible =new EffectFactory().create("sepia");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(40,20,0);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }

    @Test
    public void testGetEffectForParameter() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);

        Effectible effectible =new EffectFactory().create("sepia_60");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(140,120,40);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }
}