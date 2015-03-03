package com.effect;

import java.awt.image.BufferedImage;

public class NoEffect implements Effect {
    public BufferedImage getEffect(BufferedImage image){
        return image;
    }
}
