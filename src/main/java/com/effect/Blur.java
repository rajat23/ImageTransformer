package com.effect;


import com.utility.ImageScaler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


public class Blur implements Effect {
    public BufferedImage getEffect(BufferedImage image) {
        return null;
    }

    public BufferedImage getEffect(BufferedImage image, int factor) {
        int size = factor + 2;
        BufferedImage output = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_BGR);
        Graphics g = output.getGraphics();
        g.drawImage(image, 455, 255, null);
        int radius = 0;
        factor += 2;
        for (; factor > 2; factor--)
            radius += factor * factor;
        float[] blurKernel = new float[radius];
        for (int i = 0; i < radius; i++) {
            blurKernel[i] = 1.0f / (float) radius;
        }
        radius = (int) Math.sqrt(radius);
        BufferedImageOp blur = new ConvolveOp(new Kernel(radius, radius, blurKernel));
        output = blur.filter(image, new BufferedImage(image.getWidth(), image.getHeight(), image.getType()));
        g.dispose();
        return output;

    }

}
