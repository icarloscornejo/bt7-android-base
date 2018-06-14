package com.example.base.environment.util;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 15/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A custom class for quick building JSON's.
 */
public class JSONBuilder {

    private JSONObject mJson;
    private String[] mKeys;

    public JSONBuilder() {
        mJson = new JSONObject();
    }

    public JSONBuilder(JSONObject mJSON) {
        this.mJson = mJSON;
    }

    public void add(String key, Object value) {
        try {
            mJson.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public JSONBuilder keys(String... keys){
        this.mKeys = keys;
        return this;
    }

    public JSONObject values(Object... values){
        for(int i = 0; i < mKeys.length; i++){
            add(mKeys[i], values[i]);
        }

        return mJson;
    }

    public JSONObject getJSON() {
        return mJson;
    }

    public JSONObject toJsonValues(String json) {
        try {
            mJson = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mJson;
    }
}