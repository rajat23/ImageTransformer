package com.mode;

import com.utility.RequestStructure;

import java.awt.image.BufferedImage;


public interface Mode {
    RequestStructure getDimensions(BufferedImage image, RequestStructure requestStructure);
}
