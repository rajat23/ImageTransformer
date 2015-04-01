package UserRequest.reader;

import helper.RequestMapCreator;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Map;

import static org.junit.Assert.*;

public class MapReaderTest {
    private MapReader reader;
    private MapReader defaultValuesReader;

    @Before
    public void initializeMap(){
        String  requestString1 [] = {"path=abc.jpg","width=100","radius=10","color=yellow","format=png","quality=1.0"};
        String  requestString2 [] = {"path=abc.jpg"};
        Map<String, String[]> parameterMap = new RequestMapCreator().createMap(requestString1);
        Map<String, String[]> nullMap = new RequestMapCreator().createMap(requestString2);
        reader = new MapReader(parameterMap);
        defaultValuesReader = new MapReader(nullMap);
    }

    @Test
    public void testReadString() throws Exception {
        assertEquals(reader.readString("width"),"100");
        assertEquals(defaultValuesReader.readString("width"),"0");

    }

    @Test
    public void testReadInteger() throws Exception {
        assertEquals(reader.readInteger("radius"),10);
        assertEquals(defaultValuesReader.readInteger("radius"),0);

    }

    @Test
    public void testReadFloat() throws Exception {
        assertEquals(reader.readFloat("quality"),1.0f,0.0f);
        assertEquals(defaultValuesReader.readFloat("quality"),-1.0f,0.0f);

    }

    @Test
    public void testReadColor() throws Exception {
        assertEquals(reader.readColor(), Color.YELLOW);
        assertEquals(defaultValuesReader.readColor(), Color.WHITE);

    }

    @Test
    public void testReadFormat() throws Exception {
        assertEquals(reader.readFormat(),"png");
        assertEquals(defaultValuesReader.readFormat(),"jpg");

    }
}