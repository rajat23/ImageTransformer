package UserRequest.request.creator;


import UserRequest.requests.InputImage;
import UserRequest.requests.ScalingRequest;

import java.util.Map;

public class ScalingRequestCreator {

    private Map<String, String[]> parameterMap;
    private InputImage inputImage;
    private static final int MIN_HEIGHT = 0;
    private static final int MIN_WIDTH = 0;

    public ScalingRequestCreator(Map<String, String[]> parameterMap, InputImage inputImage) {
        this.parameterMap = parameterMap;
        this.inputImage = inputImage;
    }

    public ScalingRequest create() {

        int responseWidth = MIN_WIDTH, responseHeight = MIN_HEIGHT;
        String mpde = "";

        if (parameterMap.containsKey("width"))
            responseWidth = getWidth(parameterMap.get("width")[0]);
        if (parameterMap.containsKey("height"))
            responseHeight = getHeight(parameterMap.get("height")[0]);

        if (responseHeight == MIN_HEIGHT)
            responseHeight = getProportionalHeight(responseWidth);
        if (responseWidth == MIN_WIDTH)
            responseWidth = getProportionalWidth(responseHeight);

        return new ScalingRequest(responseWidth, responseHeight, mpde);

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
