package helper.crop.coordinates;

import helper.Coordinates;

public class Right implements Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight) {
        return new Coordinates((imageWidth - responseWidth), (imageHeight - responseHeight) / 2);
    }
}
