package UserRequest;

import java.awt.*;

public class ScalingRequest {

    private String mode;
    private int responseWidth;
    private int responseHeight;

    public ScalingRequest(int responseWidth, int responseHeight, String mode){

        this.mode = mode;
        this.responseWidth = responseWidth;
        this.responseHeight = responseHeight;
    }

    public int getResponseWidth() {
        return responseWidth;
    }

    public int getResponseHeight() {
        return responseHeight;
    }

    public String getMode() {
        return mode;
    }
    public Dimension getDimension(){
        return new Dimension(responseWidth,responseHeight);
    }
}
