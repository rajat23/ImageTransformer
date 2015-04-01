package UserRequest.request.creator;

import UserRequest.reader.MapReader;
import UserRequest.requests.OrientationRequest;
import helper.Coordinates;

import java.awt.*;

public class OrientationRequestCreator {

    private MapReader mapReader;

    public OrientationRequestCreator(MapReader mapReader) {
        this.mapReader = mapReader;
    }

    public OrientationRequest create() {

        String orientation=mapReader.readString("orientation");
        Coordinates cropCoordinates = new Coordinates(mapReader.readInteger("x"),mapReader.readInteger("y"));
        Color color = mapReader.readColor();

        return new OrientationRequest(orientation, cropCoordinates, color);
    }

}
