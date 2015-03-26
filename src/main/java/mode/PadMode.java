package mode;

import helper.CoordinateCalculator;
import helper.Coordinates;
import helper.ImageDrawer;
import helper.RequestStructure;
import mode.strategies.Context;
import mode.strategies.ShrinkDimension;
import utility.ImageScaler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PadMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        Context context=new Context(new ShrinkDimension());
        Dimension dimension=context.changeDimension(requestStructure.getDimension(), requestStructure.getAspectRatio());
        return new ImageDrawer().drawImageWithPad(requestStructure, image, (int)dimension.getHeight(), (int) dimension.getWidth());
    }
}
