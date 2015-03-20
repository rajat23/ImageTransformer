package mode.strategies;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ShrinkDimensionTest {

    @Test
    public void testDoOperation() throws Exception {
        Dimension dimension=new Dimension(1000,600);
        float aspectRatio=2.0f;
        ShrinkDimension shrinkDimension=new ShrinkDimension();
        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),1000);
        assertEquals((int)dimension.getHeight(),500);

    }

    @Test
    public void testDoOperationForCeil() throws Exception {
        Dimension dimension=new Dimension(100,150);
        float aspectRatio=1.5f;
        ShrinkDimension shrinkDimension=new ShrinkDimension();
        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),100);
        assertEquals((int)dimension.getHeight(),67);

    }

    @Test
    public void testDoOperationForFloor() throws Exception {
        Dimension dimension=new Dimension(101,150);
        float aspectRatio=1.5f;
        ShrinkDimension shrinkDimension=new ShrinkDimension();
        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),101);
        assertEquals((int)dimension.getHeight(),67);

    }

    @Test
    public void testDoOperationForEqual() throws Exception {
        Dimension dimension=new Dimension(150,100);
        float aspectRatio=1.5f;
        ShrinkDimension shrinkDimension=new ShrinkDimension();
        dimension=shrinkDimension.changeDimension(dimension, aspectRatio);

        assertEquals((int)dimension.getWidth(),150);
        assertEquals((int)dimension.getHeight(),100);

    }
}