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

        if ((width / height) != originalAspectRatio) {
            if (height > width)
                height = (int) (width / originalAspectRatio);
            else
                width = (int) (height * originalAspectRatio);
        }
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(requestStructure.getWidth(), requestStructure.getHeight(), width, height, requestStructure.getOrientation());
        return drawImageWithPad(requestStructure, image, height, width, coordinates);
    }

    private BufferedImage drawImageWithPad(RequestStructure requestStructure, BufferedImage image, int height, int width, Coordinates coordinates) throws IOException {
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
