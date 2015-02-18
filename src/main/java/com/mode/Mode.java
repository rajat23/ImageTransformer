package com.mode;

import com.helper.RequestStructure;

import java.awt.image.BufferedImage;
import java.io.IOException;


public interface Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException;
}
