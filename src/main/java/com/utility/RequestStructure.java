package com.utility;


import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Enumeration;

public class RequestStructure {
    private BufferedImage image;
    private int height;
    private int width;
    private Color color;
    private String mode;
    private String orientation;

    public RequestStructure(BufferedImage image) {

        this.image = image;
        height=0;
        width=0;
        color=Color.WHITE;
        mode="default";
        orientation="center";
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

    public void setParameters(HttpServletRequest request) {
        Enumeration <String> parameterNames=request.getParameterNames();
        String parameterString=parameterNames.toString();
        if(parameterString.contains("width"))
            width=Integer.parseInt(request.getParameter("width"));
        else if(parameterString.contains("Height"))
            height=Integer.parseInt(request.getParameter("height"));
        else return;
        if(parameterString.contains("color"))
            color=MyColor.getColor(request.getParameter("color"));
        if(parameterString.contains("mode"))
            mode=request.getParameter("mode");
        if(parameterString.contains("orientation"))
            orientation=request.getParameter("orientation");

    }

}
