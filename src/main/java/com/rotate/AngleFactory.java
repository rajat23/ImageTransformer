package com.rotate;


public class AngleFactory {
    public Angle create(String angle) {
        if(angle.equals("hflip"))
            return new Hflip();
        if(angle.equals("vflip"))
            return new Vflip();
        int tmpAngle=0;
        try{
            tmpAngle=Integer.parseInt(angle);
        }
        catch (Exception e){
            tmpAngle=360;
        }
        return new AngledFlip(tmpAngle);

    }
}
