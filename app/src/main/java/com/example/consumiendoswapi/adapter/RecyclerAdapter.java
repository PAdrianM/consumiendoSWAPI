package com.example.consumiendoswapi.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.consumiendoswapi.FragmentPlanet;
import com.example.consumiendoswapi.FragmentPlanetDirections;
import com.example.consumiendoswapi.R;
import com.example.consumiendoswapi.VistaPlaneta;
import com.example.consumiendoswapi.models.Planet;
import com.example.consumiendoswapi.models.Vehicle;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlanetViewHolder> {

    private List<Planet> planetList;
    private NavController navController;


    public RecyclerAdapter(Context fragmentPlanet, List<Planet> planetList, NavController navController) {
        this.planetList = planetList;
        this.navController = navController;
    }

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

   public class PlanetViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView climateTextView;
        private TextView terrainTextView;
        private TextView populationTextView;
        private CardView mCardView;
        PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            climateTextView = itemView.findViewById(R.id.climateTextView);
            terrainTextView = itemView.findViewById(R.id.terrainTextView);
            populationTextView = itemView.findViewById(R.id.populationTextView);
            mCardView = itemView.findViewById(R.id.cardViewPlanet);
        }

        void bind(Planet planet) {
            nameTextView.setText("Name: " + planet.getName());
            climateTextView.setText("Climate: " + planet.getClimate());
            terrainTextView.setText("Terrain: " + planet.getTerrain());
            populationTextView.setText("Population: " + planet.getPopulation());
            //Obtengo los 2 ultimos digitos osea el numero y la barra invertida 1/
            String dosCaracteres = planet.getUrl().substring(planet.getUrl().length() - 2);
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Crear un onClick de mi CardView
                    //Llamo al fragment planet Directions que es donde van a estar todas las acciones de mi nav_graph
                    //Obtengo mi accion en la linea 86
                    //Linea 87 seteo mi argumento
                    //en mi linea 88 con el navController.navigate mando la accion y esta lleva el argumento y hacia donde va
                    com.example.consumiendoswapi.FragmentPlanetDirections.ActionFragmentPlanetToVistaPlaneta actionFragmentPlanetToVistaPlaneta = FragmentPlanetDirections.actionFragmentPlanetToVistaPlaneta();
                    actionFragmentPlanetToVistaPlaneta.setIdPlaneta(dosCaracteres);
                    navController.navigate(actionFragmentPlanetToVistaPlaneta);
                    //Tengo mi accion que lleva mi IdPlaneta y me dirige a la VistaPlaneta
                }
            });
        }
    }
}


