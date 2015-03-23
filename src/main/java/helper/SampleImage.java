package helper;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class SampleImage {
    public BufferedImage getImage(int rows, int cols) throws ArrayIndexOutOfBoundsException{
        int value=1;
        BufferedImage image=new BufferedImage(rows,cols,BufferedImage.TYPE_3BYTE_BGR);
        for(int y=0;y<cols;y++){
            for(int x=0;x<rows;x++){
                image.setRGB(x,y,new Color(value,value,value).getRGB());
                value++;
            }
        }

        return image;
    }



    public BufferedImage get10by10(int value){
        BufferedImage image = new BufferedImage(10,10,BufferedImage.TYPE_3BYTE_BGR);
        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                image.setRGB(x, y, new Color(value, value, value).getRGB());
            }
        }
        return image;
    }
}
