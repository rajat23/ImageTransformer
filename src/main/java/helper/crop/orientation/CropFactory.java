package helper.crop.orientation;

public class CropFactory {
    public Cropable create(String orientation){
        if(orientation.equals("bottom"))
            return new Bottom();
        if(orientation.equals("bottom_left"))
            return new BottomLeft();
        if(orientation.equals("bottom_right"))
            return new BottomRight();
        if(orientation.equals("left"))
            return new Left();
        if(orientation.equals("right"))
            return new Right();
        if(orientation.equals("top"))
            return new Top();
        if(orientation.equals("top_left"))
            return new TopLeft();
        if(orientation.equals("top_right"))
            return new TopRight();
        return new Center();


    }
}
