package UserRequest.request.creator;

import UserRequest.requests.OrientationRequest;
import UserRequest.requests.OtherRequests;
import helper.Coordinates;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class OtherRequestCreatorTest extends CreatorTestData {

    @Test
    public void testCreate() throws Exception {
        OtherRequestCreator otherRequestCreator = new OtherRequestCreator(reader);
        OtherRequests otherRequests = otherRequestCreator.create();

        assertEquals(otherRequests.getAngle(),"50");
        assertEquals(otherRequests.getEffect(),"sepia");
        assertEquals(otherRequests.getFormat(),"png");
        assertEquals(otherRequests.getQuality(),1.0f,0.0f);
        assertEquals(otherRequests.getRadius(),10);

    }

    @Test
    public void testCreateDefaultValues() throws Exception {
        OtherRequestCreator otherRequestCreator = new OtherRequestCreator(defaultValuesReader);
        OtherRequests otherRequests = otherRequestCreator.create();

        assertEquals(otherRequests.getAngle(),"0");
        assertEquals(otherRequests.getEffect(),"");
        assertEquals(otherRequests.getFormat(),"jpg");
        assertEquals(otherRequests.getQuality(),-1.0f,0.0f);
        assertEquals(otherRequests.getRadius(),0);

    }


}