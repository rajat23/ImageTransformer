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

public class DefaultModeTest {


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
    public void testGetDimensionsForBoth() throws Exception {

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