package effect;

import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class PixelateTest {
    @Test
    public void testGetEffectDefault() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        Color color=new Color(123,200,250);
        image.setRGB(0,0,color.getRGB());

        Effectible effectible =new EffectFactory().create("pixelate");
        image= effectible.getEffect(image);

        boolean isCorrect=true;
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color newColor=new Color(image.getRGB(x,y));
                if(!newColor.equals(color))
                    isCorrect=false;
            }
        }
        assertEquals(isCorrect,true);
    }

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new SampleImage().get10by10(100);
        Color color=new Color(123,200,250);
        image.setRGB(0,0,color.getRGB());

        Effectible effectible =new EffectFactory().create("pixelate_10");
        image= effectible.getEffect(image);

        boolean isCorrect=true;
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color newColor=new Color(image.getRGB(x,y));
                if(!newColor.equals(color))
                    isCorrect=false;
            }
        }
        assertEquals(isCorrect,true);
    }
}
