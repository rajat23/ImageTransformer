package effect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale implements Effectible {

    @Override
    public BufferedImage getEffect(BufferedImage sourceImage) {

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();

        for (int heightCounter = 0; heightCounter < height; heightCounter++) {

            for (int widthCounter = 0; widthCounter < width; widthCounter++) {

                Color color = new Color(sourceImage.getRGB(widthCounter, heightCounter));
                int red = (int) (color.getRed() * 0.299);
                int green = (int) (color.getGreen() * 0.587);
                int blue = (int) (color.getBlue() * 0.114);
                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                sourceImage.setRGB(widthCounter, heightCounter, newColor.getRGB());

            }
        }
        return sourceImage;
    }
}
