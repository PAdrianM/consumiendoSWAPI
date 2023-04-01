package com.example.consumiendoswapi.models;

import com.google.gson.annotations.SerializedName;

public class Vehicle {

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("cost_in_credits")
    private String cost_in_credits;

    @SerializedName("vehicle_class")
    private String vehicle_class;

    @SerializedName("cargo_capacity")
    private String cargo_capacity;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }
}
