package rotate;

import helper.SampleImage;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class HflipTest {

    @Test
    public void testRotateSquareImage() throws Exception {
        BufferedImage image=new SampleImage().get2by2();

        Rotable rotable =new RotatorFactory().create("hflip");
        image= rotable.rotateImage(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(2,2,2));
        assertEquals(new Color(image.getRGB(1,0)),new Color(1,1,1));
        assertEquals(new Color(image.getRGB(0,1)),new Color(4,4,4));
        assertEquals(new Color(image.getRGB(1,1)),new Color(3,3,3));
    }





    @Test
    public void testRotateRectangleImage() throws Exception {
        BufferedImage image=new SampleImage().get3by2();

        Rotable rotable =new RotatorFactory().create("hflip");
        image= rotable.rotateImage(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(5,5,5));
        assertEquals(new Color(image.getRGB(1,0)),new Color(2,2,2));
        assertEquals(new Color(image.getRGB(2,0)),new Color(1,1,1));
        assertEquals(new Color(image.getRGB(0,1)),new Color(6,6,6));
        assertEquals(new Color(image.getRGB(1,1)),new Color(4,4,4));
        assertEquals(new Color(image.getRGB(2,1)),new Color(3,3,3));
    }

}