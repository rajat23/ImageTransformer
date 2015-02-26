package com.helper;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class Rounder {
    public static  BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        if(cornerRadius==0)
            return image;
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = outputImage.createGraphics();
        graphics.setComposite(AlphaComposite.Src);
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setBackground(Color.WHITE);
        graphics.fill(new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius));
        graphics.setComposite(AlphaComposite.SrcAtop);
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        return outputImage;
    }
}
