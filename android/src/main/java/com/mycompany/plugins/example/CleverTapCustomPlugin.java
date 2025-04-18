package com.mycompany.plugins.example;

import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.clevertap.android.sdk.CleverTapAPI;
import org.json.JSONException;
import java.util.HashMap;
import java.util.Iterator;

@CapacitorPlugin(name = "CleverTapCustom")
public class CleverTapCustomPlugin extends Plugin implements CTPushNotificationListener {

    private CleverTapCustom implementation = new CleverTapCustom();
    private CleverTapAPI cleverTapAPI;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }



  @Override
  public void load() {
    super.load();
    Log.d("CleverTapCustomPlugin", "CleverTapCustomPlugin loaded");
    CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.VERBOSE);
    cleverTapAPI = CleverTapAPI.getDefaultInstance(getContext().getApplicationContext());
    if (cleverTapAPI != null) {
      cleverTapAPI.setCTPushNotificationListener(this);
      Log.d("CleverTapCustomPlugin", "CT push notification listener set");
    }else{
      Log.d("CleverTapCustomPlugin", "CT push notification listener not set");
    }
  }

  @RequiresApi(api = Build.VERSION_CODES.N)
  @PluginMethod()
  public void createNotificationChannel(PluginCall call){
    Log.d("CleverTapCustomPlugin", "createNotificationChannel called");
    if (cleverTapAPI != null) {
      Log.d("CleverTapCustomPlugin", "Creating notification channel: general");
      CleverTapAPI.createNotificationChannel(getContext().getApplicationContext(), "general", "general", "General channel", NotificationManager.IMPORTANCE_HIGH, true);
      call.resolve();
    }else {
      Log.d("CleverTapCustomPlugin", "CT push notification channel not set");
      call.reject("CT instance null");
    }
  }

  @PluginMethod()
  public void pushEvent(PluginCall call) {
    try{
      String eventName = call.getString("eventName");
      JSObject eventProps = call.getObject("eventProps");

      if (eventName == null || eventProps == null) {
        call.reject("Missing eventName or eventProps");
        return;
      }

      HashMap<String, Object> props = new HashMap<>();
      Iterator<String> keys = eventProps.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        Object value = eventProps.get(key);
        props.put(key, value);
      }
      cleverTapAPI.pushEvent(eventName, props);
      call.resolve();
    }catch (JSONException e){
      Log.d("CleverTapCustomPlugin", "pushEvent JSONException: " + e.getMessage());
      call.reject(e.getMessage());
    }
  }

  @PluginMethod()
  public void onUserLogin(PluginCall call) {
    try {
      JSObject userProps = call.getObject("userProps");
      if (userProps == null) {
        call.reject("Missing userProps");
        return;
      }

      HashMap<String, Object> profileData = new HashMap<>();
      Iterator<String> keys = userProps.keys();
      while (keys.hasNext()) {
        String key = keys.next();
        Object value = userProps.get(key);
        profileData.put(key, value);
      }
      cleverTapAPI.onUserLogin(profileData);
      call.resolve();
    }catch (JSONException e){
      Log.d("CleverTapCustomPlugin", "onUserLogin JSONException: " + e.getMessage());
      call.reject(e.getMessage());
    }

  }

  @Override
  public void onNotificationClickedPayloadReceived(HashMap<String, Object> hashMap) {
    Log.d("CleverTapCustomPlugin", "onNotificationClickedPayloadReceived called");
    JSObject data = PluginUtils.toJSObject(hashMap);
    notifyListeners("onPushClicked", data);
  }

}
