package helper;

import java.util.HashMap;
import java.util.Map;

public class RequestMapCreator {
    public Map<String, String[]> createMap(String []parameters) {
        Map<String, String[]> map = new HashMap<String, String[]>();
        for (String parameter : parameters) {
            String [] pair=parameter.split("=");
            map.put(pair[0],new String[]{pair[1]});
        }
        return map;
    }
}
