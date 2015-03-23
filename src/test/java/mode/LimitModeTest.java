package mode;

import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class LimitModeTest extends ModeTest {

    @Test
    public void testGetDimensionsForBoth() throws Exception {


        map.put("height",new String[]{"450"});
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("limit");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {

        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode limitMode=modeFactory.create("limit");

        BufferedImage scaledImage=limitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForExceedingWidth() throws Exception {

        map.put("width",new String[]{"900"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode limitMode=modeFactory.create("limit");

        BufferedImage scaledImage=limitMode.getScaledImage(requestStructure);

        assertEquals(800, scaledImage.getWidth());

    }


}