package helper;

import java.awt.*;

public class RgbStringToColor {

    public  Color getColorFormRGB(String rgbString) {
        int red = 0, green = 0, blue = 0;
        for (String color : rgbString.split(",")) {
            if (color.startsWith("r_"))
                red = Integer.parseInt(color.substring(2));
            else if (color.startsWith("g_"))
                green = Integer.parseInt(color.substring(2));
            else if (color.startsWith("b_"))
                blue = Integer.parseInt(color.substring(2));
        }
        return new Color(red, green, blue);
    }

}
