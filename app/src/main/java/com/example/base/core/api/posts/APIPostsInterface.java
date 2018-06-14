package com.example.base.core.api.posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Carlos Cornejo (@icarloscornejo) on 15/1/2018.
 * https://www.linkedin.com/in/icarloscornejo
 */

public interface APIPostsInterface {

    @GET("posts/{page}")
    Call<PostModel> getPosts(@Path("page") String page);

}
