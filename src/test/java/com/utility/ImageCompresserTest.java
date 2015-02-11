package com.utility;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class ImageCompresserTest {
    @Test
    public void testgetCompressImage() throws Exception {





        ImageCompresser imageCompresser=new ImageCompresser();
        BufferedImage image= ImageIO.read(new File("/Users/tejaswinibhosale/Documents/abc.jpg"));
        imageCompresser.getCompressImage(image,0.05f,"jpg");
        float quality=imageCompresser.getQuality();

        assertEquals(0.05f,quality,0.00f);
    }

}