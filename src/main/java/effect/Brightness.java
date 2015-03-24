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
        int red, green, blue;
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int widthCounter = 0; widthCounter < width; widthCounter++) {
            for (int heightCounter = 0; heightCounter < height; heightCounter++) {
                Color color = new Color(sourceImage.getRGB(widthCounter, heightCounter));

                red = color.getRed() + increasingFactor;
                green = color.getGreen() + increasingFactor;
                blue = color.getBlue() + increasingFactor;

                red = checkBoundaryValue(red);
                green = checkBoundaryValue(green);
                blue = checkBoundaryValue(blue);

                outputImage.setRGB(widthCounter, heightCounter, new Color(red, green, blue).getRGB());

            }
        }

        return outputImage;
    }

    public int checkBoundaryValue(int value){
        if (value > maxColorValue ) {
            value = maxColorValue;
        } else if (value < minColorValue) {
            value = minColorValue;
        }
        return value;
    }
}

