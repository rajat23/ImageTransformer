package utility;


import helper.ImageReader;
import org.junit.Test;
import utility.ImageScaler;

import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;

public class ImageScalerTest {

    @Test
    public void testResizeImageForJpeg() throws Exception {
        int width=800;
        int height=800;
        String name="JpgImage.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        ImageScaler imageScaler=new ImageScaler();
        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

    }

    @Test
    public void testResizeImageForPng() throws Exception {
        int width=800;
        int height=800;
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        ImageScaler imageScaler=new ImageScaler();
        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

    }
    @Test
    public void testResizeImageForGif() throws Exception {
        int width=800;
        int height=800;
        String name="GifImage.gif";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        ImageScaler imageScaler=new ImageScaler();
        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

    }

}