package com.utility;

import com.mode.Mode;
import com.mode.ModeFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class ImageScaler {

    public BufferedImage resizeImage(BufferedImage image, int width, int height) throws IOException {
        ModeFactory modeFactory = new ModeFactory();
        Mode fitMode = modeFactory.create("fit");
        RequestStructure requestStructure = fitMode.getDimensions(image, new RequestStructure(0, 0, width, height));

        BufferedImage resizedImage = new BufferedImage(requestStructure.getWidth(), requestStructure.getHeight(), image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }
}