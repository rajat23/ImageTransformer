package mode;

import mode.strategies.Context;
import mode.strategies.ShrinkDimension;
import utility.ImageScaler;
import helper.RequestStructure;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LimitMode implements Mode {

    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        if (requestStructure.getHeight() > image.getHeight() || requestStructure.getWidth() > image.getWidth())
            return image;
        Context context=new Context(new ShrinkDimension());
        Dimension dimension=context.executeStrategy(requestStructure.getDimension(),requestStructure.getAspectRatio());
        return new ImageScaler().resizeImage(image,(int)dimension.getWidth(),(int)dimension.getHeight());
    }
}

