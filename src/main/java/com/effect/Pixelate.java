package com.effect;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 * Created by akshaysinghyaduvanshi on 3/3/15.
 */
public class Pixelate implements Effect {
    public BufferedImage getEffect(BufferedImage image) {
        int PIX_SIZE=10;
        Raster src = image.getData();
        WritableRaster dest = src.createCompatibleWritableRaster();
        for(int y = 0; y < src.getHeight(); y += PIX_SIZE) {
            for(int x = 0; x < src.getWidth(); x += PIX_SIZE) {
                double[] pixel = new double[3];
                pixel = src.getPixel(x, y, pixel);
                for(int yd = y; (yd < y + PIX_SIZE) && (yd < dest.getHeight()); yd++) {
                    for(int xd = x; (xd < x + PIX_SIZE) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }
        image.setData(dest);
        return image;

    }
}
