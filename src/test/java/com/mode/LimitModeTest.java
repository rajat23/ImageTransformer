package com.mode;

import com.helper.ImageReader;
import com.utility.RequestStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class LimitModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {


            String name="PngImage.png";
            ImageReader imageReader=new ImageReader();
            BufferedImage image=imageReader.readImage(name);

            RequestStructure requestStructure =new RequestStructure(0,0,800,700);
            ModeFactory modeFactory=new ModeFactory();
            Mode fitMode=modeFactory.create("limit");
            RequestStructure requestStructure1 =fitMode.getDimensions(image, requestStructure);
            assertEquals(600, requestStructure1.getHeight());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {


        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure(0,0,400,0);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("limit");
        RequestStructure requestStructure1 =fitMode.getDimensions(image, requestStructure);
        assertEquals(300, requestStructure1.getHeight());

    }


}