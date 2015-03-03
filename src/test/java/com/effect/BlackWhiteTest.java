package com.effect;

import com.helper.ImageReader;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Collection;

import static org.junit.Assert.*;

public class BlackWhiteTest {

    @Test
    public void testGetEffect() throws Exception {
        String name="sample.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        Effect effect=new EffectFactory().create("blackwhite");
        image=effect.getEffect(image);
        
        int isBlackWhite=1;
        int width=image.getWidth();
        int height=image.getHeight();
        for(int j=0;j<height;j++)
            for (int i=0;i<width;i++){
                Color color=new Color(image.getRGB(i,j));
                int r=color.getRed();
                if(r!=0&&r!=255){
                    isBlackWhite=0;}
            }
        assertEquals(1,isBlackWhite);

    }
}