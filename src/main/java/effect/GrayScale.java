package effect;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale implements Effectible {

    private float RED_CONSTANT=0.299f;
    private float GREEN_CONSTANT=0.587f;
    private float BLUE_CONSTANT=0.114f;

    public BufferedImage getEffect(BufferedImage sourceImage) {

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();

        for (int heightCounter = 0; heightCounter < height; heightCounter++) {

            for (int widthCounter = 0; widthCounter < width; widthCounter++) {

                Color color = new Color(sourceImage.getRGB(widthCounter, heightCounter));
                int red = (int) (color.getRed() * RED_CONSTANT);
                int green = (int) (color.getGreen() * GREEN_CONSTANT);
                int blue = (int) (color.getBlue() * BLUE_CONSTANT);
                Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                sourceImage.setRGB(widthCounter, heightCounter, newColor.getRGB());

            }
        }
        return sourceImage;
    }
}
