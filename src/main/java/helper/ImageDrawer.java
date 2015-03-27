package helper;

import UserRequest.RequestList;
import utility.ImageScaler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageDrawer {

    public BufferedImage drawImageWithPad(RequestList requestList, BufferedImage image, int height, int width) throws IOException {
        if(height==0&&width==0)
            return image;
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(requestList.getWidth(), requestList.getResponsHeight(), width,height, requestList.getOrientation());
        BufferedImage paddedImage = new BufferedImage(requestList.getWidth(), requestList.getResponsHeight(), image.getType());
        Graphics graphics = paddedImage.getGraphics();
        graphics.setColor(requestList.getColor());
        graphics.fillRect(0, 0, requestList.getWidth(), requestList.getResponsHeight());
        image=new ImageScaler().resizeImage(image,width,height);
        graphics.drawImage(image, coordinates.getX(), coordinates.getY(), null);
        graphics.dispose();
        return paddedImage;
    }

}
