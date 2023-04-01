package com.example.consumiendoswapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumiendoswapi.FragmentPlanetDirections;
import com.example.consumiendoswapi.R;
import com.example.consumiendoswapi.models.Planet;
import com.example.consumiendoswapi.models.Vehicle;
import java.util.List;
public class RecyclerVehicle extends RecyclerView.Adapter<RecyclerVehicle.VehicleViewHolder> {

    private List<Vehicle> vehicleList;

    public RecyclerVehicle(Context FragmenetVehicle, List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @NonNull
    @Override
    public RecyclerVehicle.VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vehicles, parent, false);
        return new RecyclerVehicle.VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        Vehicle vehicle = vehicleList.get(position);
        holder.bind(vehicle);
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView modelVehicle;
        private TextView manufacturerVehicle;
        private TextView costVehicle;
        private TextView clasVehicle;
        private TextView capacityVehicle;
        private CardView mCardView;

        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameVehicle);
            modelVehicle = itemView.findViewById(R.id.modelVehicle);
            manufacturerVehicle = itemView.findViewById(R.id.manufacturerVehicle);
            costVehicle = itemView.findViewById(R.id.cost_in_creditsVehicle);
            clasVehicle = itemView.findViewById(R.id.vehicle_classVehicle);
            capacityVehicle = itemView.findViewById(R.id.cargo_capacityVehicle);
        }

        void bind(Vehicle vehicle) {
            nameTextView.setText("Name: " + vehicle.getName());
            modelVehicle.setText("Model: " + vehicle.getModel());
            manufacturerVehicle.setText("Manufacturer: " + vehicle.getManufacturer());
            costVehicle.setText("Cost: " + vehicle.getCost_in_credits());
            clasVehicle.setText("Clas: " + vehicle.getVehicle_class());
            capacityVehicle.setText("Capacity: " + vehicle.getCargo_capacity());
        }
    }
}
