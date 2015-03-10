package com.rotate;


import java.awt.image.BufferedImage;

public class AngledFlip implements Angle {
    public BufferedImage rotateImage(BufferedImage image, String angle) {
        if(angle.equals("0"))
            return image;
    }
}
