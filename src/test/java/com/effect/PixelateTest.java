/*package com.effect;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class PixelateTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new BufferedImage(10,10,BufferedImage.TYPE_3BYTE_BGR);
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, new Color(123, 45, 65).getRGB());
            }
        }
        Color color=new Color(122,23,231);
        image.setRGB(0,0,color.getRGB());
        Effect effect=new EffectFactory().create("pixelate");
        image=effect.getEffect(image);

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
}*/