package com.mode.strategies;

import com.helper.RequestStructure;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by akshaysinghyaduvanshi on 2/19/15.
 */
public class ShrinkDimension implements Strategy {
    public Dimension doOperation(Dimension dimension,float aspectRatio){
        int width = (int)dimension.getWidth();
        int height =(int)dimension.getHeight();

        if ((width / height) != aspectRatio) {
            if (height > width)
                height = (int) Math.ceil(width / aspectRatio);
            else
                width = (int) Math.ceil(height * aspectRatio);
        }
        return new Dimension(width,height);
    }
}
