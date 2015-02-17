package com.mode;

import com.utility.ImageStructure;

import java.awt.image.BufferedImage;


public interface Mode {
    ImageStructure getDimensions(BufferedImage image, ImageStructure imageStructure);
}
