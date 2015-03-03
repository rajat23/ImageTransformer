package com.effect;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * Created by akshaysinghyaduvanshi on 3/3/15.
 */
public class BlackWhite implements Effect {
    public BufferedImage getEffect(BufferedImage image) {
        int threshold=128;
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        result.getGraphics().drawImage(image, 0, 0, null);
        WritableRaster raster = result.getRaster();
        int[] pixels = new int[image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            raster.getPixels(0, y, image.getWidth(), 1, pixels);
            for (int i = 0; i < pixels.length; i++) {
                if (pixels[i] < threshold) pixels[i] = 0;
                else pixels[i] = 255;
            }
            raster.setPixels(0, y, image.getWidth(), 1, pixels);
        }
        return result;

    }
}
