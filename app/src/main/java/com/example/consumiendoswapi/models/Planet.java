package com.example.consumiendoswapi.models;

import com.google.gson.annotations.SerializedName;

public class Planet {

    @SerializedName("name")
    private String name;

    @SerializedName("climate")
    private String climate;

    @SerializedName("terrain")
    private String terrain;

    @SerializedName("population")
    private String population;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getPopulation() {
        return population;
    }

    public String getUrl() {
        return url;
    }
}
