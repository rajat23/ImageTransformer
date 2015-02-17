package com.mode;

import com.helper.ImageReader;
import com.utility.ImageStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class LimitModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {


            String name="PngImage.png";
            ImageReader imageReader=new ImageReader();
            BufferedImage image=imageReader.readImage(name);

            ImageStructure imageStructure=new ImageStructure(0,0,800,700);
            ModeFactory modeFactory=new ModeFactory();
            Mode fitMode=modeFactory.create("limit");
            ImageStructure imageStructure1=fitMode.getDimensions(image, imageStructure);
            assertEquals(600,imageStructure1.getHeight());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {


        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        ImageStructure imageStructure=new ImageStructure(0,0,400,0);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("limit");
        ImageStructure imageStructure1=fitMode.getDimensions(image, imageStructure);
        assertEquals(300,imageStructure1.getHeight());

    }


}