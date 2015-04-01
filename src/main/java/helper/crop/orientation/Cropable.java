package helper.crop.orientation;

import helper.Coordinates;

public  interface  Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight);
}
