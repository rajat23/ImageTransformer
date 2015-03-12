package com.rotate;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class AngledFlip implements Angle {
    public BufferedImage rotateImage(BufferedImage image, String angle) {
        if(angle.equals("0"))
            return image;

        /*double rotationAngle=Double.parseDouble(angle);
        int width = image.getWidth()*2;
        int height = image.getHeight()*2;
        BufferedImage output =new BufferedImage(width, height, image.getType());
        Graphics2D graphics2d = output.createGraphics();
        graphics2d.setBackground(Color.WHITE);
        graphics2d.fillRect(0, 0, width, height);

        double rotate = Math.toRadians(rotationAngle);
        double X = width/2;
        double Y = height/2;


        AffineTransform tx = AffineTransform.getRotateInstance(rotate, X, Y);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        graphics2d.drawImage(op.filter(image, null), 100, 100, null);
        */
        double numquadrants=Math.toRadians(Integer.parseInt(angle));
        int w0 = image.getWidth();
        int h0 = image.getHeight();
        int w1 = w0;
        int h1 = h0;

        int centerX = w0 / 2;
        int centerY = h0 / 2;



        AffineTransform affineTransform = AffineTransform.getRotateInstance(numquadrants, centerX,centerY);
        AffineTransformOp opRotated = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);

        BufferedImage transformedImage = new BufferedImage(w1*2, h1*2, image.getType());

        transformedImage = opRotated.filter(image, transformedImage);
        return transformedImage;


        /*
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2d.rotate(Math.toRadians(rotationAngle), width/ 2, height / 2);
        graphics2d.drawImage(image, null, 0, 0);
        */
        //return output;
    }
}
