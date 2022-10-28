package com.shakawat.jsonplaceholderapitestusingmvvm.Services.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static String BaseUrl="https://jsonplaceholder.typicode.com";
    private static Retrofit retrofit;

    public static RetrofitServices services;

    public static RetrofitServices getServices(){
        if (services==null){
            if (retrofit==null){
                Gson gson= new GsonBuilder()
                        .setLenient()
                        .create();

                OkHttpClient okHttpClient= new OkHttpClient.Builder()
                        .connectTimeout(7000, TimeUnit.SECONDS)
                        .readTimeout(7000,TimeUnit.SECONDS)
                        .build();
                retrofit= new Retrofit.Builder()
                        .baseUrl(BaseUrl)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
            services=retrofit.create(RetrofitServices.class);
            return services;
        }
        return services;
    }
}
