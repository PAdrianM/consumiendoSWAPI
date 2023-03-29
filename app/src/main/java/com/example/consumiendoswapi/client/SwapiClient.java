package com.example.consumiendoswapi.client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwapiClient {

    private static Retrofit retrofit;
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
