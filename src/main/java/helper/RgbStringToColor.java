package helper;

import java.awt.*;

public class RgbStringToColor {

    public  Color getColorFormRGB(String rgbString) {
        int r = 0, g = 0, b = 0;
        for (String color : rgbString.split(",")) {
            if (color.startsWith("r_"))
                r = Integer.parseInt(color.substring(2));
            else if (color.startsWith("g_"))
                g = Integer.parseInt(color.substring(2));
            else if (color.startsWith("b_"))
                b = Integer.parseInt(color.substring(2));
        }
        return new Color(r, g, b);
    }

}
