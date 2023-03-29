package com.example.consumiendoswapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consumiendoswapi.models.Planet;

public class vistaPlaneta extends Fragment {

    private TextView nameTextView;
    private TextView climateTextView;
    private TextView terrainTextView;
    private TextView populationTextView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public vistaPlaneta() {
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
    public static vistaPlaneta newInstance(String param1, String param2, int planetId) {
        vistaPlaneta fragment = new vistaPlaneta();
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
        View rootView = inflater.inflate(R.layout.fragment_vista_planeta, container, false);

        // Obtener referencias a los TextViews que mostrarán los detalles del planeta
        nameTextView = rootView.findViewById(R.id.planet_name);
        climateTextView = rootView.findViewById(R.id.planet_climate);
        terrainTextView = rootView.findViewById(R.id.planet_terrain);
        populationTextView = rootView.findViewById(R.id.planet_population);

        return rootView;
    }
    public void showPlanetDetails(Planet planetDetails) {
        // Mostrar los detalles del planeta en los TextViews correspondientes
        nameTextView.setText(planetDetails.getName());
        climateTextView.setText(planetDetails.getClimate());
        terrainTextView.setText(planetDetails.getTerrain());
        populationTextView.setText(planetDetails.getPopulation());
    }
}