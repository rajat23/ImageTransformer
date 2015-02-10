package com.utility;

import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;
public class ImageCropperTest {

    @Test
    public void testGetCroppedImage() throws Exception {

        String url="http://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg";
        int x=10,y=10;
        int width=100,height=100;

        ImageCropper imageCropper=new ImageCropper();
        BufferedImage croppedImage=imageCropper.getCroppedImage(url,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
}