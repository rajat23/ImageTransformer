package com.mode;

import com.helper.ImageReader;
import com.helper.RequestStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LimitModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {

        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure(image);
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"300"});
        map.put("width",new String[]{"400"});

        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode limitMode=modeFactory.create("limit");
        BufferedImage scaledImage=limitMode.getScaledImage(requestStructure);
        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {


        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure(image);
        Map<String,String[]> map=new HashMap<String, String[]>();

        map.put("width",new String[]{"400"});
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode limitMode=modeFactory.create("limit");
        BufferedImage scaledImage=limitMode.getScaledImage(requestStructure);
        assertEquals(300, scaledImage.getHeight());

    }


}