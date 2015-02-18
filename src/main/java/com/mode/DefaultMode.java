package com.mode;

import com.helper.RequestStructure;
import com.utility.ImageScaler;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class DefaultMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();

        double originalAspectRatio = (double) image.getWidth() /  image.getHeight();
        int height = requestStructure.getHeight();
        int width = requestStructure.getWidth();
        if (height == 0) {
            height =(int) Math.floor((double) width / originalAspectRatio);

        } else if (width == 0) {
            width =(int) Math.floor((double) height * originalAspectRatio);

        }
        return new ImageScaler().resizeImage(image,width,height);
    }
}
