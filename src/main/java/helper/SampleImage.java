package helper;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SampleImage {
    public BufferedImage get2by2(){

        BufferedImage image=new BufferedImage(2,2,BufferedImage.TYPE_3BYTE_BGR);
        image.setRGB(0, 0, new Color(1, 1, 1).getRGB());
        image.setRGB(1, 0, new Color(2, 2, 2).getRGB());
        image.setRGB(0, 1, new Color(3, 3, 3).getRGB());
        image.setRGB(1, 1, new Color(4, 4, 4).getRGB());
        return image;
    }

    public BufferedImage get3by2(){
        BufferedImage image=new BufferedImage(3,2,BufferedImage.TYPE_3BYTE_BGR);
        image.setRGB(0, 0, new Color(1, 1, 1).getRGB());
        image.setRGB(1, 0, new Color(2, 2, 2).getRGB());
        image.setRGB(2, 0, new Color(5, 5, 5).getRGB());
        image.setRGB(0, 1, new Color(3, 3, 3).getRGB());
        image.setRGB(1, 1, new Color(4, 4, 4).getRGB());
        image.setRGB(2, 1, new Color(6, 6, 6).getRGB());
        return image;
    }

    public BufferedImage get10by10(){
        BufferedImage image = new BufferedImage(10,10,BufferedImage.TYPE_3BYTE_BGR);
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, new Color(100, 100, 100).getRGB());
            }
        }
        return image;
    }
}
