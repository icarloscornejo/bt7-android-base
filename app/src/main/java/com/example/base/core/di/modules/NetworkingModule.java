package com.example.base.core.di.modules;

import com.example.base.core.di.scopes.ApplicationScope;
import com.example.base.core.util.Cons;

import java.io.IOException;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 16/5/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

@Module
public class NetworkingModule {

    @Provides
    @ApplicationScope
    @Named("logging_interceptor")
    public Interceptor provideLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @ApplicationScope
    @Named("error_interceptor")
    public Interceptor provideErrorInterceptor(){
        return chain -> {
            Request request = chain.request();
            Response response = chain.proceed(request);

            if (response.code() > 399) {
                throw new IOException("Server error code: " + response.code());
            }

            return response;
        };
    }

    @Provides
    @ApplicationScope
    public OkHttpClient provideOkHttpClient(@Named("logging_interceptor") Interceptor loggingInterceptor,
                                            @Named("error_interceptor") Interceptor errorInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(errorInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Cons.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }
}
