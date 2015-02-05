package com.utility;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class ImageResizer {
    public static BufferedImage resize(String sourceFile,
                                       int targetWidth, int targetHeight) throws Exception {
        try {
            BufferedImage image = ImageIO.read(new URL(sourceFile));
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();

            Object hint = RenderingHints.VALUE_INTERPOLATION_BILINEAR;
            int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();

            // First get down to no more than 2x in W & H
            while (imageWidth > targetWidth * 2 || imageHeight > targetHeight * 2) {
                imageWidth = (imageWidth > targetWidth * 2) ? imageWidth / 2 : imageWidth;
                imageHeight = (imageHeight > targetHeight * 2) ? imageHeight / 2 : imageHeight;
                image = scaleImage(image, type, hint, imageWidth, imageHeight);
            }

            // REMIND: Conservative approach:
            // first get W right, then worry about H

            // If still too wide - do a horizontal trilinear blend
            // of image and a half-width image
            if (imageWidth > targetWidth) {
                int scaledWidth = imageWidth / 2;
                BufferedImage scaledImage = scaleImage(image, type, hint, scaledWidth, imageHeight);
                if (scaledWidth < targetWidth) {
                    image = scaleImage(image, type, hint, targetWidth, imageHeight);
                    scaledImage = scaleImage(scaledImage, type, hint, targetWidth, imageHeight);
                    interp(scaledImage, image, imageWidth - targetWidth, targetWidth - scaledWidth);
                }
                image = scaledImage;
                imageWidth = targetWidth;
            }
            // imageWidth should now be targetWidth or smaller

            // If still too tall - do a vertical trilinear blend
            // of image and a half-height image
            if (imageHeight > targetHeight) {
                int scaledHeight = imageHeight / 2;
                BufferedImage scaledImage = scaleImage(image, type, hint, imageWidth, scaledHeight);
                if (scaledHeight < targetHeight) {
                    image = scaleImage(image, type, hint, imageWidth, targetHeight);
                    scaledImage = scaleImage(scaledImage, type, hint, imageWidth, targetHeight);
                    interp(scaledImage, image, imageHeight - targetHeight, targetHeight - scaledHeight);
                }
                image = scaledImage;
                imageHeight = targetHeight;
            }
            // imageHeight should now be targetHeight or smaller

            // If we are too small, then it was probably because one of
            // the dimensions was too small from the start.
            if (imageWidth < targetWidth && imageHeight < targetHeight) {
                image = scaleImage(image, type, hint, targetWidth, targetHeight);
            }

            return image;

        } catch (IOException thumbException) {
            thumbException.printStackTrace();
            throw new Exception(thumbException);
        }

    }

    public static BufferedImage  scaleImage(BufferedImage orig, int type, Object hint, int width, int height) {
        BufferedImage tmp = new BufferedImage(width, height, type);
        Graphics2D graphics = tmp.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
        graphics.drawImage(orig, 0, 0, width, height, null);
        graphics.dispose();
        return tmp;
    }

    public static void  interp(BufferedImage image1, BufferedImage image2, int weight1, int weight2) {
        float alpha = weight1;
        alpha /= (weight1 + weight2);
        Graphics2D graphics = image1.createGraphics();
        graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        graphics.drawImage(image2, 0, 0, null);
        graphics.dispose();
    }
}
