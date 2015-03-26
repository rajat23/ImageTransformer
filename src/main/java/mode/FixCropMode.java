package mode;

import helper.Coordinates;
import helper.RequestStructure;
import utility.ImageCropper;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FixCropMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image=requestStructure.getImage();
        int responseHeight=requestStructure.getHeight();
        int responseWidth=requestStructure.getWidth();
        Coordinates coordinates=requestStructure.getCoordinates();
        int x=coordinates.getX();
        int y=coordinates.getY();

        if(y+responseHeight>image.getHeight()) {
            responseHeight=image.getHeight()-y;
        }
        if(x+responseWidth>image.getWidth()) {
            responseWidth=image.getWidth()-x;
        }

        return new ImageCropper().getCroppedImage(image, coordinates.getX(), coordinates.getY(),responseWidth, responseHeight);
    }
}
