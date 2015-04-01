package UserRequest.request.creator;


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

        if (responseHeight == 0)
            responseHeight = getProportionalHeight(responseWidth);
        if (responseWidth == 0)
            responseWidth = getProportionalWidth(responseHeight);

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


    public int getProportionalHeight(int width) {
        return (int) (width / inputImage.getAspectRatio());

    }

    public int getProportionalWidth(int height) {
        return (int) (height * inputImage.getAspectRatio());
    }
}
