package com.mode;

import com.helper.ImageReader;
import com.helper.RequestStructure;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FillModeTest {
    @Test
    public void testGetScaledImage() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        RequestStructure requestStructure =new RequestStructure();
        requestStructure.setImage(image);
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"300"});
        map.put("width",new String[]{"400"});
        map.put("orientation",new String[]{"north_west"});
        map.put("format",new String[]{"png"});
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("fill");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),400);
        assertEquals(scaledImage.getHeight(),300);

    }

    @Test
    public void testGetScaledImageForBigDim() throws Exception {
        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        RequestStructure requestStructure =new RequestStructure();
        requestStructure.setImage(image);
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"1000"});
        map.put("width",new String[]{"4000"});
        map.put("orientation",new String[]{"north_west"});
        map.put("format",new String[]{"png"});
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("fill");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),4000);
        assertEquals(scaledImage.getHeight(),1000);

    }

}