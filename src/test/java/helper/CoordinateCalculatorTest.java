package helper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateCalculatorTest {
    private int expectedXCoordinate;
    private int expectedYCoordinate;
    private CoordinateCalculator coordinateCalculator;

    @Before
    public void beforeEachTest(){
        coordinateCalculator=new CoordinateCalculator();
    }

    @Test
    public void testGetCoordinatesNorthWest() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,500,200,"top_left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesNorthEast() throws Exception {
        expectedXCoordinate=700;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"top_right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesNorthEasForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"top_right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesNorthEastForFullHeight() throws Exception {
        expectedXCoordinate=800;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"top_right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthWest() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"bottom_left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthWestForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"bottom_left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthWestForFullHeight() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"bottom_left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthEast() throws Exception {
        expectedXCoordinate=700;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"bottom_right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthEastForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"bottom_right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthEastForFullHeight() throws Exception {
        expectedXCoordinate=800;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"bottom_right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesNorth() throws Exception {
        expectedXCoordinate=350;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"top");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesNorthForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"top");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesNorthForFullHeight() throws Exception {
        expectedXCoordinate=400;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"top");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesWest() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=400;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesWestForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=400;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesWestForFullHeight() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"left");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouth() throws Exception {
        expectedXCoordinate=350;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"bottom");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=800;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"bottom");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthForFullHeight() throws Exception {
        expectedXCoordinate=400;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"bottom");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesEast() throws Exception {
        expectedXCoordinate=700;
        expectedYCoordinate=400;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesEastForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=400;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesEastForFullHeight() throws Exception {
        expectedXCoordinate=800;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"right");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesCenter() throws Exception {
        expectedXCoordinate=350;
        expectedYCoordinate=400;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"center");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatescenterForFullWidtht() throws Exception {
        expectedXCoordinate=0;
        expectedYCoordinate=400;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"center");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesCenterForFullHeight() throws Exception {
        expectedXCoordinate=400;
        expectedYCoordinate=0;

        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"center");

        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
}