package mode.strategies;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ShrinkDimensionTest {
    private Dimension dimension;
    private float aspectRatio;
    private ShrinkDimension shrinkDimension;


    @Before
    public void beforeEachTest(){
        shrinkDimension=new ShrinkDimension();
    }

    @Test
    public void testChangeDimension() throws Exception {
        dimension=new Dimension(1000,600);
        aspectRatio=2.0f;

        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),1000);
        assertEquals((int)dimension.getHeight(),500);

    }

    @Test
    public void testChangeDimensionForCeil() throws Exception {
        dimension=new Dimension(100,150);
        aspectRatio=1.5f;

        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),100);
        assertEquals((int)dimension.getHeight(),67);

    }

    @Test
    public void testChangeDimensionForFloor() throws Exception {
        dimension=new Dimension(101,150);
        aspectRatio=1.5f;

        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),101);
        assertEquals((int)dimension.getHeight(),67);

    }

    @Test
    public void testChangeDimensionForEqual() throws Exception {
        dimension=new Dimension(150,100);
        aspectRatio=1.5f;

        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),150);
        assertEquals((int)dimension.getHeight(),100);

    }
}