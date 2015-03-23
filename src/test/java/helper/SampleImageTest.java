package helper;

import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class SampleImageTest {

    @Test
    public void get2by2ImageTest(){
        BufferedImage image=new SampleImage().get2by2();

        assertEquals(image.getWidth(),2);
        assertEquals(image.getHeight(),2);
    }

    @Test
    public void get3by2ImageTest(){
        BufferedImage image=new SampleImage().get3by2();

        assertEquals(image.getWidth(),3);
        assertEquals(image.getHeight(),2);
    }

    @Test
    public void get10by10ImageTest(){
        BufferedImage image=new SampleImage().get10by10(100);

        assertEquals(image.getWidth(),10);
        assertEquals(image.getHeight(),10);
    }

}
