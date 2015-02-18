package com.helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageReader {
    public BufferedImage readImage(String path) throws IOException {

        BufferedImage returnImage;
        try {
            URL url = new URL(path);
            returnImage = ImageIO.read(url.openStream());
            return returnImage;
        } catch (Exception exception) {

        }

        returnImage = ImageIO.read(new File(System.getProperty("user.dir") + "/upload/" + path));
        return returnImage;
    }
}
