package effect;

import java.awt.*;
import java.awt.image.BufferedImage;



public class Brightness implements Effectible {
    private int increasingFactor;
    private int maxColorValue =255;
    private int minColorValue =0;
    public Brightness(String increasingFactor)
    {
            this.increasingFactor=Integer.parseInt(increasingFactor);
    }

    @Override
    public BufferedImage getEffect(BufferedImage sourceImage) {

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        int red=0,green=0,blue=0;
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int widthCounter = 0; widthCounter < width; widthCounter++) {
            for (int heightCounter = 0; heightCounter < height; heightCounter++) {
                Color color = new Color(sourceImage.getRGB(widthCounter, heightCounter));


                red = color.getRed() + increasingFactor;
                green = color.getGreen() + increasingFactor;
                blue = color.getBlue() + increasingFactor;

                if (red >= maxColorValue +1) {
                    red = maxColorValue;
                } else if (red < minColorValue) {
                    red = minColorValue;
                }

                if (green >= maxColorValue +1) {
                    green = maxColorValue;
                } else if (green < minColorValue) {
                    green = minColorValue;
                }

                if (blue >= maxColorValue +1) {
                    blue = maxColorValue;
                } else if (blue < minColorValue) {
                    blue = minColorValue;
                }
                outputImage.setRGB(widthCounter, heightCounter, new Color(red, green, blue).getRGB());

            }
        }

        return outputImage;
    }
}

