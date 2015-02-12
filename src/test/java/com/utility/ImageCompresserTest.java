package com.utility;

import com.helper.ImageReader;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;
public class ImageCompresserTest {
    @Test
    public void testgetCompressImageOnQualityFactor() throws Exception {

        ImageCompresser imageCompresser = new ImageCompresser();
        String name = "JpgImage.jpg";
        ImageReader imageReader = new ImageReader();
        BufferedImage image = imageReader.readImage(name);
        BufferedImage compressedImage = imageCompresser.getCompressImage(image, 0.05f);
        float quality = imageCompresser.getQuality();
        assertEquals(quality,0.05f,0.0f);
    }

    @Test
    public void testgetCompressImageOnSize() throws Exception {

        ImageCompresser imageCompresser = new ImageCompresser();
        String name = "JpgImage.jpg";

        ImageReader imageReader = new ImageReader();
        BufferedImage image = imageReader.readImage(name);
        File originalImageFile=new File(System.getProperty("user.dir")+"/upload/"+name);
        ImageIO.write(image,"jpg",originalImageFile);

        BufferedImage compressedImage = imageCompresser.getCompressImage(image, 0.05f);
        File commpressedImageFile=new File("compressedImage.jpg");
        ImageIO.write(compressedImage,"jpg",commpressedImageFile);

        assertTrue(commpressedImageFile.length()<=originalImageFile.length());
        commpressedImageFile.delete();

    }
}