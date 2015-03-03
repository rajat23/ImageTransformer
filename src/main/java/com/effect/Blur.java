package com.effect;


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
        float ninth = 1.0f / 9.0f;
        float[] blurKernel = {ninth, ninth, ninth, ninth, ninth, ninth, ninth,
                ninth, ninth};
        Map map = new HashMap();
        map.put(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        map.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        map.put(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        RenderingHints hints = new RenderingHints(map);
        BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, blurKernel),
                ConvolveOp.EDGE_NO_OP, hints);
        return op.filter(image, null);


    }

}
