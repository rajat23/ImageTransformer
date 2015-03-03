package com.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImageCropper {

    public BufferedImage getCroppedImage(BufferedImage image, int xCoordinate, int yCoordinate, int width, int height) throws IOException {
        if(width==0&&height==0)
            return image;
        return image.getSubimage(xCoordinate, yCoordinate, width, height);
    }

}
