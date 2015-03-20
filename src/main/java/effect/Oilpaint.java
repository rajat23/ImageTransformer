package effect;


import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;


public class Oilpaint implements Effectible {

    static int radius = 10;
    static int intensityLevels = 24;

    public BufferedImage getEffect(BufferedImage sourceImage) {


        BufferedImage outputImage = new BufferedImage(
                sourceImage.getWidth(),
                sourceImage.getHeight(),
                sourceImage.getType()
        );

        int averageR[] = new int[intensityLevels];
        int averageG[] = new int[intensityLevels];
        int averageB[] = new int[intensityLevels];
        int intensityCount[] = new int[intensityLevels];

        for (int x = 0; x < sourceImage.getWidth(); ++x) {
            int left = Math.max(0, x - radius);
            int right = Math.min(x + radius, outputImage.getWidth() - 1);
            for (int y = 0; y < sourceImage.getHeight(); ++y) {

                int top = Math.max(0, y - radius);
                int bottom = Math.min(y + radius, outputImage.getHeight() - 1);

                Arrays.fill(averageR, 0);
                Arrays.fill(averageG, 0);
                Arrays.fill(averageB, 0);
                Arrays.fill(intensityCount, 0);
                int maxIndex = -1;

                for (int j = top; j <= bottom; ++j) {
                    for (int i = left; i <= right; ++i) {
                        if (!inRange(x, y, i, j)) continue;

                        int rgb = sourceImage.getRGB(i, j);

                        int red = (rgb >> 16) & 0xFF;
                        int green = (rgb >> 8) & 0xFF;
                        int blue = (rgb) & 0xFF;
                        int intensityIndex = (int) ((((red + green + blue) / 3.0) / 256.0) * intensityLevels);

                        intensityCount[intensityIndex]++;
                        averageR[intensityIndex] += red;
                        averageG[intensityIndex] += green;
                        averageB[intensityIndex] += blue;

                        if (maxIndex == -1 ||
                                intensityCount[maxIndex] < intensityCount[intensityIndex]
                                ) {
                            maxIndex = intensityIndex;
                        }
                    }
                }

                int curMax = intensityCount[maxIndex];
                int r = averageR[maxIndex] / curMax;
                int g = averageG[maxIndex] / curMax;
                int b = averageB[maxIndex] / curMax;

                int rgb = ((r << 16) | ((g << 8) | b));
                outputImage.setRGB(x, y, rgb);
            }
        }


        return outputImage;
    }

    public static boolean inRange(int cx, int cy, int i, int j) {
        double d;
        //d= java.awt.geom.Line2D.ptLineDist(cx, cy, cx-radius, cy-radius, i, j);
        d = Point2D.distance(i, j, cx, cy);
        return d < radius;
    }
}