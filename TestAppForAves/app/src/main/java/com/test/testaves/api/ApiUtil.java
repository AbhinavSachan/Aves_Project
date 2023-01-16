package com.test.testaves.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtil {
    public final static String BASE_URL = "https://api.unsplash.com/";
    public final static String API_KEY = "kwws5aeGo6V80ucpCPhq_urtumfIZ29-a7PZAFtA744";

    public static Retrofit retrofit = null;

    public static ApiInterface getInterface() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
