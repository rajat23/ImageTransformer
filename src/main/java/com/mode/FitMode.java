package com.mode;

import com.utility.ImageScaler;
import com.helper.RequestStructure;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FitMode implements Mode {

    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {



        return new ImageScaler().resizeImage(image, width, height);

    }
}
