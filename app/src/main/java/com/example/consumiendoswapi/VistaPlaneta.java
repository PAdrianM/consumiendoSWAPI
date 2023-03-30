package com.example.consumiendoswapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consumiendoswapi.adapter.RecyclerAdapter;
import com.example.consumiendoswapi.client.PlanetResponse;
import com.example.consumiendoswapi.client.SwapiClient;
import com.example.consumiendoswapi.client.SwapiService;
import com.example.consumiendoswapi.models.Planet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VistaPlaneta extends Fragment {

    private TextView nameTextView;
    private TextView climateTextView;
    private TextView terrainTextView;
    private TextView populationTextView;
    VistaPlanetaArgs args;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VistaPlaneta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment vistaPlaneta.
     */
    // TODO: Rename and change types and number of parameters
    public static VistaPlaneta newInstance(String param1, String param2, int planetId) {
        VistaPlaneta fragment = new VistaPlaneta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vista_planeta, container, false);
        //usando argumentos
        args = VistaPlanetaArgs.fromBundle(getArguments());
        // Initialize TextViews
        nameTextView = view.findViewById(R.id.planet_name);
        climateTextView = view.findViewById(R.id.planet_climate);
        terrainTextView = view.findViewById(R.id.planet_terrain);
        populationTextView = view.findViewById(R.id.planet_population);
        String id = args.getIdPlaneta();
//      Consumo el servicio
        SwapiService swapiService = SwapiClient.getClient().create(SwapiService.class);
        Call<Planet> call = swapiService.getPlanet(id);
        call.enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(), "CONEXION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                    Planet planets = response.body();
                    //Inicializar la lista ya que estaba vacia
                    showPlanetDetails(planets);
                }
            }
            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public void showPlanetDetails(Planet planetDetails) {
        // Mostrar los detalles del planeta en los TextViews correspondientes
        nameTextView.setText(planetDetails.getName());
        climateTextView.setText(planetDetails.getClimate());
        terrainTextView.setText(planetDetails.getTerrain());
        populationTextView.setText(planetDetails.getPopulation());
    }
}