package com.mode;

import apple.awt.CImage;
import com.utility.ImageScaler;
import com.utility.RequestStructure;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LimitMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        if (requestStructure.getHeight() > image.getHeight() || requestStructure.getWidth() > image.getWidth())
            return image;


        float originalAspectRatio = (float) image.getWidth() / (float) image.getHeight();
        int height = requestStructure.getHeight();
        int width = requestStructure.getWidth();
        if (height == 0) {
            height = (int) (width / originalAspectRatio);

        } else if (width == 0) {
            width = (int) (height * originalAspectRatio);

        } else if ((width / height) != originalAspectRatio) {
            if (height > width)
                height = (int) (width / originalAspectRatio);
            else
                width = (int) (height * originalAspectRatio);
        }


        return new ImageScaler().resizeImage(image,width,height);
    }
}

