package com.mode;

import com.utility.RequestStructure;

import java.awt.image.BufferedImage;

public class FitMode implements Mode {
    public RequestStructure getDimensions(BufferedImage image, RequestStructure requestStructure) {
        int originalHeight = image.getHeight();
        int originalWidth = image.getWidth();
        float originalAspectRatio = (float) originalWidth / (float) originalHeight;
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

        return new RequestStructure(0, 0, width, height);


    }
}
