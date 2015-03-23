package effect;

import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class NegateTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        Color expectedColor=new Color(155,155,155);

        Effectible effectible =new EffectFactory().create("negate");
        image= effectible.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }


    }
}