package mode;


import helper.RequestMapCreator;
import helper.RequestStructure;
import org.junit.Test;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class CropModeTest extends ModeTest {



    @Test
    public void testGetScaledImageForBoth() throws Exception {

        String parameters []={"height=450","width=400","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(450, scaledImage.getHeight());
        assertEquals(400, scaledImage.getWidth());

    }




    @Test
    public void testGetScaledImageForLargerHeightWidth() throws Exception {

        String parameters []={"height=750","width=900","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(600, scaledImage.getHeight());
        assertEquals(800, scaledImage.getWidth());

    }


    @Test
    public void testGetScaledImageForNullHeight() throws Exception {

        String parameters []={"width=400","format=png"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());


    }



    @Test
    public void testGetScaledImageForFixedCoordinates() throws Exception {

        String parameters []={"width=500","format=png","x=400"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(400, scaledImage.getWidth());
        assertEquals(375, scaledImage.getHeight());


    }

    @Test
    public void testGetScaledImageForBigHW() throws Exception {

        String parameters []={"height=600","width=600","format=png","x=300","y=300"};
        map= new RequestMapCreator().createMap(parameters);
        requestStructure.setImage(image);
        requestStructure.setParameters(map);
        ModeFactory modeFactory=new ModeFactory();
        Mode fitMode=modeFactory.create("crop");

        BufferedImage scaledImage=fitMode.getScaledImage(requestStructure);

        assertEquals(300, scaledImage.getHeight());
        assertEquals(500, scaledImage.getWidth());


    }


}