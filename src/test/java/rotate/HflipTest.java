package rotate;

import org.junit.Test;
import rotate.Angle;
import rotate.AngleFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class HflipTest {

    @Test
    public void testRotateImage() throws Exception {
        BufferedImage image=new BufferedImage(2,2,BufferedImage.TYPE_3BYTE_BGR);
        image.setRGB(0, 0, new Color(1, 1, 1).getRGB());
        image.setRGB(1, 0, new Color(2, 2, 2).getRGB());
        image.setRGB(0, 1, new Color(3, 3, 3).getRGB());
        image.setRGB(1, 1, new Color(4, 4, 4).getRGB());

        Angle angle=new AngleFactory().create("hflip");
        image=angle.rotateImage(image);

        assertEquals(new Color(image.getRGB(0,0)),new Color(2,2,2));
        assertEquals(new Color(image.getRGB(1,0)),new Color(1,1,1));
        assertEquals(new Color(image.getRGB(0,1)),new Color(4,4,4));
        assertEquals(new Color(image.getRGB(1,1)),new Color(3,3,3));
    }
}