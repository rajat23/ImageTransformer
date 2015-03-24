package effect;

import helper.ExpectedImage;
import helper.SampleImage;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import java.awt.image.BufferedImage;
import static org.junit.Assert.*;

public class BrightnessTest {

    private BufferedImage image;

    @Before
    public void beforeEachTest(){
        image = new SampleImage().get10by10(100);
    }

    @Test
    public void testGetEffectForParameter() throws Exception {


        Effectible effectible =new EffectFactory().create("brightness_80");
        image= effectible.getEffect(image);

        Color expectedColor=new Color(180,180,180);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));



    }
    @Test
    public void testGetEffectForDefulat() throws Exception {

        Effectible effectible =new EffectFactory().create("brightness");
        image= effectible.getEffect(image);

        Color expectedColor=new Color(160,160,160);

        assertTrue(new ExpectedImage().hasExpectedColor(image,expectedColor));

    }
}