package com.example.base.core.di.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.base.core.Core;
import com.example.base.core.di.scopes.ApplicationScope;
import com.example.base.core.util.Cons;
import com.example.base.core.util.Utils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 21/5/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

@Module
public class UtilModule {

    @Provides
    @ApplicationScope
    public SharedPreferences provideSharedPreferences() {
        return Core.instance().getContext()
                .getSharedPreferences(Cons.APP_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @ApplicationScope
    public Utils provideUtils(SharedPreferences sharedPreferences) {
        return new Utils(sharedPreferences);
    }
}
