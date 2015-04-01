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

        responseHeight=getCheckedValues(responseHeight,image.getHeight(),requestList.getCoordinates().getY());
        responseWidth=getCheckedValues(responseWidth,image.getWidth(),requestList.getCoordinates().getX());

        return new ImageCropper().getCroppedImage(image, requestList.getCoordinates().getX(), requestList.getCoordinates().getY(), responseWidth, responseHeight);
    }

    public int getCheckedValues(int responseValue,int imageValue,int coordinateValue) {
        if(coordinateValue+responseValue>imageValue)
            return imageValue-coordinateValue;
        return responseValue;
    }
}
