package utility;

import helper.ImageReader;
import org.junit.Before;
import org.junit.Test;


import java.awt.image.BufferedImage;

import static org.junit.Assert.*;
public class ImageCropperTest {
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageReader imageReader;
    private ImageCropper imageCropper;

    @Before
    public void beforeEachTest(){
        x=10;
        y=10;
        width=100;
        height=100;
        imageReader=new ImageReader();
        imageCropper=new ImageCropper();
    }
    @Test
    public void testGetCroppedImageForJpg() throws Exception {

        String name="JpgImage.jpg";
        BufferedImage image=imageReader.readImage(name);

        BufferedImage croppedImage=imageCropper.getCroppedImage(image,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
    @Test
    public void testGetCroppedImageForPng() throws Exception {

        String name="PngImage.png";
        BufferedImage image=imageReader.readImage(name);

        BufferedImage croppedImage=imageCropper.getCroppedImage(image,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
    @Test
    public void testGetCroppedImageForGif() throws Exception {

        String name="GifImage.gif";
        BufferedImage image=imageReader.readImage(name);

        BufferedImage croppedImage=imageCropper.getCroppedImage(image,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
}