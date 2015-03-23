package helper;

public class CoordinateCalculator {


    public Coordinates getCoordinates(int imageWidth, int imageHeight, int width, int height, String orientation) {
        if (orientation.equals("top_left"))
            return new Coordinates(0, 0);
        if (orientation.equals("top_right"))
            return new Coordinates(imageWidth - width, 0);
        if (orientation.equals("bottom_left"))
            return new Coordinates(0, imageHeight - height);
        if (orientation.equals("bottom_right"))
            return new Coordinates(imageWidth - width, imageHeight - height);
        if (orientation.equals("top"))
            return new Coordinates((imageWidth - width) / 2, 0);
        if (orientation.equals("left"))
            return new Coordinates(0, (imageHeight - height) / 2);
        if (orientation.equals("bottom"))
            return new Coordinates((imageWidth - width) / 2, imageHeight - height);
        if (orientation.equals("right"))
            return new Coordinates((imageWidth - width), (imageHeight - height) / 2);
        return new Coordinates((imageWidth / 2 - width / 2), (imageHeight / 2 - height / 2));
    }
}
