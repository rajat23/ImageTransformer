package com.rotate;


public class AngleFactory {
    public Angle create(String angle) {
        if(angle.equals("hflip"))
            return new Hflip();
        if(angle.equals("vflip"))
            return new Vflip();
        return new NoEffect();

    }
}
