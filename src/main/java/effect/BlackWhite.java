package effect;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BlackWhite implements Effectible {
    private int threshold;

    public BlackWhite(String threshold){
        this.threshold=Integer.parseInt(threshold);
    }

    public BufferedImage getEffect(BufferedImage sourceImage) {
        BufferedImage outputImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        outputImage.getGraphics().drawImage(sourceImage, 0, 0, null);
        WritableRaster raster = outputImage.getRaster();
        int[] pixels = new int[sourceImage.getWidth()];
        for (int y = 0; y < sourceImage.getHeight(); y++) {
            raster.getPixels(0, y, sourceImage.getWidth(), 1, pixels);
            for (int i = 0; i < pixels.length; i++) {
                if (pixels[i] < threshold) pixels[i] = 0;
                else pixels[i] = 255;
            }
            raster.setPixels(0, y, sourceImage.getWidth(), 1, pixels);
        }
        return outputImage;

    }
}
