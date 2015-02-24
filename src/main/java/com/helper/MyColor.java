package com.helper;

import java.awt.*;

public class MyColor {
    public static Color getColor(String name) {
       if(name.startsWith("#")) {
           String tmp=name.substring(1);
           return Color.decode("0x"+tmp);

       }

        name=name.toLowerCase();
        if (name.equals("black"))
            return Color.BLACK;
        if (name.equals("blue"))
            return Color.BLUE;
        if (name.equals("cyan"))
            return Color.CYAN;
        if (name.equals("darkgray"))
            return Color.DARK_GRAY;
        if (name.equals("gray"))
            return Color.GRAY;
        if (name.equals("lightgray"))
            return Color.LIGHT_GRAY;
        if (name.equals("green"))
            return Color.GREEN;
        if (name.equals("magenta"))
            return Color.MAGENTA;
        if (name.equals("orange"))
            return Color.ORANGE;
        if (name.equals("pink"))
            return Color.PINK;
        if (name.equals("red"))
            return Color.RED;
        if (name.equals("yellow"))
            return Color.YELLOW;
        return Color.WHITE;

    }

}
