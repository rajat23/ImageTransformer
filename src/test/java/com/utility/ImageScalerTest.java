package com.utility;


import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.assertEquals;

public class ImageScalerTest {
    @Test
    public void testResizeImage() throws Exception {
        //action

        int width=800;
        int height=800;
        String url="http://static.guim.co.uk/sys-images/Guardian/Pix/pictures/2014/4/11/1397210130748/Spring-Lamb.-Image-shot-2-011.jpg";

        //call

        ImageScaler imageScaler=new ImageScaler();
        BufferedImage image=imageScaler.resizeImage(url, width, height);

        //test
        
        assertEquals(image.getHeight(),height);
        assertEquals(image.getWidth(),width);

        

    }


}