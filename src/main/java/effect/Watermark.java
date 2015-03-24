package effect;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Watermark  implements Effectible {
    private String watermark ;
    private int x, y;

    public Watermark(String watermark,String x,String y){
        this.watermark="\u00a9"+watermark;
        this.x=Integer.parseInt(x);
        this.y=Integer.parseInt(y);
    }


    public BufferedImage getEffect(BufferedImage sourceImage ) {

        Graphics graphics = sourceImage.getGraphics();
        graphics.drawImage(sourceImage, 0, 0, null);
        graphics.setFont(new Font("Arial", Font.BOLD, 100));
        graphics.drawString(watermark, x , y);
        graphics.dispose();
        return sourceImage;


    }
}
