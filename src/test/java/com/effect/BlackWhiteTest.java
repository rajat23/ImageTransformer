package com.effect;

import com.helper.ImageReader;
import com.rotate.Angle;
import com.rotate.AngleFactory;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static org.junit.Assert.*;

public class BlackWhiteTest {

    @Test
    public void testGetEffect() throws Exception {
        BufferedImage image=new BufferedImage(2,2,BufferedImage.TYPE_3BYTE_BGR);
        image.setRGB(0, 0, new Color(22, 22, 22).getRGB());
        image.setRGB(1, 0, new Color(222, 222, 222).getRGB());
        image.setRGB(0, 1, new Color(211, 211, 211).getRGB());
        image.setRGB(1, 1, new Color(44, 44, 44).getRGB());

        Effect effect=new EffectFactory().create("blackwhite");
        image=effect.getEffect(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(0,0,0));
        assertEquals(new Color(image.getRGB(1,0)),new Color(255,255,255));
        assertEquals(new Color(image.getRGB(0,1)),new Color(255,255,255));
        assertEquals(new Color(image.getRGB(1,1)),new Color(0,0,0));

    }

    @Test
    public void testGetEffectForParameter() throws Exception {
        BufferedImage image=new BufferedImage(2,2,BufferedImage.TYPE_3BYTE_BGR);
        image.setRGB(0, 0, new Color(122, 122, 122).getRGB());
        image.setRGB(1, 0, new Color(222, 222, 222).getRGB());
        image.setRGB(0, 1, new Color(211, 211, 211).getRGB());
        image.setRGB(1, 1, new Color(144, 144, 144).getRGB());

        Effect effect=new EffectFactory().create("blackwhite_150");
        image=effect.getEffect(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(0,0,0));
        assertEquals(new Color(image.getRGB(1,0)),new Color(255,255,255));
        assertEquals(new Color(image.getRGB(0,1)),new Color(255,255,255));
        assertEquals(new Color(image.getRGB(1,1)),new Color(0,0,0));

    }
}