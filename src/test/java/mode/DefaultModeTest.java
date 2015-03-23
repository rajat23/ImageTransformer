package mode;


import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class DefaultModeTest extends ModeTest  {


    @Test
    public void testGetDimensionsForBoth() throws Exception {

        map.put("height",new String[]{"450"});
        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(450, scaledImage.getHeight());
        assertEquals(400, scaledImage.getWidth());

    }

    @Test
    public void testGetDimensionsForHeight() throws Exception {

        map.put("width",new String[]{"400"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForWidth() throws Exception {

        map.put("height",new String[]{"300"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(400, scaledImage.getWidth());

    }

    @Test
    public void testGetDimensionsForExceedingWidth() throws Exception {

        map.put("width",new String[]{"900"});
        map.put("format",new String[]{"png"});
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(900, scaledImage.getWidth());

    }


}