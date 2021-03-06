package helper.crop.orientation;

import helper.Coordinates;

public class Bottom implements Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight) {
        return new Coordinates((imageWidth - responseWidth) / 2, imageHeight - responseHeight);
    }
}
