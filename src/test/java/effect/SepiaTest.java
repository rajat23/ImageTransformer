package effect;

import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class SepiaTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        Color expectedColor=new Color(140,120,70);

        Effectible effectible =new EffectFactory().create("sepia");
        image= effectible.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }
    @Test
    public void testGetEffectLargerValues() throws Exception {
        BufferedImage image=new SampleImage().get10by10(255);
        Color expectedColor=new Color(255,255,225);

        Effectible effectible =new EffectFactory().create("sepia");
        image= effectible.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }
    @Test
    public void testGetEffectLesserValues() throws Exception {
        BufferedImage image=new SampleImage().get10by10(0);
        Color expectedColor=new Color(40,20,0);

        Effectible effectible =new EffectFactory().create("sepia");
        image= effectible.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }

    @Test
    public void testGetEffectForParameter() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        Color expectedColor=new Color(140,120,40);

        Effectible effectible =new EffectFactory().create("sepia_60");
        image= effectible.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }
}