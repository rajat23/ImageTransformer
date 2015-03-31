package helper;

import java.awt.*;

public class ColorFactory {

    public static Color createColor(String colorString) {
        if (colorString.startsWith("0x")) {
            return Color.decode(colorString);
        }
        if (colorString.startsWith("r_") || colorString.startsWith("g_") || colorString.startsWith("b_")) {
            return new RgbStringToColor().getColorFormRGB(colorString);
        }
        if (colorString.equals("black"))
            return Color.BLACK;
        if (colorString.equals("blue"))
            return Color.BLUE;
        if (colorString.equals("cyan"))
            return Color.CYAN;
        if (colorString.equals("darkgray"))
            return Color.DARK_GRAY;
        if (colorString.equals("gray"))
            return Color.GRAY;
        if (colorString.equals("lightgray"))
            return Color.LIGHT_GRAY;
        if (colorString.equals("green"))
            return Color.GREEN;
        if (colorString.equals("magenta"))
            return Color.MAGENTA;
        if (colorString.equals("orange"))
            return Color.ORANGE;
        if (colorString.equals("pink"))
            return Color.PINK;
        if (colorString.equals("red"))
            return Color.RED;
        if (colorString.equals("yellow"))
            return Color.YELLOW;
        return Color.WHITE;

    }

}
