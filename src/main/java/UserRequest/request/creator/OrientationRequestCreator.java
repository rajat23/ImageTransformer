package UserRequest.request.creator;

import UserRequest.requests.OrientationRequest;
import helper.ColorFactory;
import helper.Coordinates;

import java.awt.*;
import java.util.Map;

public class OrientationRequestCreator {
    Map <String, String[]> parameterMap;

    public OrientationRequestCreator(Map<String, String[]> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public OrientationRequest create(){
        String orientation = "";
        Coordinates cropCoordinates = new Coordinates(0,0);
        Color color = Color.white;

        if (parameterMap.containsKey("orientation"))
            orientation = ((String[]) parameterMap.get("orientation"))[0];

        int x = 0, y = 0;
        if (parameterMap.containsKey("x"))
            x = Integer.parseInt(((String[]) parameterMap.get("x"))[0]);
        if (parameterMap.containsKey("y"))
            y = Integer.parseInt(((String[]) parameterMap.get("y"))[0]);

        cropCoordinates = new Coordinates(x, y);

        if (parameterMap.containsKey("color"))
            color = ColorFactory.createColor(((String[]) parameterMap.get("color"))[0]);

        return new OrientationRequest(orientation,cropCoordinates,color);
    }
}
