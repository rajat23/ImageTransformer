package mode;

import UserRequest.RequestList;
import java.awt.image.BufferedImage;
import java.io.IOException;


public interface Mode {
    public BufferedImage getScaledImage(RequestList requestList) throws IOException;
}
