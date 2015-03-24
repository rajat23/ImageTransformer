package helper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ExpectedImage {
    public boolean hasExpectedColor(BufferedImage image,Color expectedColor){

        for(int heightCounter = 0; heightCounter < image.getHeight(); heightCounter++) {
            for (int widthCounter = 0; widthCounter < image.getWidth(); widthCounter++) {
                Color color=new Color(image.getRGB(widthCounter,heightCounter));
                if(!color.equals(expectedColor))
                    return false;
            }
        }
        return true;

    }
}
