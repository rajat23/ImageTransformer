package effect;

import helper.ExpectedImage;
import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.assertTrue;

public class BlackWhiteTest {


    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image = new SampleImage().getImage(2,2);
        Effectible effectible =new EffectFactory().create("blackwhite");

        image= effectible.getEffect(image);
        Color expectedColor = new Color(0,0,0);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));
    }

    @Test
    public void testGetEffectForParameter() throws Exception {
        BufferedImage image = new SampleImage().getImage(3,2);
        Effectible effectible =new EffectFactory().create("blackwhite_0");

        image= effectible.getEffect(image);
        Color expectedColor = new Color(255,255,255);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }
}