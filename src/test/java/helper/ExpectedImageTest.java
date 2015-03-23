package helper;

import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ExpectedImageTest {
    @Test
    public void hasExpectedColorTest(){
        BufferedImage image=new SampleImage().get10by10(100);
        Color expectedColor=new Color(100,100,100);

        ExpectedImage expectedImage=new ExpectedImage();
        assertTrue(expectedImage.hasExpectedColor(image,expectedColor));
    }
}
