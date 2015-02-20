package com.mode;
import com.helper.CoordinateCalculator;
import com.helper.Coordinates;
import com.helper.RequestStructure;
import com.utility.ImageCropper;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class CropMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image=requestStructure.getImage();
        int responseHeight=requestStructure.getHeight();
        int responseWidth=requestStructure.getWidth();
        if(responseHeight>image.getHeight()) {
            responseHeight=image.getHeight();
        }
        if(responseWidth>image.getWidth()) {
            responseWidth=image.getWidth();
        }
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(image.getWidth(), image.getHeight(),responseWidth, responseHeight, requestStructure.getOrientation());
        ImageCropper imageCropper = new ImageCropper();
        return imageCropper.getCroppedImage(image, coordinates.getX(), coordinates.getY(),responseWidth, responseHeight);

    }
}
