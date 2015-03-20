package effect;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public class BlackWhite implements Effect {
    int threshold;
    public BlackWhite(String threshold){
        this.threshold=Integer.parseInt(threshold);
    }
    public BufferedImage getEffect(BufferedImage image) {

        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        result.getGraphics().drawImage(image, 0, 0, null);
        WritableRaster raster = result.getRaster();
        int[] pixels = new int[image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            raster.getPixels(0, y, image.getWidth(), 1, pixels);
            for (int i = 0; i < pixels.length; i++) {
                if (pixels[i] < threshold) pixels[i] = 0;
                else pixels[i] = 255;
            }
            raster.setPixels(0, y, image.getWidth(), 1, pixels);
        }
        return result;

    }
}
