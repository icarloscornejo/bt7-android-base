package com.example.base.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import com.example.base.core.di.components.ApplicationComponent;
import com.example.base.core.di.components.DaggerApplicationComponent;
import com.example.base.core.util.Cons;
import com.example.base.core.util.ObjectCallback;
import com.example.base.core.util.EmptyCallback;
import com.example.base.core.util.Utils;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 15/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */
@SuppressLint("Registered")

public class Core extends Application {

    /** Core instance. */
    private static volatile Core sCoreInstance;
    /** Application Component instance. */
    private ApplicationComponent mApplicationComponent;
    /** Application listeners instance. */
    private AppListeners mAppListenersInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sCoreInstance = this;
        mAppListenersInstance = new AppListeners();
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }

    public static synchronized Core instance() {
        return sCoreInstance;
    }

    public Context getContext(){
        return getApplicationContext();
    }

    public AppListeners listeners(){
        return mAppListenersInstance;
    }

    public ApplicationComponent di() {
        return mApplicationComponent;
    }

    public void log(String msg){
        Log.i(Cons.APP_NAME, msg);
    }


    //#####################################################################
    //          Internal Listeners
    //#####################################################################

    public class AppListeners {

        private ObjectCallback<Fragment> onFragmentChange;
        private EmptyCallback onFragmentStackReset;
        private EmptyCallback onFragmentBackRequest;

        public void setOnFragmentChange(ObjectCallback<Fragment> onFragmentChange) {
            this.onFragmentChange = onFragmentChange;
        }

        public void setFragment(Fragment f){
            onFragmentChange.onResponse(f);
        }

        public void setOnFragmentStackReset(EmptyCallback onFragmentStackReset) {
            this.onFragmentStackReset = onFragmentStackReset;
        }

        public void resetFragmentStack(){
            onFragmentStackReset.onResponse();
        }

        public void setOnFragmentBackRequest(EmptyCallback onFragmentBackRequest) {
            this.onFragmentBackRequest = onFragmentBackRequest;
        }

        public void goBack(){
            onFragmentBackRequest.onResponse();
        }
    }
}
