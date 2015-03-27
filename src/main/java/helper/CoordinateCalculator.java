package helper;

public class CoordinateCalculator {


    public Coordinates getCoordinates(int imageWidth, int imageHeight, int responseWidth, int responseHeight, String orientation) {
        if (orientation.equals("top_left"))
            return new Coordinates(0, 0);
        if (orientation.equals("top_right"))
            return new Coordinates(imageWidth - responseWidth, 0);
        if (orientation.equals("bottom_left"))
            return new Coordinates(0, imageHeight - responseHeight);
        if (orientation.equals("bottom_right"))
            return new Coordinates(imageWidth - responseWidth, imageHeight - responseHeight);
        if (orientation.equals("top"))
            return new Coordinates((imageWidth - responseWidth) / 2, 0);
        if (orientation.equals("left"))
            return new Coordinates(0, (imageHeight - responseHeight) / 2);
        if (orientation.equals("bottom"))
            return new Coordinates((imageWidth - responseWidth) / 2, imageHeight - responseHeight);
        if (orientation.equals("right"))
            return new Coordinates((imageWidth - responseWidth), (imageHeight - responseHeight) / 2);
        return new Coordinates((imageWidth / 2 - responseWidth / 2), (imageHeight / 2 - responseHeight / 2));
    }
}
