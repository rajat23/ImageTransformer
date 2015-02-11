package com.helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageReader {
    public BufferedImage readImage(URL url) throws IOException{
        BufferedImage image = ImageIO.read(url);
        return image;
    }
}
