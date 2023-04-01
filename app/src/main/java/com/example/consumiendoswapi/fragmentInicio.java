package com.example.consumiendoswapi;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class fragmentInicio extends Fragment {

    private ImageView image1, image2, image3;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentInicio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentInicio.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentInicio newInstance(String param1, String param2) {
        fragmentInicio fragment = new fragmentInicio();
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
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        image1 = view.findViewById(R.id.imageView2);
        image2 = view.findViewById(R.id.imageView3);
        image3 = view.findViewById(R.id.imageView4);

        //Cargamos el link del gif 1
        String url = "https://media.giphy.com/media/3owzWaX1LIX9mvpClG/giphy.gif";
        //Lo parseamos
        Uri urlparse = Uri.parse(url);
        //Usamos Glide de la libreria Glide obtenemos el contexto lo cargamos parseado y lo insertamos
        Glide.with(getContext()).load(urlparse).into(image1);

        //Cargamos el link del gif 2
        String url2 = "https://media.giphy.com/media/nopqz91prOyvS/giphy.gif";
        Uri urlparse2 = Uri.parse(url2);
        Glide.with(getContext()).load(urlparse2).into(image2);

        //Cargamos el link del gif 3
        String url3 = "https://media.giphy.com/media/YR2yIaS2m3ewoLp3ke/giphy-downsized-large.gif";
        Uri urlparse3 = Uri.parse(url3);
        Glide.with(getContext()).load(urlparse3).into(image3);

        super.onViewCreated(view, savedInstanceState);
        Button btn1 = view.findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentPlanet);
            }
        });
        Button btn2 = view.findViewById(R.id.btnGallery);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentGallery);
            }
        });
//        Button btn3 = view.findViewById(R.id.btnEspecies);
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Navigation.findNavController(view).navigate(R.id.);
//            }
//        });
    }
}