package mode;

import helper.ImageReader;
import helper.RequestStructure;
import org.junit.Before;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ModeTest {
    protected ImageReader imageReader;
    protected BufferedImage image;
    protected RequestStructure requestStructure;
    protected Map<String,String[]> map;

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
}
