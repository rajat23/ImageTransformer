package mode;

import UserRequest.RequestList;
import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class LimitModeTest extends ModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {

        String parameters []={"format=png","height=450","width=400"};
        map= new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image,map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("limit");

        BufferedImage scaledImage=fitMode.getScaledImage(requestList);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {

        String parameters []={"format=png","width=400"};
        map= new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image,map);
        ModeFactory modeFactory=new ModeFactory();
        Mode limitMode=modeFactory.create("limit");

        BufferedImage scaledImage=limitMode.getScaledImage(requestList);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForExceedingWidth() throws Exception {

        String parameters []={"format=png","width=900"};
        map= new RequestMapCreator().createMap(parameters);
        requestList = new RequestList(image,map);
        ModeFactory modeFactory=new ModeFactory();
        Mode limitMode=modeFactory.create("limit");

        BufferedImage scaledImage=limitMode.getScaledImage(requestList);

        assertEquals(800, scaledImage.getWidth());

    }


}