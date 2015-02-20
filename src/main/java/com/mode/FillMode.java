package com.mode;

import com.helper.CoordinateCalculator;
import com.helper.Coordinates;
import com.mode.strategies.Context;
import com.mode.strategies.ExpandDimension;
import com.utility.ImageCropper;
import com.helper.RequestStructure;
import com.utility.ImageScaler;

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
