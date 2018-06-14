package com.example.base.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.base.core.Core;
import com.example.base.core.util.Cons;

import java.util.Objects;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 2/4/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

public class Utils {

    private SharedPreferences mSharedPreferences;

    public Utils(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void toast(String message) {
        toast(message, false);
    }

    public void toast(String message, boolean isLong) {
        Toast.makeText(Core.instance().getContext(), message, isLong ?
                Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
    }

    public void intent(Activity mCurrentAct, Class nextActivity, boolean closeCurrent) {
        Intent i = new Intent(mCurrentAct, nextActivity);
        mCurrentAct.startActivity(i);
        if (closeCurrent) {
            mCurrentAct.finish();
        }
    }

    public RecyclerView configureVerticalRecycler(RecyclerView mRecycler, RecyclerView.Adapter mAdapter) {
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mRecycler.getContext());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);
        return mRecycler;
    }

    public void setPreference(String key, Object value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if(value instanceof Integer){
            editor.putInt(key, (Integer) value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean) value);
        }else if(value instanceof Float){
            editor.putFloat(key, (Float) value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long) value);
        }else if(value instanceof String){
            editor.putString(key, (String) value);
        }
        editor.apply();
        Core.instance().log("setPreference | " + key + " -> " + value);
    }

    public String getStringPreference(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public Integer getIntegerPreference(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public Boolean getBooleanPreference(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public Float getFloatPreference(String key) {
        return mSharedPreferences.getFloat(key, 0);
    }

    public Long getLongPreference(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    public void clearPreferences() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
        Core.instance().log("Preferences cleared.");
    }

}