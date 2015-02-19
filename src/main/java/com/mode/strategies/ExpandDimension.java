package com.mode.strategies;

import com.helper.RequestStructure;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by akshaysinghyaduvanshi on 2/19/15.
 */
public class ExpandDimension implements Strategy {
    public Dimension doOperation(RequestStructure requestStructure) {
        BufferedImage image = requestStructure.getImage();
        double aspectRatio = (double)image.getWidth() / image.getHeight();
        int width = requestStructure.getWidth();
        int height = requestStructure.getHeight();
        if ((width / height) != aspectRatio) {
            if (height > width)
                width = (int) ((double)height * aspectRatio);
            else
                height = (int) (width / aspectRatio);
        }
        return new Dimension(width,height);
    }
}
