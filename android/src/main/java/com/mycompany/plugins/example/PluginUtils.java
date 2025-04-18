package com.mycompany.plugins.example;

import com.getcapacitor.JSObject;
import java.util.HashMap;
import java.util.Map;

public class PluginUtils {

  public static JSObject toJSObject(HashMap<String, Object> map) {
    JSObject jsObject = new JSObject();

    for (Map.Entry<String, Object> entry : map.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();

      if (value instanceof String) {
        jsObject.put(key, (String) value);
      } else if (value instanceof Integer) {
        jsObject.put(key, (Integer) value);
      } else if (value instanceof Double) {
        jsObject.put(key, (Double) value);
      } else if (value instanceof Boolean) {
        jsObject.put(key, (Boolean) value);
      } else if (value instanceof Float) {
        jsObject.put(key, ((Float) value).doubleValue());
      } else if (value instanceof Long) {
        jsObject.put(key, ((Long) value).doubleValue());
      } else {
        jsObject.put(key, value != null ? value.toString() : null);
      }
    }

    return jsObject;
  }
}


