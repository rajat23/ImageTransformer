package com.mode;

import com.utility.RequestStructure;

import java.awt.image.BufferedImage;


public interface Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure);
}
