package helper.crop.orientation;

import helper.Coordinates;

public class Center implements Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight) {
        return new Coordinates((imageWidth / 2 - responseWidth / 2), (imageHeight / 2 - responseHeight / 2));
    }
}
