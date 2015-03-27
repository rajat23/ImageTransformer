package UserRequest.request.creator;


import UserRequest.InputImage;
import UserRequest.ScalingRequest;

import java.util.Map;

public class ScalingRequestCreator {

    private Map<String, String[]> parameterMap;
    private InputImage inputImage;

    public ScalingRequestCreator(Map<String, String[]> parameterMap, InputImage inputImage) {
        this.parameterMap = parameterMap;
        this.inputImage = inputImage;
    }

    public ScalingRequest create(){

        int responseWidth=0,responseHeight=0;
        String mpde = "";

        if (parameterMap.containsKey("width"))
            responseWidth = getWidth(((String[]) parameterMap.get("width"))[0]);
        if (parameterMap.containsKey("height"))
            responseHeight = getHeight(((String[]) parameterMap.get("height"))[0]);

        if (responseHeight == 0)
            responseHeight = getProportionalHeight(responseWidth);
        if (responseWidth == 0)
            responseWidth = getProportionalWidth(responseHeight);

        return new ScalingRequest(responseWidth,responseHeight,mpde);

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
