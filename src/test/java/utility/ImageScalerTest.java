package utility;


import helper.ImageReader;
import org.junit.Before;
import org.junit.Test;


import java.awt.image.BufferedImage;

import static org.junit.Assert.assertEquals;

public class ImageScalerTest {

    private int width;
    private int height;
    private ImageReader imageReader;
    private ImageScaler imageScaler;

    @Before
    public void beforeEachTest() throws Exception{
        width=800;
        height=800;
        imageReader=new ImageReader();
        imageScaler=new ImageScaler();
    }

    @Test
    public void testResizeImageForJpeg() throws Exception {


        String name="JpgImage.jpg";
        BufferedImage image=imageReader.readImage(name);


        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

    }

    @Test
    public void testResizeImageForPng() throws Exception {


        String name="PngImage.png";
        BufferedImage image=imageReader.readImage(name);

        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

    }
    @Test
    public void testResizeImageForGif() throws Exception {


        String name="GifImage.gif";
        BufferedImage image=imageReader.readImage(name);

        BufferedImage resizedImage=imageScaler.resizeImage(image, width, height);

        assertEquals(resizedImage.getHeight(),height);
        assertEquals(resizedImage.getWidth(),width);

    }

}