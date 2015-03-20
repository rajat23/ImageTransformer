package effect;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class BlackWhiteTest {
    private BufferedImage image;

    @Before
    public void beforeEachTest(){
        image=new BufferedImage(2,2,BufferedImage.TYPE_3BYTE_BGR);
        image.setRGB(0, 0, new Color(22, 22, 22).getRGB());
        image.setRGB(1, 0, new Color(222, 222, 222).getRGB());
        image.setRGB(0, 1, new Color(211, 211, 211).getRGB());
        image.setRGB(1, 1, new Color(10, 10, 10).getRGB());
    }

    @Test
    public void testGetEffect() throws Exception {

        Effectible effectible =new EffectFactory().create("blackwhite");
        image= effectible.getEffect(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(0,0,0));
    }

    @Test
    public void testGetEffectForParameter() throws Exception {

        Effectible effectible =new EffectFactory().create("blackwhite_20");
        image= effectible.getEffect(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(255,255,255));

    }
    @After
    public void afterEachTest(){
        assertEquals(new Color(image.getRGB(1,0)),new Color(255,255,255));
        assertEquals(new Color(image.getRGB(0,1)),new Color(255,255,255));
        assertEquals(new Color(image.getRGB(1,1)),new Color(0,0,0));
    }
}