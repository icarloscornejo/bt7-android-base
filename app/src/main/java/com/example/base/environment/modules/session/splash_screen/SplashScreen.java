package com.example.base.environment.modules.session.splash_screen;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.base.R;
import com.example.base.core.Core;
import com.example.base.core.api.posts.APIPostsInterface;
import com.example.base.core.api.posts.PostModel;
import com.example.base.core.util.Utils;
import com.example.base.core.util.ViewDefaults;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("Registered")


public class SplashScreen extends AppCompatActivity implements ViewDefaults {

    @Inject
    APIPostsInterface mAPIPosts;
    @Inject
    Utils mUtils;

    @BindView(R.id.txtHello)
    TextView mTxtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        bindObjects();
    }

    @Override
    public void bindObjects() {
        ButterKnife.bind(this);
        Core.instance().di().inject(this);

        setProperties();
    }

    @Override
    public void setProperties() {
        mAPIPosts.getPosts("1").enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                //Process your response
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                //Filter throwable
            }
        });
    }
}