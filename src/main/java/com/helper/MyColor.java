package com.helper;

import java.awt.*;

public class MyColor {
    public static Color getColor(String name) {
        if(name.startsWith("0x")) {
            return Color.decode(name);
        }
        if(name.startsWith("r_")||name.startsWith("g_")||name.startsWith("b_")){
            return getColorFormRGB(name);
        }
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
    public static Color getColorFormRGB(String name){
        int r=0,g=0,b=0;
        for (String color:name.split(",")){
            if(color.startsWith("r_"))
                r=Integer.parseInt(color.substring(2));
            else if(color.startsWith("g_"))
                g=Integer.parseInt(color.substring(2));
            else  if(color.startsWith("r_"))
                b=Integer.parseInt(color.substring(2));
        }
        return new Color(r,g,b);
    }
}
