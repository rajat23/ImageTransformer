package effect;


import java.awt.image.BufferedImage;

public class Negate implements Effectible {

    private int maxColorValue=255;

    public BufferedImage getEffect(BufferedImage sourceImage) {

        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        for (int heightCounter = 0; heightCounter < height; heightCounter++) {
            for (int widthCounter = 0; widthCounter < width; widthCounter++) {
                int pixel = sourceImage.getRGB(widthCounter, heightCounter);
                int adjust = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = pixel & 0xff;
                red = maxColorValue - red;
                green = maxColorValue - green;
                blue = maxColorValue - blue;
                pixel = (adjust << 24) | (red << 16) | (green << 8) | blue;
                sourceImage.setRGB(widthCounter, heightCounter, pixel);
            }
        }
        return sourceImage;

    }
}
