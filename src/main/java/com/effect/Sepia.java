package com.effect;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Sepia implements Effect {
    public BufferedImage getEffect(BufferedImage image) {
        int sepiaIntensity = 30;
        int sepiaDepth = 20;
        int w = image.getWidth();
        int h = image.getHeight();
        WritableRaster raster = image.getRaster();
        int[] pixels = new int[w * h * 3];
        raster.getPixels(0, 0, w, h, pixels);
        for (int i = 0; i < pixels.length; i += 3) {
            int r = pixels[i];
            int g = pixels[i + 1];
            int b = pixels[i + 2];

            int gry = (r + g + b) / 3;
            r = g = b = gry;
            r = r + (sepiaDepth * 2);
            g = g + sepiaDepth;

            if (r > 255) r = 255;
            if (g > 255) g = 255;
            if (b > 255) b = 255;
            b -= sepiaIntensity;
            if (b < 0) b = 0;
            if (b > 255) b = 255;

            pixels[i] = r;
            pixels[i + 1] = g;
            pixels[i + 2] = b;
        }
        raster.setPixels(0, 0, w, h, pixels);
        return image;
    }

}
