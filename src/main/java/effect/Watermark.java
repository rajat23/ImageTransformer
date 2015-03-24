package effect;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Watermark  implements Effectible {
    private String watermark ;

    public Watermark(String watermark){
        this.watermark="\u00a9"+watermark;
    }

    @Override
    public BufferedImage getEffect(BufferedImage sourceImage) {

        Graphics graphics = sourceImage.getGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        graphics.setFont(new Font("Arial", Font.BOLD, 100));
        graphics.drawString(watermark, 0, 150);
        graphics.dispose();
        return sourceImage;


    }
}
