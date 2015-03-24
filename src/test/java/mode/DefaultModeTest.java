package mode;


import helper.RequestMapCreator;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class DefaultModeTest extends ModeTest  {


    @Test
    public void testGetDimensionsForBoth() throws Exception {

        String parameters []={"height=450","width=400","format=png"};
        map= new RequestMapCreator().createMap(parameters);
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

        String parameters []={"width=400","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());

    }

    @Test
    public void testGetDimensionsForWidth() throws Exception {

        String parameters []={"height=300","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(400, scaledImage.getWidth());

    }

    @Test
    public void testGetDimensionsForExceedingWidth() throws Exception {

        String parameters []={"width=900","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode mode=modeFactory.create("default");

        BufferedImage scaledImage=mode.getScaledImage(requestStructure);

        assertEquals(900, scaledImage.getWidth());

    }


}