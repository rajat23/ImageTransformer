package UserRequest.reader;

import helper.ColorFactory;
import helper.FileUrl;

import java.awt.*;
import java.util.Map;

public class MapReader extends DefaultParameterMap {

    private Map<String, String[]> parameterMap;

    public MapReader(Map<String, String[]> parameterMap) {
        super();
        this.parameterMap = parameterMap;
    }

    public String readString(String parameter) {
        if (parameterMap.containsKey(parameter))
            return parameterMap.get(parameter)[0];

        return defaultParameterMap.get(parameter);
    }

    public int readInteger(String parameter) {
        if (parameterMap.containsKey(parameter))
            return Integer.parseInt(parameterMap.get(parameter)[0]);

        return Integer.parseInt(defaultParameterMap.get(parameter));
    }

    public float readFloat(String parameter) {
        if (parameterMap.containsKey(parameter))
            return Float.parseFloat(parameterMap.get(parameter)[0]);

        return Float.parseFloat(defaultParameterMap.get(parameter));
    }

    public Color readColor() {
        if (parameterMap.containsKey("color"))
            return ColorFactory.createColor(parameterMap.get("color")[0]);

        return ColorFactory.createColor(defaultParameterMap.get("color"));
    }

    public String readFormat() {

        if (parameterMap.containsKey("format")) {
            return parameterMap.get("format")[0];
        }
        return new FileUrl().getFileExtension(parameterMap.get("path")[0]);
    }
}
