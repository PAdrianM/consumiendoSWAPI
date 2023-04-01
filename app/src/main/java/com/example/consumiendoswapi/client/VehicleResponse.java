package com.example.consumiendoswapi.client;

import com.example.consumiendoswapi.models.Planet;
import com.example.consumiendoswapi.models.Vehicle;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<Vehicle> results;



    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Vehicle> getResults() {
        return results;
    }
}
