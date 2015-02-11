package com.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImageCropper {

    public BufferedImage getCroppedImage(BufferedImage image, int xCoordinate, int yCoordinate, int width, int height) throws IOException {
        return image.getSubimage(xCoordinate, yCoordinate, width, height);
    }

}
