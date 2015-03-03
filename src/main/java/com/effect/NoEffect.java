package com.effect;

import java.awt.image.BufferedImage;

/**
 * Created by akshaysinghyaduvanshi on 3/3/15.
 */
public class NoEffect implements Effect {
    public BufferedImage getEffect(BufferedImage image){
        return image;
    }
}
