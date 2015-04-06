package UserRequest.request.creator;

import UserRequest.requests.InputImage;
import UserRequest.requests.ScalingRequest;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.junit.Assert.*;

public class ScalingRequestCreatorTest extends CreatorTestData {

    @Test
    public void testCreate() throws Exception {
        BufferedImage image = new BufferedImage(500,500,BufferedImage.TYPE_3BYTE_BGR);
        ScalingRequestCreator scalingRequestCreator=new ScalingRequestCreator(reader,new InputImage(image));
        ScalingRequest scalingRequest = scalingRequestCreator.create();

        assertEquals(scalingRequest.getResponseHeight(),100);
        assertEquals(scalingRequest.getResponseWidth(),100);
        assertEquals(scalingRequest.getMode(),"fill");

    }

    @Test
    public void testCreateDefaultValues() throws Exception {
        BufferedImage image = new BufferedImage(500,500,BufferedImage.TYPE_3BYTE_BGR);
        ScalingRequestCreator scalingRequestCreator=new ScalingRequestCreator(defaultValuesReader,new InputImage(image));
        ScalingRequest scalingRequest = scalingRequestCreator.create();

        assertEquals(scalingRequest.getResponseHeight(),0);
        assertEquals(scalingRequest.getResponseWidth(),0);
        assertEquals(scalingRequest.getMode(),"");

    }
}