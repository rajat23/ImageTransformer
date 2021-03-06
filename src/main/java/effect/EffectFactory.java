package effect;

public class EffectFactory {
    public Effectible create(String effect) {

        if(effect.equals("grayscale"))
            return new GrayScale();

        if(effect.contains("blackwhite")){
            if(!effect.contains("_"))
                return new BlackWhite("60");
            String[] tmp=effect.split("_");
            if(tmp.length==1)
               return new BlackWhite("60");
            return new BlackWhite(tmp[1]);}

        if(effect.contains("sepia")){
            if(!effect.contains("_"))
                return new Sepia("30");
            String[] tmp=effect.split("_");
            if(tmp.length==1)
                return new Sepia("30");
            return new Sepia(tmp[1]);}

        if(effect.contains("pixelate")) {
            if(!effect.contains("_"))
                return new Pixelate("30");
            String[] tmp=effect.split("_");
            if(tmp.length==1)
                return new Pixelate("30");
            return new Pixelate(tmp[1]);}



        if (effect.equals("negate"))
            return new Negate();

        if(effect.contains("brightness")){
            if(!effect.contains("_"))
                return new Brighten("60");
            String[] tmp=effect.split("_");
            if(tmp.length==1)
                return new Brighten("60");
            return new Brighten(tmp[1]);}

        if(effect.contains("watermark")){
            if(!effect.contains("_"))
                return new Watermark("no text","0","150","Arial");
            String[] tmp=effect.split("_");
            return new Watermark(tmp[1],tmp[2],tmp[3],tmp[4]);}

        return new NoEffect();

    }
}
