package com.utility;


public class ImageStructure {
    private int x;
    private int y;
    private int height;
    private int width;
    public ImageStructure(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public int getHeight(){return height;
    }
    public int getWidth(){return width;}
}
