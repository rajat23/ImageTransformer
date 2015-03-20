package helper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestStructureTest {
    private RequestStructure requestStructure;

    @Before
    public void beforeEachTest(){
        requestStructure=new RequestStructure();
    }

    @Test
    public void testGetProportionalHeight() throws Exception {

        int height=requestStructure.getProportionalHeight(600, 1.5f);
        
        assertEquals(height,400);

    }

    @Test
    public void testGetProportionalWidth() throws Exception {

        int width=requestStructure.getProportionalWidth(600, 1.5f);

        assertEquals(width,900);

    }


    @Test
    public void testGetWidth() throws Exception {
        String width="0.5";
        int imageWidth=500;

        int expectedWidth=requestStructure.getWidth(width,imageWidth);

        assertEquals(expectedWidth,250);

    }

    @Test
    public void testGetHeight() throws Exception {
        String height="0.5";
        int imageheight=500;

        int expectedHeight=requestStructure.getWidth(height,imageheight);

        assertEquals(expectedHeight,250);

    }
}