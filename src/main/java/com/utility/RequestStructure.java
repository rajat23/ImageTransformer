package com.utility;


import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;

public class RequestStructure {
    private BufferedImage image;
    private int height;
    private int width;
    private String color;
    private String mode;
    private String orientation;
    public RequestStructure(BufferedImage image){

        this.image=image;
    }
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public String getColor() { return color;}
    public String getMode() {return mode;}
    public String getOrientation() {return orientation;}
    public void setParameters(HttpServletRequest request) {
        
    }

}
