package UserRequest.request.creator;

import UserRequest.requests.OrientationRequest;
import helper.Coordinates;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class OrientationRequestCreatorTest extends CreatorTestData {

    @Test
    public void testCreate() throws Exception {
        OrientationRequestCreator orientationRequestCreator=new OrientationRequestCreator(reader);
        OrientationRequest orientationRequest = orientationRequestCreator.create();

        assertEquals(orientationRequest.getOrientation(),"top");
        assertEquals(orientationRequest.getColor(), Color.yellow);
        assertEquals(orientationRequest.getCropCoordinates(),new Coordinates(9,66));

    }

    @Test
    public void testCreateDefaultValues() throws Exception {
        OrientationRequestCreator orientationRequestCreator=new OrientationRequestCreator(defaultValuesReader);
        OrientationRequest orientationRequest = orientationRequestCreator.create();

        assertEquals(orientationRequest.getOrientation(),"center");
        assertEquals(orientationRequest.getColor(), Color.white);
        assertEquals(orientationRequest.getCropCoordinates(),new Coordinates(0,0));

    }
}