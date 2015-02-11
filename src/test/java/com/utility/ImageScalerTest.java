package com.utility;


import com.helper.ImageReader;
import org.junit.Test;
import java.awt.image.BufferedImage;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ImageScalerTest {
    @Test
    public void testResizeImage() throws Exception {
        //action
        String url="http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2014/4/11/1397210130748/Spring-Lamb.-Image-shot-2-011.jpg";
        int width=800;
        int height=800;
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(new URL(url));

        //call

        ImageScaler imageScaler=new ImageScaler();
        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        //test
        
        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

        

    }


}