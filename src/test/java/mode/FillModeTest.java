package mode;

import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class FillModeTest extends ModeTest {

    @Test
    public void testGetScaledImage() throws Exception {

        String parameters []={"width=400","format=png","height=300","orientation=north_west"};
        map= new RequestMapCreator().createMap(parameters);
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

        String parameters []={"width=4000","format=png","height=1000","orientation=north_west"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("fill");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),4000);
        assertEquals(scaledImage.getHeight(),1000);

    }

}