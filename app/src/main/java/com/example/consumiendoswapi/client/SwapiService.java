package com.example.consumiendoswapi.client;

import com.example.consumiendoswapi.models.Planet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SwapiService {

    @GET("planets/")
    Call<PlanetResponse> getPlanets();

    @GET("planets/{id}")
    Call<Planet> getPlanet(@Path("id") String planetId);

    @GET("vehicles/")
    Call<VehicleResponse> getVehicles();
}
