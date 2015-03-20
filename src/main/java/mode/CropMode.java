package mode;

import helper.CoordinateCalculator;
import helper.Coordinates;
import helper.RequestStructure;
import utility.ImageCropper;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CropMode implements Mode {
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
        if(!requestStructure.isCoordinatesSet())
            coordinates = new CoordinateCalculator().getCoordinates(image.getWidth(), image.getHeight(),responseWidth, responseHeight, requestStructure.getOrientation());
        ImageCropper imageCropper = new ImageCropper();
        return imageCropper.getCroppedImage(image, coordinates.getX(), coordinates.getY(),responseWidth, responseHeight);

    }
}
