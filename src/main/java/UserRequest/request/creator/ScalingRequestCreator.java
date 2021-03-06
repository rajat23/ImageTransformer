package UserRequest.request.creator;


import UserRequest.reader.DefaultParameterValues;
import UserRequest.reader.MapReader;
import UserRequest.requests.InputImage;
import UserRequest.requests.ScalingRequest;

public class ScalingRequestCreator {

    private MapReader mapReader;
    private InputImage inputImage;


    public ScalingRequestCreator(MapReader mapReader, InputImage inputImage) {
        this.mapReader=mapReader;
        this.inputImage = inputImage;
    }

    public ScalingRequest create() {

        String mode = mapReader.readString("mode");
        int responseWidth = getWidth(mapReader.readString("width"));
        int responseHeight = getHeight(mapReader.readString("height"));

        if (responseHeight ==DefaultParameterValues.DEFAULT_HEIGHT)
            responseHeight = inputImage.getProportionalHeight(responseWidth);
        if (responseWidth == DefaultParameterValues.DEFAULT_WIDTH)
            responseWidth = inputImage.getProportionalWidth(responseHeight);

        return new ScalingRequest(responseWidth,responseHeight,mode);

    }

    public int getHeight(String height) {
        if (height.contains(".")) {
            Double percentage = Double.parseDouble(height);
            return (int) (percentage * (double) inputImage.getHeight());
        }
        return Integer.parseInt(height);
    }

    public int getWidth(String width) {
        if (width.contains(".")) {
            Double percentage = Double.parseDouble(width);
            return (int) (percentage * (double) inputImage.getWidth());
        }
        return Integer.parseInt(width);
    }



}
