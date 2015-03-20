package mode.strategies;

import java.awt.*;

public class Context {
    private AspectRatioStrategy aspectRatioStrategy;

    public Context(AspectRatioStrategy aspectRatioStrategy){
        this.aspectRatioStrategy = aspectRatioStrategy;
    }

    public Dimension executeStrategy(Dimension dimension,float aspectRatio){
        return aspectRatioStrategy.changeDimension(dimension, aspectRatio);
    }
}
