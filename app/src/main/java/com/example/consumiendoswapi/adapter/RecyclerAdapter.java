package com.example.consumiendoswapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumiendoswapi.R;
import com.example.consumiendoswapi.fragmentPlanet;
import com.example.consumiendoswapi.models.Planet;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlanetViewHolder> {

    private OnPlanetClickListener onPlanetClickListener;
    private List<Planet> planetList;


    public RecyclerAdapter(fragmentPlanet fragmentPlanet, List<Planet> planetList) {
        this.planetList = planetList;
    }

//    public RecyclerAdapter(Context context, List<Planet> planets) {
//        this.planetList = planetList;
//    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planet = planetList.get(position);
        holder.bind(planet);
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView climateTextView;
        private TextView terrainTextView;
        private TextView populationTextView;

        PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            climateTextView = itemView.findViewById(R.id.climateTextView);
            terrainTextView = itemView.findViewById(R.id.terrainTextView);
            populationTextView = itemView.findViewById(R.id.populationTextView);
        }

        void bind(Planet planet) {
            nameTextView.setText("Name: " + planet.getName());
            climateTextView.setText("Climate: " + planet.getClimate());
            terrainTextView.setText("Terrain: " + planet.getTerrain());
            populationTextView.setText("Population: " + planet.getPopulation());
            String dosCaracteres = planet.getUrl().substring(planet.getUrl().length() - 2);
        }
    }
    public interface OnPlanetClickListener {
        void onPlanetClick(int planetId);
    }
}
