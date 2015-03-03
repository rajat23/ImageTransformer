package com.effect;

import com.mode.*;

/**
 * Created by rajatchandak on 26/02/15.
 */
public class EffectFactory {
    public Effect create(String effect) {
        if (effect.equals("Blur"))
            return new Blur();
        if(effect.equals("Grayscale"))
            return new GrayScale();
        if(effect.equals("blackwhite"))
            return new BlackWhite();
        return new NoEffect();

    }
}
