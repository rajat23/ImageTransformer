package com.utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class ImageCropper {

    public BufferedImage getCroppedImage(String url,int xCoordinate,int yCoordinate,int width,int height)throws IOException{
        BufferedImage image = ImageIO.read(new URL(url));
        return image.getSubimage(xCoordinate, yCoordinate, width, height);
    }

}
