package com.example.base.core.di.modules;

import com.example.base.core.api.posts.APIPostsInterface;
import com.example.base.core.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 16/5/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

@Module(includes = {NetworkingModule.class})
public class NetworkingServicesModule {

    @Provides
    @ApplicationScope
    public APIPostsInterface provideAPIPostsInterface(Retrofit retrofit){
        return retrofit.create(APIPostsInterface.class);
    }

}