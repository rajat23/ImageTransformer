package com.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateCalculatorTest {

    @Test
    public void testGetCoordinatesNorthWest() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,500,200,"north_west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesNorthEast() throws Exception {
        int expectedXCoordinate=700;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"north_east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesNorthEasForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"north_east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesNorthEastForFullHeight() throws Exception {
        int expectedXCoordinate=800;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"north_east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthWest() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=800;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"south_west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthWestForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=800;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"south_west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthWestForFullHeight() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"south_west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthEast() throws Exception {
        int expectedXCoordinate=700;
        int expectedYCoordinate=800;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"south_east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthEastForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=800;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"south_east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthEastForFullHeight() throws Exception {
        int expectedXCoordinate=800;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"south_east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesNorth() throws Exception {
        int expectedXCoordinate=350;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"north");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesNorthForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"north");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesNorthForFullHeight() throws Exception {
        int expectedXCoordinate=400;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"north");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesWest() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=400;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesWestForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=400;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesWestForFullHeight() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"west");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouth() throws Exception {
        int expectedXCoordinate=350;
        int expectedYCoordinate=800;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"south");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesSouthForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=800;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"south");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesSouthForFullHeight() throws Exception {
        int expectedXCoordinate=400;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"south");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesEast() throws Exception {
        int expectedXCoordinate=700;
        int expectedYCoordinate=400;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatesEastForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=400;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesEastForFullHeight() throws Exception {
        int expectedXCoordinate=800;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"east");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesCenter() throws Exception {
        int expectedXCoordinate=350;
        int expectedYCoordinate=400;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,300,200,"center");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
    @Test
    public void testGetCoordinatescenterForFullWidtht() throws Exception {
        int expectedXCoordinate=0;
        int expectedYCoordinate=400;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,1000,200,"center");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }

    @Test
    public void testGetCoordinatesCenterForFullHeight() throws Exception {
        int expectedXCoordinate=400;
        int expectedYCoordinate=0;
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();
        Coordinates returnedCoordinates=coordinateCalculator.getCoordinates(1000,1000,200,1000,"center");
        assertEquals(expectedXCoordinate,returnedCoordinates.getX());
        assertEquals(expectedYCoordinate,returnedCoordinates.getY());
    }
}