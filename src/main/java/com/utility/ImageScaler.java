package com.utility;

import com.mode.Mode;
import com.mode.ModeFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImageScaler {

    public BufferedImage resizeImage(BufferedImage image, int width, int height) throws IOException {
        if(width==0&&height==0)
            return image;
        BufferedImage resizedImage = new BufferedImage(width,height, image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }
}