package com.mode.strategies;

import java.awt.*;
public class ExpandDimension implements Strategy {
    public Dimension doOperation(Dimension dimension,float aspectRatio) {

        int width = (int)dimension.getWidth();
        int height =(int)dimension.getHeight();
        if ((width / height) != aspectRatio) {
            if (height > width)
                width = (int) Math.ceil((float) height * aspectRatio);
            else
                height = (int) Math.ceil((float)width / aspectRatio);
        }
        return new Dimension(width,height);
    }
}
