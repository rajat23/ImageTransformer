package effect;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class Pixelate implements Effectible {
    private int pixSize;

    public Pixelate(String pix_size){
        this.pixSize =Integer.parseInt(pix_size);
    }

    public BufferedImage getEffect(BufferedImage sourceImage) {

        Raster src = sourceImage.getData();
        WritableRaster dest = src.createCompatibleWritableRaster();
        for (int y = 0; y < src.getHeight(); y += pixSize) {
            for (int x = 0; x < src.getWidth(); x += pixSize) {
                double[] pixel = new double[3];
                pixel = src.getPixel(x, y, pixel);
                for (int yd = y; (yd < y + pixSize) && (yd < dest.getHeight()); yd++) {
                    for (int xd = x; (xd < x + pixSize) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }
        sourceImage.setData(dest);
        return sourceImage;

    }
}
