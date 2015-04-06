package mode;

import helper.crop.orientation.CropFactory;
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

        responseHeight=getCheckedValues(responseHeight,image.getHeight());
        responseWidth=getCheckedValues(responseWidth,image.getWidth());

        Coordinates cropCoordinates=new CropFactory().create(requestList.getOrientation()).getCoordinates(image.getWidth(), image.getHeight(), responseWidth, responseHeight);
        return new ImageCropper().getCroppedImage(image, cropCoordinates.getX(), cropCoordinates.getY(), responseWidth, responseHeight);

    }

    public int getCheckedValues(int responseValue,int imageParameterValue) {
        if(responseValue>imageParameterValue)
            return imageParameterValue;
        return responseValue;

    }
}
