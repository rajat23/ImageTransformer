package com.rotate;


import java.awt.*;
import java.awt.image.BufferedImage;

public class AngledFlip implements Angle {
    public BufferedImage rotateImage(BufferedImage image, String angle) {
        if(angle.equals("0"))
            return image;

        double rotationAngle=Double.parseDouble(angle);
        int widht = image.getWidth();
        int height = image.getHeight();
        BufferedImage dimg =new BufferedImage(widht, height, image.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.rotate(Math.toRadians(rotationAngle), widht/2, height/2);

        g.drawImage(image, null, 0, 0);
        return dimg;
    }
}
