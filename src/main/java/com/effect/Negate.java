package com.effect;


import java.awt.image.BufferedImage;

public class Negate implements Effect {
    public BufferedImage getEffect(BufferedImage sourceImage) {

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = sourceImage.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                p = (a << 24) | (r << 16) | (g << 8) | b;
                sourceImage.setRGB(x, y, p);
            }
        }
        return sourceImage;

    }
}
