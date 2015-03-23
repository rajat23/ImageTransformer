package mode;

import helper.ImageReader;
import helper.RequestStructure;
import mode.Mode;
import mode.ModeFactory;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CropModeTest {

    private ImageReader imageReader;
    private BufferedImage image;
    private RequestStructure requestStructure;
    private Map<String,String[]> map;

    @Before
    public void beforeEachTest(){
        imageReader = new ImageReader();
        try {
            image = imageReader.readImage("PngImage.png");
        }
        catch (Exception exception){
            System.out.println("Error Reading image");
            return;
        }
        requestStructure = new RequestStructure();
        map = new HashMap<String, String[]>();
    }

    @Test
    public void testGetScaledImageForBoth() throws Exception {

        map.put("height",new String[]{"450"});
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
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

        map.put("height",new String[]{"750"});
        map.put("width",new String[]{"900"});
        map.put("format",new String[]{"png"});
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

        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());


    }



    @Test
    public void testGetScaledImageForFixedCoordinates() throws Exception {

        map.put("width",new String[]{"500"});
        map.put("x",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(400, scaledImage.getWidth());
        assertEquals(375, scaledImage.getHeight());


    }

    @Test
    public void testGetScaledImageForBigHW() throws Exception {

        map.put("width",new String[]{"600"});
        map.put("height",new String[]{"600"});
        map.put("x",new String[]{"300"});
        map.put("y",new String[]{"300"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());
        assertEquals(500, scaledImage.getWidth());


    }


}