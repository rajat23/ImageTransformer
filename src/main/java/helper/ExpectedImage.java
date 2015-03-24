package helper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ExpectedImage {
    public boolean hasExpectedColor(BufferedImage image,Color expectedColor){

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color=new Color(image.getRGB(x,y));
                if(!color.equals(expectedColor))
                    return false;
            }
        }
        return true;

    }
}
