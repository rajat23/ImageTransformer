package com.effect;

public class EffectFactory {
    public Effect create(String effect) {
        if (effect.equals("Blur"))
            return new Blur();
        if(effect.equals("Grayscale"))
            return new GrayScale();
        if(effect.equals("blackwhite"))
            return new BlackWhite();
        if(effect.equals("sepia"))
            return new Sepia();
        if(effect.equals("pixelate"))
            return new Pixelate();
        if(effect.equals("oilpaint"))
            return new Oilpaint();
        if(effect.equals("negate"))
            return new Negate();
        if(effect.equals("brightness"))
            return new Brightness();
        if(effect.equals("watermark"))
            return new Watermark();

        return new NoEffect();

    }
}
