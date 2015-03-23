package mode;

import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class PadModeTest extends ModeTest {

    @Test
    public void testGetScaledImage() throws Exception {

        map.put("height",new String[]{"300"});
        map.put("width",new String[]{"400"});
        map.put("orientation",new String[]{"north_west"});
        map.put("format",new String[]{"png"});
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

        map.put("height",new String[]{"1000"});
        map.put("width",new String[]{"4000"});
        map.put("orientation",new String[]{"north_west"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fillMode=modeFactory.create("pad");

        BufferedImage scaledImage=fillMode.getScaledImage(requestStructure);

        assertEquals(scaledImage.getWidth(),4000);
        assertEquals(scaledImage.getHeight(),1000);

    }

}