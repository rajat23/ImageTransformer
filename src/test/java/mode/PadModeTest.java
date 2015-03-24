package mode;

import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class PadModeTest extends ModeTest {

    @Test
    public void testGetScaledImage() throws Exception {

        String parameters []={"height=300","width=400","format=png","orientation=north_west"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("pad");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),400);
        assertEquals(scaledImage.getHeight(),300);

    }

    @Test
    public void testGetScaledImageForBigDim() throws Exception {

        String parameters []={"height=1000","width=4000","format=png","orientation=north_west"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("pad");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),4000);
        assertEquals(scaledImage.getHeight(),1000);

    }

}