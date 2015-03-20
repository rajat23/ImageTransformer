package mode;

import helper.CoordinateCalculator;
import helper.Coordinates;
import mode.strategies.Context;
import mode.strategies.ExpandDimension;
import utility.ImageCropper;
import helper.RequestStructure;
import utility.ImageScaler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FillMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image=requestStructure.getImage();
        Context context=new Context(new ExpandDimension());
        Dimension dimension=context.executeStrategy(requestStructure.getDimension(),requestStructure.getAspectRatio());
        image= new ImageScaler().resizeImage(image,(int)dimension.getWidth(),(int)dimension.getHeight());
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(image.getWidth(), image.getHeight(),requestStructure.getWidth(), requestStructure.getHeight(), requestStructure.getOrientation());
        ImageCropper imageCropper = new ImageCropper();
        return imageCropper.getCroppedImage(image, coordinates.getX(), coordinates.getY(),requestStructure.getWidth(), requestStructure.getHeight());
    }
}
