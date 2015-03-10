package com.rotate;


public class AngleFactory {
    public Angle create(String angle) {
        if(angle.equals("hflip"))
            return new Hflip();
        return new NoEffect();

    }
}
