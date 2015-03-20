package mode.strategies;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ExpandDimensionTest {
    private Dimension dimension;
    private float aspectRatio;
    private ExpandDimension expandDimension;


    @Before
    public void beforeEachTest(){
        expandDimension=new ExpandDimension();
    }

    @Test
    public void testChangeDimensionForWidth() throws Exception {
        dimension=new Dimension(1000,600);
        aspectRatio=2.0f;

        dimension=expandDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),1200);
        assertEquals((int)dimension.getHeight(),600);

    }

    @Test
    public void testChangeDimensionForHeight() throws Exception {
        dimension=new Dimension(400,150);
        aspectRatio=2.0f;

        dimension=expandDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),400);
        assertEquals((int)dimension.getHeight(),200);

    }

    @Test
    public void testChangeDimensionForFloor() throws Exception {
        dimension=new Dimension(1,67);
        aspectRatio=1.6f;

        dimension=expandDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),107);
        assertEquals((int)dimension.getHeight(),67);

    }
    @Test
    public void testChangeDimensionForCeil() throws Exception {
        dimension=new Dimension(1,68);
        aspectRatio=1.6f;

        dimension=expandDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),109);
        assertEquals((int)dimension.getHeight(),68);

    }

    @Test
    public void testChangeDimensionForEqual() throws Exception {
        dimension=new Dimension(150,100);
        aspectRatio=1.5f;

        dimension=expandDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),150);
        assertEquals((int)dimension.getHeight(),100);

    }

}