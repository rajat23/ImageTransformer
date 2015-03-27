package mode;


import UserRequest.RequestList;
import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class CropModeTest extends ModeTest {



    @Test
    public void testGetScaledImageForBoth() throws Exception {

        String parameters []={"height=450","width=400","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image,map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(450, scaledImage.getHeight());
        assertEquals(400, scaledImage.getWidth());

    }




    @Test
    public void testGetScaledImageForLargerHeightWidth() throws Exception {

        String parameters []={"height=750","width=900","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image,map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(600, scaledImage.getHeight());
        assertEquals(800, scaledImage.getWidth());

    }


    @Test
    public void testGetScaledImageForNullHeight() throws Exception {

        String parameters []={"width=400","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image,map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(300, scaledImage.getHeight());


    }

}