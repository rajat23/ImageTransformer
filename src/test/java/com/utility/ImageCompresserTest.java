package com.utility;

import com.helper.ImageReader;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.assertEquals;

public class ImageCompresserTest {
    @Test
    public void testgetCompressImage() throws Exception {

        ImageCompresser imageCompresser=new ImageCompresser();
        String name="JpgImage.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image= imageReader.readImage(name);
        imageCompresser.getCompressImage(image,0.05f);
        float quality=imageCompresser.getQuality();
        assertEquals(0.05f,quality,0.00f);
    }

}