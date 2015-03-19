package com.effect;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Pixelate implements Effect {
    int PIX_SIZE;
    public Pixelate(String pix_size){
        PIX_SIZE=Integer.parseInt(pix_size);
    }
    public BufferedImage getEffect(BufferedImage image) {

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
