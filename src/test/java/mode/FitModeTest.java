package mode;

import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class FitModeTest extends ModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {

        String parameters []={"width=900","format=png","height=600"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(800, scaledImage.getWidth());
    }




    @Test
    public void testGetDimensionsForWidth() throws Exception {

        String parameters []={"format=png","height=300"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");
        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);
        assertEquals(400, scaledImage.getWidth());

    }





    @Test
    public void testGetDimensionsForHeight() throws Exception {

        String parameters []={"format=png","width=400"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("fit");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());
    }



}