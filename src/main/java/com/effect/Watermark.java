package com.effect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Watermark  implements Effect {
    public BufferedImage getEffect(BufferedImage image) {
        Graphics graphics = image.getGraphics();
        graphics.drawImage(image, 0, 0, null);

        graphics.setFont(new Font("Arial", Font.BOLD, 100));


        String watermark = "\u00a9 ThoughtWorks";


        graphics.drawString(watermark, 0, 150);
        graphics.dispose();
        return image;




    }
}
