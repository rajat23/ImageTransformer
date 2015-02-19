package com.mode.strategies;

import com.helper.RequestStructure;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by akshaysinghyaduvanshi on 2/19/15.
 */
public class ShrinkDimension implements Strategy {
    public Dimension doOperation(RequestStructure requestStructure){
        BufferedImage image = requestStructure.getImage();
        float aspectRatio = (float) image.getWidth() / (float) image.getHeight();
        int height = requestStructure.getHeight();
        int width = requestStructure.getWidth();

        if ((width / height) != aspectRatio) {
            if (height > width)
                height = (int) (width / aspectRatio);
            else
                width = (int) (height * aspectRatio);
        }
        return new Dimension(width,height);
    }
}
