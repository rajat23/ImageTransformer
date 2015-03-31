package helper.crop.coordinates;


import helper.Coordinates;

public class TopRight implements Cropable {
    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight) {
        return new Coordinates(imageWidth - responseWidth, 0);
    }
}
