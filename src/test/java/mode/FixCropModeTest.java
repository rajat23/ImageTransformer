package mode;

import UserRequest.RequestList;
import helper.RequestMapCreator;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class FixCropModeTest extends ModeTest {

    @Test
    public void testGetScaledImageForFixedCoordinates() throws Exception {

        String parameters []={"width=500","format=png","x=400"};
        parameterMap = new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image, parameterMap);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fixcrop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(400, scaledImage.getWidth());
        assertEquals(375, scaledImage.getHeight());


    }

    @Test
    public void testGetScaledImageForBigHW() throws Exception {

        String parameters []={"height=600","width=600","format=png","x=300","y=300"};
        parameterMap = new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image, parameterMap);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fixcrop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(300, scaledImage.getHeight());
        assertEquals(500, scaledImage.getWidth());


    }
}