package com.mode;

import com.utility.ImageScaler;
import com.helper.RequestStructure;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FitMode implements Mode {

    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {

        BufferedImage image = requestStructure.getImage();
        int originalHeight = image.getHeight();
        int originalWidth = image.getWidth();
        float originalAspectRatio = (float) originalWidth / (float) originalHeight;
        int height = requestStructure.getHeight();
        int width = requestStructure.getWidth();


        if ((width / height) != originalAspectRatio) {
            if (height > width)
                height = (int) (width / originalAspectRatio);
            else
                width = (int) (height * originalAspectRatio);
        }

        return new ImageScaler().resizeImage(image, width, height);

    }
}
