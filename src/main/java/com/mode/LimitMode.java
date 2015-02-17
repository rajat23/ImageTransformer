package com.mode;

import com.utility.ImageStructure;

import java.awt.image.BufferedImage;

public class LimitMode implements Mode {
    public ImageStructure getDimensions(BufferedImage image, ImageStructure imageStructure) {
        if (imageStructure.getHeight() > image.getHeight() || imageStructure.getWidth() > image.getWidth())
            return new ImageStructure(0, 0, image.getWidth(), image.getHeight());

        return new FitMode().getDimensions(image, imageStructure);

    }
}

