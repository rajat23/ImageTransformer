package com.mode;

import com.helper.ImageReader;
import com.helper.RequestStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CropModeTest {

    @Test
    public void testGetScaledImageForBoth() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"450"});
        map.put("width",new String[]{"400"});

        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(450, scaledImage.getHeight());
        assertEquals(400, scaledImage.getWidth());

    }




    @Test
    public void testGetScaledImageForLargerHeightWidth() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"750"});
        map.put("width",new String[]{"900"});

        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(600, scaledImage.getHeight());
        assertEquals(800, scaledImage.getWidth());

    }


    @Test
    public void testGetScaledImageForNullHeight() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("width",new String[]{"400"});

        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(300, scaledImage.getHeight());


    }


}