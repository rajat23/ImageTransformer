package com.utility;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class ImageScale {
    public static BufferedImage getScaledImage(String url, int width) throws Exception {
        return Scalr.resize(ImageIO.read(new URL(url)), width);
    }
}

