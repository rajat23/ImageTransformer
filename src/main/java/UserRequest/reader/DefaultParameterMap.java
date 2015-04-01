package UserRequest.reader;


import java.util.HashMap;
import java.util.Map;

public class DefaultParameterMap implements DefaultParameterValues {

    protected Map<String, String> defaultParameterMap;

    public DefaultParameterMap() {
        defaultParameterMap = new HashMap<String, String>();

        defaultParameterMap.put("x",""+DEFAULT_X_Value);
        defaultParameterMap.put("y",""+DEFAULT_Y_Value);
        defaultParameterMap.put("orientation",DEFAULT_ORIENTATION);
        defaultParameterMap.put("radius",""+ DEFAULT_RADIUS);
        defaultParameterMap.put("quality",""+DEFAULT_QUALITY);
        defaultParameterMap.put("effect",DEFAULT_EFFECT);
        defaultParameterMap.put("angle",""+ DEFAULT_ANGLE);
        defaultParameterMap.put("width",""+ DEFAULT_WIDTH);
        defaultParameterMap.put("height",""+ DEFAULT_HEIGHT);
        defaultParameterMap.put("mode",DEFAULT_MODE);
        defaultParameterMap.put("color",DEFAULT_COLOR);
    }
}
