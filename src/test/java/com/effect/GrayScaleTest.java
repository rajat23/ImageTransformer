package com.effect;

import com.helper.ImageReader;
import org.junit.Test;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class GrayScaleTest {

    @Test
    public void testGetEffect() throws Exception {

        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        boolean isEqual=true;

        BufferedImage grayScaleImage=new GrayScale().getEffect(image);
        int height=grayScaleImage.getHeight();
        int width=grayScaleImage.getWidth();
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < width; j++) {
                Color color=new Color(grayScaleImage.getRGB(j,i));
                int red=color.getRed();
                int blue=color.getBlue();
                int green=color.getGreen();

                if(red!=blue||red!=green||blue!=green) {
                    isEqual=false;
                }
                
            }
            
        }
        assertTrue(isEqual);
        

    }
}