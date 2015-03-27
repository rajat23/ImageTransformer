package mode;

import helper.CoordinateCalculator;
import helper.Coordinates;
import UserRequest.RequestList;
import utility.ImageCropper;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CropMode implements Mode {
    public BufferedImage getScaledImage(RequestList requestList) throws IOException {
        BufferedImage image= requestList.getImage();
        int responseHeight= requestList.getResponsHeight();
        int responseWidth= requestList.getWidth();
        if(responseHeight>image.getHeight()) {
            responseHeight=image.getHeight();
        }
        if(responseWidth>image.getWidth()) {
            responseWidth=image.getWidth();
        }
        Coordinates coordinates=new CoordinateCalculator().getCoordinates(image.getWidth(), image.getHeight(),responseWidth, responseHeight, requestList.getOrientation());
        return new ImageCropper().getCroppedImage(image, coordinates.getX(), coordinates.getY(),responseWidth, responseHeight);

    }
}
