package com.rotate;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class AngledFlip implements Angle {
    private int angle;
    public AngledFlip(int angle) {
        this.angle=angle;
    }

    public BufferedImage rotateImage(BufferedImage image) {
        if(angle==0)
            return image;
        int width=image.getWidth();
        int height=image.getHeight();
        BufferedImage output=new BufferedImage(width,height,image.getType());
        AffineTransform at = new AffineTransform();
        at.translate(width / 2, height/ 2);
        at.rotate(Math.toRadians(angle));
        at.scale(0.5, 0.5);
        at.translate(-image.getWidth()/2, -image.getHeight()/2);
        Graphics2D graphics2D = output.createGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.drawImage(image, at, null);
        return output;
    }
}
