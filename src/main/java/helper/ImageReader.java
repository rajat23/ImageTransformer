package helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ImageReader {
    public BufferedImage readImage(String imagePath) throws IOException {

        try {
            URL url = new URL(imagePath);

            return ImageIO.read(url.openStream());

        } catch (Exception exception) {

            System.out.println("Not a remote image");

        }

        return ImageIO.read(new File(System.getProperty("user.dir") + "/upload/" + imagePath));

    }
}
