package helper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ExpectedImage {

    public boolean hasExpectedColor(BufferedImage outputImage,Color expectedColor){

        for(int y = 0; y < outputImage.getHeight(); y++) {
            for (int x = 0; x < outputImage.getWidth(); x++) {
                Color color=new Color(outputImage.getRGB(x,y));
                if(!color.equals(expectedColor))
                    return false;
            }
        }
        return true;

    }
}
