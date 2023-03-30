package com.example.consumiendoswapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.consumiendoswapi.adapter.RecyclerAdapter;
import com.example.consumiendoswapi.client.PlanetResponse;
import com.example.consumiendoswapi.client.SwapiClient;
import com.example.consumiendoswapi.client.SwapiService;
import com.example.consumiendoswapi.models.Planet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentPlanet extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private SearchView mSearchView;
    private NavController navController;

    //Inicializar la vista
    private List<Planet> planetList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPlanet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentPlanet.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPlanet newInstance(String param1, String param2) {
        FragmentPlanet fragment = new FragmentPlanet();
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
        View view = inflater.inflate(R.layout.fragment_planet, container, false);
        mSearchView = view.findViewById(R.id.searchView);

        //Aqui empezamos para ver el buscador
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                buscaPlanet(s);
                return true;
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        mSearchView = view.findViewById(R.id.searchView);
        recyclerView = view.findViewById(R.id.rv_planet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SwapiService swapiService = SwapiClient.getClient().create(SwapiService.class);
        Call<PlanetResponse> call = swapiService.getPlanets();
        call.enqueue(new Callback<PlanetResponse>() {
            @Override
            public void onResponse(Call<PlanetResponse> call, Response<PlanetResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(), "CONEXION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                    List<Planet> planets = response.body().getResults();
                    //Inicializar la lista ya que estaba vacia
                    planetList = response.body().getResults();
                    adapter = new RecyclerAdapter(getContext(), planets, navController);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<PlanetResponse> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void buscaPlanet(String terminoBusqueda) {
        List<Planet> planetasEncotrados = new ArrayList<>();
        for (Planet planet : planetList) {
            if (planet.getName().toLowerCase().contains(terminoBusqueda.toLowerCase())) {
                planetasEncotrados.add(planet);
            }
        }
        adapter = new RecyclerAdapter(getContext(), planetasEncotrados, navController);
        recyclerView.setAdapter(adapter);
    }
}