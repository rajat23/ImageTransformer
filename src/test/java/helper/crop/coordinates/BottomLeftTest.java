package helper.crop.coordinates;

import helper.Coordinates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BottomLeftTest {

    private int expectedXCoordinate;
    private int expectedYCoordinate;
    private Cropable cropable;

    @Before
    public void beforeEachTest(){
        cropable=new CropFactory().create("bottom_left");
    }

    @Test
    public void testGetCoordinates() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=cropable.getCoordinates(1000,1000,300,200);

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=cropable.getCoordinates(1000,1000,1000,200);

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesForFullHeight() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=cropable.getCoordinates(1000,1000,200,1000);

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
}