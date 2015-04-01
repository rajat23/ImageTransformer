package UserRequest.request.creator;

import UserRequest.reader.MapReader;
import UserRequest.requests.OtherRequests;

public class OtherRequestCreator {

    private MapReader mapReader;

    public OtherRequestCreator(MapReader mapReader) {
        this.mapReader = mapReader;
    }

    public OtherRequests create() {

        String effect=mapReader.readString("effect");
        String angle=mapReader.readString("angle");
        String format=mapReader.readFormat();
        int radius=mapReader.readInteger("radius");
        float quality=mapReader.readFloat("quality");

        return new OtherRequests(radius, effect, angle, format, quality);
    }

}
