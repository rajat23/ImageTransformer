package mode;

import helper.ImageReader;
import helper.RequestStructure;
import mode.Mode;
import mode.ModeFactory;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DefaultModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {

        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);

        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"450"});
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(450, scaledImage.getHeight());
        assertEquals(400, scaledImage.getWidth());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {


        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForWidth() throws Exception {


        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("height",new String[]{"300"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(400, scaledImage.getWidth());

    }

    @Test
    public void testGetDimensionsForExceedingWidth() throws Exception {


        String name="PngImage.png";
        ImageReader imageReader=new ImageReader();
        BufferedImage image=imageReader.readImage(name);
        RequestStructure requestStructure =new RequestStructure();
        Map<String,String[]> map=new HashMap<String, String[]>();
        map.put("width",new String[]{"900"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(900, scaledImage.getWidth());

    }


}