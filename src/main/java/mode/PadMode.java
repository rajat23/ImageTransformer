package mode;

import helper.ImageDrawer;
import UserRequest.RequestList;
import mode.strategies.Context;
import mode.strategies.ShrinkDimension;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PadMode implements Mode {
    public BufferedImage getScaledImage(RequestList requestList) throws IOException {
        BufferedImage image = requestList.getImage();
        Context context=new Context(new ShrinkDimension());
        Dimension dimension=context.changeDimension(requestList.getResponseDimension(), requestList.getAspectRatio());
        return new ImageDrawer().drawImageWithPad(requestList, image, (int)dimension.getHeight(), (int) dimension.getWidth());
    }
}
