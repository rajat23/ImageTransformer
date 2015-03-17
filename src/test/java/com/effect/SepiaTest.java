package com.effect;

import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class SepiaTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new BufferedImage(10,10,BufferedImage.TYPE_3BYTE_BGR);
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, new Color(100, 100, 100).getRGB());
            }
        }
        Color expectedColor=new Color(140,120,70);

        Effect effect=new EffectFactory().create("sepia");
        image=effect.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }
    @Test
    public void testGetEffectLargerValues() throws Exception {
        BufferedImage image=new BufferedImage(10,10,BufferedImage.TYPE_3BYTE_BGR);
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, new Color(255, 255, 255).getRGB());
            }
        }
        Color expectedColor=new Color(255,255,225);

        Effect effect=new EffectFactory().create("sepia");
        image=effect.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }
    @Test
    public void testGetEffectLesserValues() throws Exception {
        BufferedImage image=new BufferedImage(10,10,BufferedImage.TYPE_3BYTE_BGR);
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, new Color(0, 0, 0).getRGB());
            }
        }
        Color expectedColor=new Color(40,20,0);

        Effect effect=new EffectFactory().create("sepia");
        image=effect.getEffect(image);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                assertEquals(color,expectedColor);
            }
        }

    }
}