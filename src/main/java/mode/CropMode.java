package mode;

import helper.crop.coordinates.CropFactory;
import helper.crop.coordinates.Cropable;
import helper.Coordinates;
import UserRequest.RequestList;
import utility.ImageCropper;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CropMode implements Mode {
    public BufferedImage getScaledImage(RequestList requestList) throws IOException {
        BufferedImage image= requestList.getImage();
        int responseHeight= requestList.getResponsHeight();
        int responseWidth= requestList.getResponseWidth();
        if(responseHeight>image.getHeight()) {
            responseHeight=image.getHeight();
        }
        if(responseWidth>image.getWidth()) {
            responseWidth=image.getWidth();
        }
        Coordinates cropCoordinates=new CropFactory().create(requestList.getOrientation()).getCoordinates(image.getWidth(), image.getHeight(), responseWidth, responseHeight);
        return new ImageCropper().getCroppedImage(image, cropCoordinates.getX(), cropCoordinates.getY(), responseWidth, responseHeight);

    }
}
