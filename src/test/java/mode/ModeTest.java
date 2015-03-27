package mode;

import helper.ImageReader;
import UserRequest.RequestList;
import org.junit.Before;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ModeTest {
    protected ImageReader imageReader;
    protected BufferedImage image;
    protected RequestList requestList;
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
        map = new HashMap<String, String[]>();
    }
}
