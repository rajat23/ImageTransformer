package com.mode;

import com.utility.ImageStructure;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LimitMode implements Mode{
    public ImageStructure getDimensions(BufferedImage image, ImageStructure imageStructure){


        return new ImageStructure(0,0,300,400);
    }
}
