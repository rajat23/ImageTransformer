package effect;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class Sepia implements Effectible {
    private int sepiaIntensity;
    private int maxColorValue=255;
    private int minColorValue=0;
    private int gridSize=3;

    public Sepia(String sepiaIntensity){
        this.sepiaIntensity=Integer.parseInt(sepiaIntensity);
    }

    public BufferedImage getEffect(BufferedImage sourceImage) {

        int sepiaDepth = 20;
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        WritableRaster raster = sourceImage.getRaster();
        int[] pixels = new int[width * height * gridSize];
        raster.getPixels(0, 0, width, height, pixels);
        for (int pixelCounter = 0; pixelCounter < pixels.length; pixelCounter += 3) {
            int red = pixels[pixelCounter];
            int green = pixels[pixelCounter + 1];
            int blue = pixels[pixelCounter + 2];

            int gray = (red + green + blue) / gridSize;
            red = green = blue = gray;
            red = red + (sepiaDepth * 2);
            green = green + sepiaDepth;

            red = checkBoundryValue(red);
            green = checkBoundryValue(green);
            blue = checkBoundryValue(blue);
            blue -= sepiaIntensity;
            if (blue < minColorValue) blue = minColorValue;
            blue = checkBoundryValue(blue);

            pixels[pixelCounter] = red;
            pixels[pixelCounter + 1] = green;
            pixels[pixelCounter + 2] = blue;
        }
        raster.setPixels(0, 0, width, height, pixels);
        return sourceImage;
    }
    public int checkBoundryValue(int value) {
        if(value>maxColorValue)
            return maxColorValue;
        return value;
    }

}
