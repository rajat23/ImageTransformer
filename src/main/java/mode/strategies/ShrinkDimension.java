package mode.strategies;

import java.awt.*;

public class ShrinkDimension implements AspectRatioStrategy {

    public Dimension changeDimension(Dimension dimension, float aspectRatio){
        int width = (int)dimension.getWidth();
        int height =(int)dimension.getHeight();
        if (aspectRatio>(float)width/(float)height)
            height =  Math.round(width / aspectRatio);
        else if(aspectRatio<(float)width/(float)height)
            width =  Math.round(height * aspectRatio);
        return new Dimension(width,height);
    }

}
