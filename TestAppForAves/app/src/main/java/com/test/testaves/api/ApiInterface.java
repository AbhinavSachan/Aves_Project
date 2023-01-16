package com.test.testaves.api;

import static com.test.testaves.api.ApiUtil.API_KEY;

import com.test.testaves.datamodels.ImageDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    @Headers("Authorization: Client-ID "+API_KEY)
    @GET("photos")
    Call<List<ImageDataModel>> getImages(
            @Query("page") int page,@Query("per_page") int per_page
    );
}
