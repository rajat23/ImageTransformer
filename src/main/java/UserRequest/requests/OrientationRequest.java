package UserRequest.requests;

import helper.Coordinates;

import java.awt.*;

public class OrientationRequest {

    String orientation;
    Coordinates cropCoordinates;
    Color color;

    public OrientationRequest(String orientation, Coordinates cropCoordinates,Color color) {
        this.orientation = orientation;
        this.cropCoordinates = cropCoordinates;
        this.color = color;
    }

    public String getOrientation() {
        return orientation;
    }

    public Coordinates getCropCoordinates() {
        return cropCoordinates;
    }

    public Color getColor() {
        return color;
    }
}
