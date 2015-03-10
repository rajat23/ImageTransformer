package com.rotate;


import java.awt.image.BufferedImage;

public class NoEffect implements Angle {
    public BufferedImage rotateImage(BufferedImage image, String angle) {
        return image;
    }
}
