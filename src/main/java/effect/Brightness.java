package effect;

import java.awt.*;
import java.awt.image.BufferedImage;



public class Brightness implements Effectible {
    private int increasingFactor;
    private int maxColor=255;
    private int minColor=0;
    public Brightness(String increasingFactor)
    {
            this.increasingFactor=Integer.parseInt(increasingFactor);
    }

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

                if (red >= maxColor+1) {
                    red = maxColor;
                } else if (red < minColor) {
                    red = minColor;
                }

                if (green >= maxColor+1) {
                    green = maxColor;
                } else if (green < minColor) {
                    green = minColor;
                }

                if (blue >= maxColor+1) {
                    blue = maxColor;
                } else if (blue < minColor) {
                    blue = minColor;
                }
                outputImage.setRGB(widthCounter, heightCounter, new Color(red, green, blue).getRGB());

            }
        }

        return outputImage;
    }
}

