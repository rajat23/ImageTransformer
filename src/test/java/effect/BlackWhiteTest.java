package effect;

import helper.ExpectedImage;
import helper.SampleImage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class BlackWhiteTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image = new SampleImage().get2by2();
        Effectible effectible =new EffectFactory().create("blackwhite");

        image= effectible.getEffect(image);
        Color expectedColor = new Color(0,0,0);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));
    }

    @Test
    public void testGetEffectForParameter() throws Exception {
        BufferedImage image = new SampleImage().get3by2();
        Effectible effectible =new EffectFactory().create("blackwhite_0");

        image= effectible.getEffect(image);
        Color expectedColor = new Color(255,255,255);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }
}