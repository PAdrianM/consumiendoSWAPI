package com.example.consumiendoswapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consumiendoswapi.adapter.RecyclerAdapter;
import com.example.consumiendoswapi.client.PlanetResponse;
import com.example.consumiendoswapi.client.SwapiClient;
import com.example.consumiendoswapi.client.SwapiService;
import com.example.consumiendoswapi.models.Planet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
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

    List<CarouselItem> list = new ArrayList<>();

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
//                  Toast.makeText(getContext(), "CONEXION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                    Planet planets = response.body();
                    //Inicializar la lista ya que estaba vacia
                    showPlanetDetails(planets);
                }
                //Inicia quemado de Carousel
                if (nameTextView.getText().equals("Tatooine")){
                    Toast.makeText(getContext(), "Planet Tatooine", Toast.LENGTH_LONG).show();
                    ImageCarousel carousel = view.findViewById(R.id.carouselPlanet);

                    list.add(
                            new CarouselItem("https://static.wikia.nocookie.net/starwars/images/b/b0/Tatooine_TPM.png/revision/latest/scale-to-width-down/350?cb=20131019121937",
                                    "Tatooine"));
                    list.add(
                            new CarouselItem(R.drawable.fondo1, "Palacio de Java"));
                    list.add(
                            new CarouselItem("https://medias.spotern.com/spots/w640/111/111417-1532336916.webp",
                                    "Retorno del Jedi"));
                    list.add(
                            new CarouselItem("https://d3kjluh73b9h9o.cloudfront.net/original/4X/4/2/c/42c6046d525ca86ceef113be67c8eace46fa9131.jpeg",
                                    "Mos Eisley"));
                    list.add(
                            new CarouselItem("https://d3kjluh73b9h9o.cloudfront.net/original/4X/b/0/3/b03c4064c0cc83e6bab84cf73e9503bf99d9f747.jpeg",
                                    "Puerto carguero de Mos Eisley"));
                    list.add(
                            new CarouselItem("https://d3kjluh73b9h9o.cloudfront.net/original/4X/a/a/9/aa9a472db957143805bed467793479f63f85cb79.jpeg",
                                    "Cantina de Mos Eisley"));
                    carousel.addData(list);
                } else if (nameTextView.getText().equals("Alderaan")) {
                    Toast.makeText(getContext(), "Planet Alderan", Toast.LENGTH_LONG).show();
                    ImageCarousel carousel = view.findViewById(R.id.carouselPlanet);
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/alderaan-main_f5b676cf.jpeg?region=0%2C0%2C1280%2C720",
                                    "Alderaan"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/1-alderaan-bio-1_copy_d2ef86c5.jpeg?region=0%2C0%2C1280%2C550",
                                    "Alderaan En Clone Wars"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/alderaan-3-retina_45d076ff.jpeg?region=0%2C0%2C1200%2C544",
                                    "Alderaan a punto de ser destruida por la Estrella de la Muerte"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/alderaan-2-retina_7dfdb548.jpeg?region=0%2C0%2C1200%2C509",
                                    "Zonas nevadas de Alderaan"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/alderaan-1-retina_6a8e77bc.jpeg?region=0%2C0%2C1200%2C511",
                                    "Alderan uno de los planetas mas antiguos"));
                    carousel.addData(list);

                } else if (nameTextView.getText().equals("Yavin IV")) {
                    Toast.makeText(getContext(), "Planet Yavin IV", Toast.LENGTH_LONG).show();
                    ImageCarousel carousel = view.findViewById(R.id.carouselPlanet);
                    list.add(
                            new CarouselItem("https://static.wikia.nocookie.net/starwars/images/d/d4/Yavin-4-SWCT.png/revision/latest/scale-to-width-down/500?cb=20181015023938",
                                    "Yavin IV"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/databank_yavin4_01_169_b6945e20.jpeg?region=0%2C0%2C1560%2C878",
                                    "Yavin IV en Una Nueva Esperanza"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/yavin-4-bio-1_copy_16aecaaa.jpeg?region=0%2C0%2C1273%2C576",
                                    "Puesto de mando de Yavin IV"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/open-uri20150608-27674-1kk1hf0_8292f2b0.jpeg?region=0%2C0%2C1200%2C509",
                                    "Yavin IV se convirtio en una de las bases principales de la Alianza Rebelde"));
                    list.add(
                            new CarouselItem(R.drawable.yavin,
                                    "Puesto de naves Yavin IV"));
                    carousel.addData(list);
                } else if (nameTextView.getText().equals("Hoth")) {
                    Toast.makeText(getContext(), "Planet Hoth", Toast.LENGTH_LONG).show();
                    ImageCarousel carousel = view.findViewById(R.id.carouselPlanet);
                    list.add(
                            new CarouselItem("https://static.wikia.nocookie.net/starwars/images/1/1d/Hoth_SWCT.png/revision/latest/scale-to-width-down/500?cb=20160630022322",
                                    "Hoth"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/star-wars-backgrounds-32_f3fdc4cd.jpeg?download=true",
                                    "Hoth uno de los principales planetas helidos de Star Wars"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/star-wars-backgrounds-31_0a247b7f.jpeg?download=true",
                                    "Cañon Laser de la base en Hoth"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/star-wars-backgrounds-30_a8feb217.jpeg?download=true",
                                    "Dunas de nieve en Hoth"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/open-uri20150608-27674-83g3lt_76fb492d.jpeg?region=0%2C0%2C1200%2C675",
                                    "Caminante Imperial Modelo AT-AT"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/Hoth-1_9403311b.jpeg?region=0%2C0%2C960%2C539",
                                    "Base Rebelde en Hoth"));
                    list.add(
                            new CarouselItem("https://static1.srcdn.com/wordpress/wp-content/uploads/2019/08/star-wars-empire-strikes-back-hoth-ion-canon-echo-base-Edited.jpg?q=50&fit=contain&w=1140&h=&dpr=1.5",
                                    "Cañones Laseres de la base Rebelde en Hoth"));
                    carousel.addData(list);
                } else if (nameTextView.getText().equals("Dagobah")) {
                    Toast.makeText(getContext(), "Planet Dagobah", Toast.LENGTH_LONG).show();
                    ImageCarousel carousel = view.findViewById(R.id.carouselPlanet);
                    list.add(
                            new CarouselItem("https://static.wikia.nocookie.net/starwars/images/4/48/Dagobah_ep3.jpg/revision/latest/scale-to-width-down/500?cb=20100122163146",
                                    "Dagobah"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/Dagobah_890df592.jpeg?region=0%2C80%2C1260%2C711",
                                    "El planeta pantanoso de Dagobah"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/1-dagobah-bio-1_copy_5dca1da4.jpeg?region=0%2C0%2C1278%2C540",
                                    "El exilio"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/dagobah-bio-6_62f469f1.jpeg",
                                    "El arribo de Luke a Dagobah"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/dagobah-bio-7_9bc8c90b.jpeg",
                                    "Luke conoce a Yoda en Dagobah"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/dagobah-bio-9_42797cc6.jpeg",
                                    "El entrenamiento de Luke en Dagobah"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/dagobah-bio-12_3c6b2ed5.jpeg",
                                    "Yoda mostrando el poder de la Fuerza"));
                    list.add(
                            new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/dagobah-2-retina_92180bd1.jpeg?region=0%2C0%2C1200%2C512",
                                    "Vista desde el espacio del Planeta Dagobah"));
                    carousel.addData(list);
                }
            }
            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                Toast.makeText(getContext(), "ERROR DE CONEXION, VUELVA A INTENTARLO", Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton btn1 = view.findViewById(R.id.btnAtras);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentPlanet);
            }
        });
        return view;
    }

    public void showPlanetDetails(Planet planetDetails) {
        // Mostrar los detalles del planeta en los TextViews correspondientes
        nameTextView.setText(planetDetails.getName());
        climateTextView.setText("Climate: " + planetDetails.getClimate());
        terrainTextView.setText("Terrain: " + planetDetails.getTerrain());
        populationTextView.setText("Population: " + planetDetails.getPopulation());
    }
}