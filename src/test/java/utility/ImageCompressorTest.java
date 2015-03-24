package utility;

import helper.ImageReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.*;
public class ImageCompressorTest {

    private ImageCompressor imageCompressor;
    private ImageReader imageReader;
    private File originalImageFile;
    private File commpressedImageFile;

    @Before
    public void beforeEachTest(){
        imageCompressor = new ImageCompressor();
        imageReader = new ImageReader();
        commpressedImageFile=new File("compressedImage.jpg");

    }


    @Test
    public void testgetCompressImageJpeg() throws Exception {

        String name = "JpgImage.jpg";
        BufferedImage image = imageReader.readImage(name);
        originalImageFile=new File(System.getProperty("user.dir")+"/upload/"+name);
        ImageIO.write(image,"jpg",originalImageFile);

        BufferedImage compressedImage = imageCompressor.getCompressImage(image, 0.05f);
        ImageIO.write(compressedImage,"jpg",commpressedImageFile);

    }
    @Test
    public void testgetCompressImagePng() throws Exception {

        String name = "PngImage.png";
        BufferedImage image = imageReader.readImage(name);
        originalImageFile=new File(System.getProperty("user.dir")+"/upload/"+name);
        ImageIO.write(image,"jpg",originalImageFile);

        BufferedImage compressedImage = imageCompressor.getCompressImage(image, 0.05f);
        ImageIO.write(compressedImage,"jpg",commpressedImageFile);

    }
    @Test
    public void testgetCompressImageGif() throws Exception {

        String name = "GifImage.gif";
        BufferedImage image = imageReader.readImage(name);
        originalImageFile=new File(System.getProperty("user.dir")+"/upload/"+name);
        ImageIO.write(image,"jpg",originalImageFile);

        BufferedImage compressedImage = imageCompressor.getCompressImage(image, 0.05f);
        ImageIO.write(compressedImage,"jpg",commpressedImageFile);

    }

    @After
    public void afterEachTest(){

        assertTrue(commpressedImageFile.length()<=originalImageFile.length());
        commpressedImageFile.delete();

    }
}
