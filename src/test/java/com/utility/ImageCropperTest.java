package com.utility;

import com.helper.ImageReader;
import org.junit.Test;
import java.awt.image.BufferedImage;
import java.net.URL;

import static org.junit.Assert.*;
public class ImageCropperTest {

    @Test
    public void testGetCroppedImageForJpg() throws Exception {

        String name="JpgImage.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        int x=10,y=10;
        int width=100,height=100;

        ImageCropper imageCropper=new ImageCropper();
        BufferedImage croppedImage=imageCropper.getCroppedImage(image,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
    @Test
    public void testGetCroppedImageForPng() throws Exception {

        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        int x=10,y=10;
        int width=100,height=100;

        ImageCropper imageCropper=new ImageCropper();
        BufferedImage croppedImage=imageCropper.getCroppedImage(image,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
    @Test
    public void testGetCroppedImageForGif() throws Exception {

        String name="GifImage.gif";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        int x=10,y=10;
        int width=100,height=100;

        ImageCropper imageCropper=new ImageCropper();
        BufferedImage croppedImage=imageCropper.getCroppedImage(image,x,y,width,height);

        assertEquals(width,croppedImage.getWidth());
        assertEquals(height,croppedImage.getHeight());

    }
}