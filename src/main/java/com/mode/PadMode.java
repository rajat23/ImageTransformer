package com.mode;

import com.helper.CoordinateCalculator;
import com.helper.Coordinates;
import com.helper.RequestStructure;
import com.utility.ImageScaler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PadMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        double originalAspectRatio = (double) image.getWidth() / image.getHeight();
        int height = requestStructure.getHeight();
        int width = requestStructure.getWidth();
        if (height == 0) {
            height = (int) Math.floor((double) width / originalAspectRatio);

        } else if (width == 0) {
            width = (int) Math.floor((double) height * originalAspectRatio);

        } else if ((width / height) != originalAspectRatio) {
            if (height > width)
                height = (int) (width / originalAspectRatio);
            else
                width = (int) (height * originalAspectRatio);
        }
        CoordinateCalculator coordinateCalculator = new CoordinateCalculator();
        Coordinates coordinates = coordinateCalculator.getCoordinates(image.getWidth(), image.getHeight(), width, height, requestStructure.getOrientation());
        BufferedImage paddedImage = new BufferedImage(requestStructure.getWidth(), requestStructure.getHeight(), image.getType());
        Graphics graphics = paddedImage.getGraphics();

        graphics.setColor(requestStructure.getColor());
        graphics.fillRect(0, 0, requestStructure.getWidth(), requestStructure.getHeight());
        image=new ImageScaler().resizeImage(image,width,height);
        graphics.drawImage(image, coordinates.getX(), coordinates.getY(), null);
        graphics.dispose();
        return paddedImage;
    }
}
