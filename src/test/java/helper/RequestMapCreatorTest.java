package helper;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class RequestMapCreatorTest {

    @Test
    public void testCreateMap() throws Exception {
        String parameters []={"height=300","format=png"};

        Map map= new RequestMapCreator().createMap(parameters);

        assertEquals(((String[]) map.get("height"))[0],"300");
        assertEquals(((String[]) map.get("format"))[0],"png");
    }
}