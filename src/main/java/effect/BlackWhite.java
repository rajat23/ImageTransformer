package effect;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BlackWhite implements Effectible {
    private int threshold;
    private int maxColorValue =255;
    public BlackWhite(String threshold){
        this.threshold=Integer.parseInt(threshold);
    }

    public BufferedImage getEffect(BufferedImage sourceImage) {
        BufferedImage outputImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        outputImage.getGraphics().drawImage(sourceImage, 0, 0, null);
        WritableRaster raster = outputImage.getRaster();
        int[] pixels = new int[sourceImage.getWidth()];
        for (int heightCounter = 0; heightCounter < sourceImage.getHeight(); heightCounter++) {
            raster.getPixels(0, heightCounter, sourceImage.getWidth(), 1, pixels);
            for (int pixelCounter = 0; pixelCounter < pixels.length; pixelCounter++) {
                if (pixels[pixelCounter] < threshold) pixels[pixelCounter] = 0;
                else pixels[pixelCounter] = maxColorValue;
            }
            raster.setPixels(0, heightCounter, sourceImage.getWidth(), 1, pixels);
        }
        return outputImage;

    }
}
