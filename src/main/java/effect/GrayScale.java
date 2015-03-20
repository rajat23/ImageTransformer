package effect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale implements Effectible {

    public BufferedImage getEffect(BufferedImage sourceImage) {

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                Color color = new Color(sourceImage.getRGB(j, i));
                int red = (int) (color.getRed() * 0.299);
                int green = (int) (color.getGreen() * 0.587);
                int blue = (int) (color.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                sourceImage.setRGB(j, i, newColor.getRGB());

            }
        }
        return sourceImage;
    }
}
