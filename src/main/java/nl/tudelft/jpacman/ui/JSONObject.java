package nl.tudelft.jpacman.ui;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {
    private final Map<String, Object> jsonMap;

    public JSONObject() {
        jsonMap = new HashMap<>();
    }

    public void put(String key, Object value) {
        jsonMap.put(key, value);
    }

    public Object get(String key) {
        return jsonMap.get(key);
    }

    public String toJSONString() {
        StringBuilder jsonString = new StringBuilder("{");
        for (String key : jsonMap.keySet()) {
            Object value = jsonMap.get(key);
            jsonString.append("\"").append(key).append("\":");
            if (value instanceof String) {
                jsonString.append("\"").append(value).append("\"");
            } else {
                jsonString.append(value);
            }
            jsonString.append(",");
        }
        if (jsonMap.size() > 0) {
            jsonString.deleteCharAt(jsonString.length() - 1);
        }
        jsonString.append("}");
        return jsonString.toString();
    }
}

