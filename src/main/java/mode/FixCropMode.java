package mode;

import helper.Coordinates;
import UserRequest.RequestList;
import utility.ImageCropper;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FixCropMode implements Mode {
    public BufferedImage getScaledImage(RequestList requestList) throws IOException {
        BufferedImage image= requestList.getImage();
        int responseHeight= requestList.getResponsHeight();
        int responseWidth= requestList.getResponseWidth();
        Coordinates coordinates= requestList.getCoordinates();
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
