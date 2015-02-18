package com.mode;

import com.utility.ImageScaler;
import com.utility.RequestStructure;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FitMode implements Mode {

    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {

        BufferedImage image=requestStructure.getImage();
        int originalHeight = requestStructure.getImage().getHeight();
        int originalWidth = requestStructure.getImage().getWidth();
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

        return new ImageScaler().resizeImage(image,width,height);

    }
}
