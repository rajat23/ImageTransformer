package com.mode.strategies;

import com.helper.RequestStructure;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by akshaysinghyaduvanshi on 2/19/15.
 */
public class ExpandDimension implements Strategy {
    public Dimension doOperation(Dimension dimension,float aspectRatio) {

        int width = (int)dimension.getWidth();
        int height =(int)dimension.getHeight();
        if ((width / height) != aspectRatio) {
            if (height > width)
                width = (int) ((float)height * aspectRatio);
            else
                height = (int) ((float)width / aspectRatio);
        }
        return new Dimension(width,height);
    }
}
