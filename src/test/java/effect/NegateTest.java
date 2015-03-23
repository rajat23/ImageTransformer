package effect;

import helper.ExpectedImage;
import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class NegateTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);

        Effectible effectible =new EffectFactory().create("negate");
        image= effectible.getEffect(image);
        Color expectedColor=new Color(155,155,155);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));
    }
}