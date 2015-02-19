package com.helper;


import com.helper.MyColor;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.rmi.MarshalledObject;
import java.util.Enumeration;
import java.util.Map;

public class RequestStructure {
    private BufferedImage image;
    private int height;
    private int width;
    private Color color;
    private String mode;
    private String orientation;

    public RequestStructure() {
        height = 0;
        width = 0;
        color = Color.WHITE;
        mode = "default";
        orientation = "center";
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public String getMode() {
        return mode;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public float getAspectRatio() {
        return (float) image.getWidth() / (float) image.getHeight();
    }

    public void setParameters(Map map) {

        if (map.containsKey("width"))
            width = Integer.parseInt(((String[]) map.get("width"))[0]);
        if (map.containsKey("height"))
            height = Integer.parseInt(((String[]) map.get("height"))[0]);

        if (height == 0)
            height = getProportionalHeight(width, getAspectRatio());
        if (width == 0)
            width = getProportionalWidth(height, getAspectRatio());
        if (map.containsKey("color"))
            color = MyColor.getColor(((String[]) map.get("color"))[0]);
        if (map.containsKey("mode"))
            mode = ((String[]) map.get("mode"))[0];
        if (map.containsKey("orientation"))
            orientation = ((String[]) map.get("orientation"))[0];

    }


    public int getProportionalHeight(int width, float aspectRatio) {
        return (int) (width / aspectRatio);

    }

    public int getProportionalWidth(int height, float aspectRatio) {
        return (int) (height * aspectRatio);
    }

    public Dimension getDimension() {
        return new Dimension(width, height);
    }


}
