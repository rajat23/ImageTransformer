package UserRequest.request.creator;

import UserRequest.requests.OrientationRequest;
import helper.ColorFactory;
import helper.Coordinates;

import java.awt.*;
import java.util.Map;

public class OrientationRequestCreator {
    Map<String, String[]> parameterMap;
    private static final int X_INIT = 0;
    private static final int Y_INIT = 0;
    private static final String DEFAULT_ORIENTATION = "";
    private String orientation;
    private Coordinates cropCoordinates;
    private Color color;

    public OrientationRequestCreator(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public OrientationRequest create() {

        orientation = getOreintation();
        cropCoordinates = getCoordinates();
        color = getColor();

        return new OrientationRequest(orientation, cropCoordinates, color);
    }

    private Coordinates getCoordinates() {
        int x = X_INIT, y = Y_INIT;
        if (parameterMap.containsKey("x"))
            x = Integer.parseInt(parameterMap.get("x")[0]);
        if (parameterMap.containsKey("y"))
            y = Integer.parseInt(parameterMap.get("y")[0]);
        return new Coordinates(x, y);

    }

    private String getOreintation() {
        if (parameterMap.containsKey("orientation"))
            return parameterMap.get("orientation")[0];
        return DEFAULT_ORIENTATION;

    }

    private Color getColor() {
        if (parameterMap.containsKey("color"))
            return ColorFactory.createColor(parameterMap.get("color")[0]);


        return Color.WHITE;
    }
}
