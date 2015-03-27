package UserRequest.request.creator;

import UserRequest.OtherRequests;
import helper.FileUrl;

import java.util.Map;

public class OtherRequestCreator {
    Map<String, String[]> parameterMap;

    public OtherRequestCreator(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public OtherRequests create(){

        String effect = "" ,angle ="" ,format = "";
        int radius =0;
        float quality = -1.0f;

        if (parameterMap.containsKey("effect"))
            effect = ((String[]) parameterMap.get("effect"))[0];

        if (parameterMap.containsKey("radius"))
            radius = Integer.parseInt(((String[]) parameterMap.get("radius"))[0]);

        if (parameterMap.containsKey("angle"))
            angle = ((String[]) parameterMap.get("angle"))[0];
        if (parameterMap.containsKey("format"))
            format = ((String[]) parameterMap.get("format"))[0];
        else {
            format = new FileUrl().getFileExtension(((String[]) parameterMap.get("path"))[0]);
        }
        if (parameterMap.containsKey("quality"))
            quality = Float.parseFloat(((String[]) parameterMap.get("quality"))[0]);

        return new OtherRequests(radius,effect,angle,format,quality);
    }
}
