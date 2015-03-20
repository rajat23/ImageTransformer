package mode.strategies;

import mode.strategies.ExpandDimension;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ExpandDimensionTest {
    @Test
    public void testDoOperationForWidth() throws Exception {
        Dimension dimension=new Dimension(1000,600);
        float aspectRatio=2.0f;
        ExpandDimension expandDimension=new ExpandDimension();

        dimension=expandDimension.doOperation(dimension,aspectRatio);

        assertEquals((int)dimension.getWidth(),1200);
        assertEquals((int)dimension.getHeight(),600);

    }

    @Test
    public void testDoOperationForHeight() throws Exception {
        Dimension dimension=new Dimension(400,150);
        float aspectRatio=2.0f;
        ExpandDimension expandDimension=new ExpandDimension();

        dimension=expandDimension.doOperation(dimension,aspectRatio);

        assertEquals((int)dimension.getWidth(),400);
        assertEquals((int)dimension.getHeight(),200);

    }

    @Test
    public void testDoOperationForFloor() throws Exception {
        Dimension dimension=new Dimension(1,67);
        float aspectRatio=1.6f;
        ExpandDimension expandDimension=new ExpandDimension();

        dimension=expandDimension.doOperation(dimension,aspectRatio);

        assertEquals((int)dimension.getWidth(),107);
        assertEquals((int)dimension.getHeight(),67);

    }
    @Test
    public void testDoOperationForCeil() throws Exception {
        Dimension dimension=new Dimension(1,68);
        float aspectRatio=1.6f;
        ExpandDimension expandDimension=new ExpandDimension();

        dimension=expandDimension.doOperation(dimension,aspectRatio);

        assertEquals((int)dimension.getWidth(),109);
        assertEquals((int)dimension.getHeight(),68);

    }

    @Test
    public void testDoOperationForEqual() throws Exception {
        Dimension dimension=new Dimension(150,100);
        float aspectRatio=1.5f;
        ExpandDimension expandDimension=new ExpandDimension();

        dimension=expandDimension.doOperation(dimension,aspectRatio);

        assertEquals((int)dimension.getWidth(),150);
        assertEquals((int)dimension.getHeight(),100);

    }

}