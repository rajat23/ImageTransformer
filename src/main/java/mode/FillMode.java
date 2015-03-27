package mode;

import helper.CoordinateCalculator;
import helper.Coordinates;
import mode.strategies.Context;
import mode.strategies.ExpandDimension;
import utility.ImageCropper;
import UserRequest.RequestList;
import utility.ImageScaler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FillMode implements Mode {
    public BufferedImage getScaledImage(RequestList requestList) throws IOException {
        BufferedImage image= requestList.getImage();
        Context context=new Context(new ExpandDimension());
        Dimension dimension=context.changeDimension(requestList.getResponseDimension(), requestList.getAspectRatio());
        image= new ImageScaler().resizeImage(image,(int)dimension.getWidth(),(int)dimension.getHeight());
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(image.getWidth(), image.getHeight(), requestList.getWidth(), requestList.getResponsHeight(), requestList.getOrientation());
        ImageCropper imageCropper = new ImageCropper();
        return imageCropper.getCroppedImage(image, coordinates.getX(), coordinates.getY(), requestList.getWidth(), requestList.getResponsHeight());
    }
}
