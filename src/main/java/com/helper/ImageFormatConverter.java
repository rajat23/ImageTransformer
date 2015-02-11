package com.helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImageFormatConverter {
    public BufferedImage convertToRequiredFormat(BufferedImage image, String requiredFormat) throws IOException {
        File temporaryFile = new File("image." + requiredFormat);
        ImageIO.write(image, requiredFormat, temporaryFile);
        BufferedImage imageToReturn=ImageIO.read(temporaryFile);
        temporaryFile.delete();
        return imageToReturn;
    }
}
