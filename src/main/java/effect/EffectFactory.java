package effect;

public class EffectFactory {
    public Effect create(String effect) {
        if (effect.contains("Blur")) {

            return new Blur();

        }
        if(effect.equals("Grayscale"))
            return new GrayScale();

        if(effect.contains("blackwhite")){
            if(!effect.contains("_"))
            return new BlackWhite("60");
            String[] tmp=effect.split("_");
            return new BlackWhite(tmp[1]);}

        if(effect.contains("sepia")){
            if(!effect.contains("_"))
            return new Sepia("30");
            String[] tmp=effect.split("_");
            return new Sepia(tmp[1]);}

        if(effect.contains("pixelate")) {
            if(!effect.contains("_"))
            return new Pixelate("30");
            String[] tmp=effect.split("_");
            return new Pixelate(tmp[1]);}


        if (effect.equals("oilpaint"))
            return new Oilpaint();

        if (effect.equals("negate"))
            return new Negate();

        if(effect.contains("brightness")){
            if(!effect.contains("_"))
                return new Brightness("60");
            String[] tmp=effect.split("_");
            return new Brightness(tmp[1]);}

        if(effect.contains("watermark")){
            if(!effect.contains("_"))
            return new Watermark("no text");
            String[] tmp=effect.split("_");
            return new Watermark(tmp[1]);}

        return new NoEffect();

    }
}
