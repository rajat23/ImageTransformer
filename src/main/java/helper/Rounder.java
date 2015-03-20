package helper;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class Rounder {
    public static BufferedImage makeRoundedCorner(BufferedImage originalImage, int cornerRadius) throws IOException {
            if(cornerRadius==0)
                return originalImage;
            int width = originalImage.getWidth();
            int height = originalImage.getHeight();
            int type = originalImage.getType();
            BufferedImage outputImage = new BufferedImage(width, height, type);
            Graphics graphics = outputImage.createGraphics();
            Graphics2D graphics2d = outputImage.createGraphics();
            graphics2d.setBackground(Color.WHITE);
            graphics2d.fillRect(0, 0, width, height);
            RoundRectangle2D r2 = new RoundRectangle2D.Double(0,0,width,height,cornerRadius,cornerRadius);
            graphics.setClip(r2);
            graphics.drawImage(originalImage, 0, 0, null);
            return outputImage;
    }
}
