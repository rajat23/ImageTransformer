package com.mode.strategies;

import java.awt.*;
public class ShrinkDimension implements Strategy {
    public Dimension doOperation(Dimension dimension,float aspectRatio){
        int width = (int)dimension.getWidth();
        int height =(int)dimension.getHeight();
        if (aspectRatio>1.0f)
            height = (int) Math.ceil(width / aspectRatio);
        else if(aspectRatio<1.0f)
            width = (int) Math.ceil(height * aspectRatio);
        return new Dimension(width,height);
    }
}
