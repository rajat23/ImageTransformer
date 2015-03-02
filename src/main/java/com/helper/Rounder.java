package com.helper;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

public class Rounder {
    public static  BufferedImage makeRoundedCorner(BufferedImage originalImage, int cornerRadius) {
        if(cornerRadius==0)
            return originalImage;
        int width=originalImage.getWidth();
        int height=originalImage.getHeight();
        BufferedImage outputImage=new BufferedImage(width,height,originalImage.getType());
        Graphics2D g2=outputImage.createGraphics();
        g2.setBackground(Color.WHITE);
        g2.fillRect(0,0,width,height);
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(originalImage, 0, 0, null);
        g2.dispose();
        return outputImage;
    }
}
