package effect;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Pixelate implements Effectible {
    private int pixelSize;

    public Pixelate(String pixelSize){
        this.pixelSize =Integer.parseInt(pixelSize);
    }

    @Override
    public BufferedImage getEffect(BufferedImage sourceImage) {

        Raster sourceImageData = sourceImage.getData();
        WritableRaster destination = sourceImageData.createCompatibleWritableRaster();
        for (int heightCounter = 0; heightCounter < sourceImageData.getHeight(); heightCounter += pixelSize) {
            for (int widthCounter = 0; widthCounter < sourceImageData.getWidth(); widthCounter += pixelSize) {
                double[] pixel = new double[3];
                pixel = sourceImageData.getPixel(widthCounter, heightCounter, pixel);
                for (int vertical = heightCounter; (vertical < heightCounter + pixelSize) && (vertical < destination.getHeight()); vertical++) {
                    for (int horizontal = widthCounter; (horizontal < widthCounter + pixelSize) && (horizontal < destination.getWidth()); horizontal++) {
                        destination.setPixel(horizontal, vertical, pixel);
                    }
                }
            }
        }
        sourceImage.setData(destination);
        return sourceImage;

    }
}
