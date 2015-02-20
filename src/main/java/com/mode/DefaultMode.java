package com.mode;

import com.helper.RequestStructure;
import com.utility.ImageScaler;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class DefaultMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        return new ImageScaler().resizeImage(image,requestStructure.getWidth(),requestStructure.getHeight());
    }
}