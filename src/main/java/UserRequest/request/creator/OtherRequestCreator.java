package UserRequest.request.creator;

import UserRequest.requests.OtherRequests;
import helper.FileUrl;

import java.util.Map;

public class OtherRequestCreator {
    Map<String, String[]> parameterMap;
    private static final int DEFUALT_REDIUS =0;
    private static final float DEFAULT_QUALITY= -1.0f;
    private static final String DEFAULT_VALUE= "";

    private String effect,angle,format;
    private int radius;
    private float quality;


    public OtherRequestCreator(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public OtherRequests create() {

        effect=getEffect();
        angle=getAngle();
        format=getFormat();
        radius=getRadius();
        quality=getQuality();


        return new OtherRequests(radius, effect, angle, format, quality);


    }


    public String getEffect() {
        if (parameterMap.containsKey("effect")) {
            return parameterMap.get("effect")[0];
        }
        return DEFAULT_VALUE;
    }

    public String getAngle() {
        if (parameterMap.containsKey("angle")) {
            return parameterMap.get("angle")[0];
        }
        return DEFAULT_VALUE;
    }

    public int getRadius() {
        if (parameterMap.containsKey("radius")) {
            return Integer.parseInt(parameterMap.get("radius")[0]);
        }
        return DEFUALT_REDIUS;

    }

    public String getFormat() {

        if (parameterMap.containsKey("format")) {
            return parameterMap.get("format")[0];
        } else {
            return new FileUrl().getFileExtension(parameterMap.get("path")[0]);

        }
    }

    public float getQuality() {
        if (parameterMap.containsKey("quality"))
            return Float.parseFloat(parameterMap.get("quality")[0]);
        return DEFAULT_QUALITY;



    }
}
