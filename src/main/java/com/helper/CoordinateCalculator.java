package com.helper;

public class CoordinateCalculator {
    public Coordinates getCoordinates(int imageWidth,int imageHeight,int width,int height,String orientation){
        if(orientation.equals("north_west"))
            return new Coordinates(0,0);
        if(orientation.equals("north_east"))
            return new Coordinates(imageWidth-width,0);
        if(orientation.equals("south_west"))
            return new Coordinates(0,imageHeight-height);
        if(orientation.equals("south_east"))
            return new Coordinates(imageWidth-width,imageHeight-height);
        if(orientation.equals("north"))
            return new Coordinates((imageWidth-width)/2,0);
        if(orientation.equals("west"))
            return new Coordinates(0,(imageHeight-height)/2);
        if(orientation.equals("south"))
            return new Coordinates((imageWidth-width)/2,imageHeight-height);
        if(orientation.equals("east"))
            return new Coordinates((imageWidth-width),(imageHeight-height)/2);
        return new Coordinates((imageWidth/2-width/2),(imageHeight/2-height/2));
    }
}
