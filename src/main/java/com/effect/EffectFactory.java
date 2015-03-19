package com.effect;

public class EffectFactory {
    public Effect create(String effect) {
        if (effect.contains("Blur")) {

            return new Blur();

        }
        if(effect.equals("Grayscale"))
            return new GrayScale();
        if(effect.contains("blackwhite")){
            String[] tmp=effect.split("_");


            return new BlackWhite(tmp[1]);}
        if(effect.contains("sepia")){
            String[] tmp=effect.split("_");
            return new Sepia(tmp[1]);}
        if(effect.contains("pixelate")) {
            String[] tmp=effect.split("_");
            return new Pixelate(tmp[1]);
        }


        if (effect.equals("oilpaint"))

            return new Oilpaint();
        if (effect.equals("negate"))
            return new Negate();

        if(effect.contains("brightness")){
            String[] tmp=effect.split("_");
            return new Brightness(tmp[1]);}
        if(effect.contains("watermark")){
            String[] tmp=effect.split("_");

            return new Watermark(tmp[1]);}


        return new NoEffect();

    }
}
