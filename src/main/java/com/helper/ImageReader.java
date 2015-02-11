package com.helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageReader {
    public BufferedImage readImage(URL url) throws IOException{
        BufferedImage image = ImageIO.read(url.openStream());
        return image;
    }
    public BufferedImage readImage(String name) throws IOException{
        return ImageIO.read(new File(System.getProperty("user.dir")+"/upload/"+name));
    }
}
