package mode;

import UserRequest.RequestList;
import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class FitModeTest extends ModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {

        String parameters []={"width=900","format=png","height=600"};
        parameterMap = new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image, parameterMap);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        BufferedImage scaledImage=fitMode.getScaledImage(requestList);
        assertEquals(800, scaledImage.getWidth());
    }




    @Test
    public void testGetDimensionsForWidth() throws Exception {

        String parameters []={"format=png","height=300"};
        parameterMap = new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image, parameterMap);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        BufferedImage scaledImage=fitMode.getScaledImage(requestList);
        assertEquals(400, scaledImage.getWidth());

    }





    @Test
    public void testGetDimensionsForHeight() throws Exception {

        String parameters []={"format=png","width=400"};
        parameterMap = new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image, parameterMap);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(300, scaledImage.getHeight());
    }



}