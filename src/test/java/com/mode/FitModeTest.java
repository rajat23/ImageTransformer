package com.mode;

import com.helper.ImageReader;
import com.helper.RequestStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FitModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {
        String name="JpgImage.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"200"});
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"jpg"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(300, scaledImage.getWidth());
    }




    @Test
    public void testGetDimensionsForWidth() throws Exception {
        String name="JpgImage.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"300"});
        map.put("format",new String[]{"jpg"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(450, scaledImage.getWidth());

    }





    @Test
    public void testGetDimensionsForHeight() throws Exception {
        String name="JpgImage.jpg";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"jpg"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(266, scaledImage.getHeight());
    }



}