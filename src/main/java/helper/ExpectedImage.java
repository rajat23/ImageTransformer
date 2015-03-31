package helper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ExpectedImage {

    public boolean hasExpectedColor(BufferedImage outputImage,Color expectedColor){

        for(int heightCOunter = 0; heightCOunter < outputImage.getHeight(); heightCOunter++) {
            for (int WidhtCounter = 0; WidhtCounter < outputImage.getWidth(); WidhtCounter++) {
                Color color=new Color(outputImage.getRGB(WidhtCounter,heightCOunter));
                if(!color.equals(expectedColor))
                    return false;
            }
        }
        return true;

    }
}
