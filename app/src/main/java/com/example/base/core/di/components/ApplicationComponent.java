package com.example.base.core.di.components;

import com.example.base.core.di.modules.UtilModule;
import com.example.base.core.di.scopes.ApplicationScope;
import com.example.base.core.di.modules.NetworkingServicesModule;
import com.example.base.environment.modules.session.splash_screen.SplashScreen;

import dagger.Component;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 16/5/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

@ApplicationScope
@Component(modules = {NetworkingServicesModule.class, UtilModule.class})
public interface ApplicationComponent {

    void inject(SplashScreen splashScreen);
}
