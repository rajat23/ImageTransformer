package UserRequest.request.creator;

import UserRequest.reader.MapReader;
import helper.RequestMapCreator;

import java.util.Map;

public class CreatorTestData {
    protected MapReader reader;
    protected MapReader defaultValuesReader;

    public CreatorTestData() {
        initializeReader();
    }

    public void initializeReader(){
        String  [] requestString  = {"path=abc.jpg","angle=50","width=100","height=100","x=9","y=66",
                                    "radius=10","color=yellow","format=png","quality=1.0","orientation=top",
                                    "mode=fill","effect=sepia"};
        Map<String, String[]> parameterMap = new RequestMapCreator().createMap(requestString);
        reader = new MapReader(parameterMap);

        String  [] nullRequestString = {"path=abc.jpg"};
        parameterMap = new RequestMapCreator().createMap(nullRequestString);
        defaultValuesReader = new MapReader(parameterMap);

    }
}
