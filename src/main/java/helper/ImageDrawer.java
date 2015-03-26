package helper;

import utility.ImageScaler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageDrawer {

    public BufferedImage drawImageWithPad(RequestStructure requestStructure, BufferedImage image, int height, int width) throws IOException {
        if(height==0&&width==0)
            return image;
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(requestStructure.getWidth(), requestStructure.getHeight(), width,height, requestStructure.getOrientation());
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
