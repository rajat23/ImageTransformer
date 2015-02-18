package com.mode;

import com.helper.ImageReader;
import com.utility.RequestStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class FitModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure(0,0,400,300);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        RequestStructure requestStructure1 =fitMode.getDimensions(image, requestStructure);
       assertEquals(300, requestStructure1.getHeight());




    }


    @Test
    public void testGetDimensionsForWidth() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure(0,0,0,300);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        RequestStructure requestStructure1 =fitMode.getDimensions(image, requestStructure);
        assertEquals(400, requestStructure1.getWidth());




    }



    @Test
    public void testGetDimensionsForHeight() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure(0,0,400,0);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        RequestStructure requestStructure1 =fitMode.getDimensions(image, requestStructure);
        assertEquals(300, requestStructure1.getHeight());




    }



}