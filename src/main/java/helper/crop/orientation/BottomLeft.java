package helper.crop.orientation;

import helper.Coordinates;

public class BottomLeft implements Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight) {
        return new Coordinates(0, imageHeight - responseHeight);
    }
}
