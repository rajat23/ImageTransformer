package helper.crop.coordinates;

import helper.Coordinates;

public class TopLeft implements Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight) {
        return new Coordinates(0, 0);
    }
}
