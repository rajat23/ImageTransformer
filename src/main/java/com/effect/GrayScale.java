package com.effect;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by rajatchandak on 03/03/15.
 */

public class GrayScale implements Effect {
    public BufferedImage getEffect(BufferedImage image) {

        int width = image.getWidth();
        int height = image.getHeight();

        for(int i=0; i<height; i++){

            for(int j=0; j<width; j++){

                Color c = new Color(image.getRGB(j, i));
                int red = (int)(c.getRed() * 0.299);
                int green = (int)(c.getGreen() * 0.587);
                int blue = (int)(c.getBlue() *0.114);
                Color newColor = new Color(red+green+blue,

                        red+green+blue,red+green+blue);

                image.setRGB(j,i,newColor.getRGB());
            }
        }
        return image;
    }
}
