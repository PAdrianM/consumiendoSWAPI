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
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.consumiendoswapi.adapter.RecyclerAdapter;
import com.example.consumiendoswapi.adapter.RecyclerVehicle;
import com.example.consumiendoswapi.client.PlanetResponse;
import com.example.consumiendoswapi.client.SwapiClient;
import com.example.consumiendoswapi.client.SwapiService;
import com.example.consumiendoswapi.client.VehicleResponse;
import com.example.consumiendoswapi.models.Planet;
import com.example.consumiendoswapi.models.Vehicle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class FragmentVehicles extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerVehicle adapter;

    private List<Vehicle> vehicleList = new ArrayList<>();

//    private SearchView mSearchView;
//    private NavController navController;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public FragmentVehicles() {

    }

    public static FragmentVehicles newInstance(String param1, String param2) {
        FragmentVehicles fragment = new FragmentVehicles();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vehicles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_vehicle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        SwapiService swapiService = SwapiClient.getClient().create(SwapiService.class);
        Call<VehicleResponse> call = swapiService.getVehicles();
        call.enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse> call, Response<VehicleResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(), "MENU DE VEHICULOS", Toast.LENGTH_SHORT).show();
                    List<Vehicle> vehicles = response.body().getResults();
                    //Inicializar la lista ya que estaba vacia
                    vehicleList = response.body().getResults();
                    adapter = new RecyclerVehicle(getContext(), vehicles);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<VehicleResponse> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR DE CONEXION, VUELVA A INTENTARLO", Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton btn1 = view.findViewById(R.id.btnAtrasVehicles);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentInicio);
            }
        });
    }
}