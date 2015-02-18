package com.mode;

import com.helper.CoordinateCalculator;
import com.helper.Coordinates;
import com.utility.ImageCropper;
import com.helper.RequestStructure;
import com.utility.ImageScaler;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FillMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        double aspectRatio = (double)image.getWidth() / image.getHeight();
        int width = requestStructure.getWidth();
        int height = requestStructure.getHeight();

         if ((width / height) != aspectRatio) {
            if (height > width)
                width = (int) ((double)height * aspectRatio);
            else
                height = (int) (width / aspectRatio);
        }
        image= new ImageScaler().resizeImage(image,width,height);
        CoordinateCalculator coordinateCalculator = new CoordinateCalculator();

        Coordinates coordinates = coordinateCalculator.getCoordinates(image.getWidth(), image.getHeight(), width, height, requestStructure.getOrientation());
        ImageCropper imageCropper = new ImageCropper();
        return imageCropper.getCroppedImage(image, coordinates.getX(), coordinates.getY(),requestStructure.getWidth(), requestStructure.getHeight());
    }
}
