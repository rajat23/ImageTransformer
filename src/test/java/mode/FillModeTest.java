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

public class FillModeTest {

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
    public void testGetScaledImage() throws Exception {

        map.put("height",new String[]{"300"});
        map.put("width",new String[]{"400"});
        map.put("orientation",new String[]{"north_west"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("fill");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),400);
        assertEquals(scaledImage.getHeight(),300);

    }

    @Test
    public void testGetScaledImageForBigDim() throws Exception {

        map.put("height",new String[]{"1000"});
        map.put("width",new String[]{"4000"});
        map.put("orientation",new String[]{"north_west"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("fill");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),4000);
        assertEquals(scaledImage.getHeight(),1000);

    }

}