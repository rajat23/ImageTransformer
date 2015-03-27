package mode;

import mode.strategies.Context;
import mode.strategies.ShrinkDimension;
import utility.ImageScaler;
import UserRequest.RequestList;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LimitMode implements Mode {

    public BufferedImage getScaledImage(RequestList requestList) throws IOException {
        BufferedImage image = requestList.getImage();
        if (requestList.getResponsHeight() > image.getHeight() || requestList.getWidth() > image.getWidth())
            return image;
        Context context=new Context(new ShrinkDimension());
        Dimension dimension=context.changeDimension(requestList.getResponseDimension(), requestList.getAspectRatio());
        return new ImageScaler().resizeImage(image,(int)dimension.getWidth(),(int)dimension.getHeight());
    }
}

