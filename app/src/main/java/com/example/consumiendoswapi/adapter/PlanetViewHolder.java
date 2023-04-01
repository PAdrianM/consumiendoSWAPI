//package com.example.consumiendoswapi.adapter;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.consumiendoswapi.R;
//import com.example.consumiendoswapi.models.Planet;
//
//public class PlanetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//    private TextView planetNameTextView;
//    private TextView planetClimate;
//    private TextView planetTerrain;
//    private TextView planetPopulation;
//    private PlanetClickListener planetClickListener;
//
//    public PlanetViewHolder(@NonNull View itemView, PlanetClickListener planetClickListener) {
//        super(itemView);
//
//        planetNameTextView = itemView.findViewById(R.id.planet_name);
//        planetClimate = itemView.findViewById(R.id.planet_climate);
//        planetTerrain = itemView.findViewById(R.id.planet_terrain);
//        planetPopulation = itemView.findViewById(R.id.planet_population);
//        this.planetClickListener = planetClickListener;
//
//        itemView.setOnClickListener(this);
//    }
//
//    public void bind(Planet planet) {
//        planetNameTextView.setText(planet.getName());
//        planetClimate.setText(planet.getClimate());
//        planetTerrain.setText(planet.getTerrain());
//        planetPopulation.setText(planet.getPopulation());
//    }
//
//    @Override
//    public void onClick(View view) {
//        planetClickListener.onPlanetClick(getAdapterPosition());
//    }
//
//}
