package UserRequest;

import UserRequest.reader.MapReader;
import UserRequest.request.creator.OrientationRequestCreator;
import UserRequest.request.creator.OtherRequestCreator;
import UserRequest.request.creator.ScalingRequestCreator;
import UserRequest.requests.InputImage;
import UserRequest.requests.OrientationRequest;
import UserRequest.requests.OtherRequests;
import UserRequest.requests.ScalingRequest;
import helper.Coordinates;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class RequestList {
    InputImage inputImage;
    ScalingRequest scalingRequest;
    OrientationRequest orientationRequest;
    OtherRequests otherRequests;

    public RequestList(BufferedImage image, Map<String,String[]> parameterMap) {

        MapReader mapReader = new MapReader(parameterMap);

        inputImage =new InputImage(image);
        scalingRequest =new ScalingRequestCreator(mapReader,inputImage).create();
        orientationRequest =new OrientationRequestCreator(mapReader).create();
        otherRequests = new OtherRequestCreator(mapReader).create();
    }

    public BufferedImage getImage() {
        return inputImage.getImage();
    }

    public int getResponsHeight() {
        return scalingRequest.getResponseHeight();
    }

    public int getResponseWidth() {
        return scalingRequest.getResponseWidth();
    }

    public Color getColor() {
        return orientationRequest.getColor();
    }

    public String getMode() {
        return scalingRequest.getMode();
    }

    public String getOrientation() {
        return orientationRequest.getOrientation();
    }

    public float getAspectRatio() {
        return inputImage.getAspectRatio();
    }

    public Coordinates getCoordinates() {
        return orientationRequest.getCropCoordinates();
    }

    public String getEffect() {
        return otherRequests.getEffect();
    }


    public String getAngle() {
        return otherRequests.getAngle();
    }

    public String getFormat() {
        return otherRequests.getFormat();
    }

    public float getQuality() {
        return otherRequests.getQuality();
    }

    public int getRadius() {
        return otherRequests.getRadius();
    }

    public Dimension getResponseDimension() {
        return scalingRequest.getDimension();
    }


}
