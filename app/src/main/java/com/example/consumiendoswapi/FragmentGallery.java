package com.example.consumiendoswapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class FragmentGallery extends Fragment {

    List<CarouselItem> list = new ArrayList<>();


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FragmentGallery() {
        // Required empty public constructor
    }

    public static FragmentGallery newInstance(String param1, String param2) {
        FragmentGallery fragment = new FragmentGallery();
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
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageCarousel carousel = view.findViewById(R.id.carousel);

        list.add(
                new CarouselItem(
                        "https://static.wikia.nocookie.net/esstarwars/images/d/da/Devastator.png/revision/latest?cb=20170618210833", "Destructor Estelar"));
        list.add(
                new CarouselItem(
                        "https://i.pinimg.com/originals/a9/e2/93/a9e2936001d4d371fd086f8906a56054.jpg", "Caza Tie"));
        list.add(
                new CarouselItem(
                        "https://medialab.news/wp-content/uploads/2022/06/anakin.jpg","Anakin Skywalker en la Venganza de los Sith"));
        list.add(
                new CarouselItem("https://lumiere-a.akamaihd.net/v1/images/darth-vader-main_4560aff7.jpeg?region=0%2C67%2C1280%2C720",
                        "Darth Vader"));
        list.add(
                new CarouselItem(
                        "https://static.wikia.nocookie.net/esstarwars/images/8/8f/AT-ST_TCG_by_Adam_Lane.JPG.jpg/revision/latest?cb=20190709231100","AT-ST Imperial"));
        list.add(
                new CarouselItem(
                        "https://cdna.artstation.com/p/assets/covers/images/042/276/964/large/sam-morse-brown-sam-morse-brown-mustafarthumbnail2.jpg?1634059493",
                        "Destructor Estelar Saliendo de la Atmosfera de un Planeta"));
        list.add(
                new CarouselItem("https://4.bp.blogspot.com/-PT3gJdIKFs4/VXG9VB_10WI/AAAAAAAAC1A/JsuKJB7s2Mk/s1600/LukeESB1.jpg",
                        "Luke Skywalker"));
        list.add(
                new CarouselItem("https://static.wikia.nocookie.net/esstarwars/images/f/ff/Leia_photomasher.jpg/revision/latest?cb=20081221003327",
                        "Leia Skywalker"));
        list.add(
                new CarouselItem(
                        "https://cdna.artstation.com/p/assets/images/images/036/557/676/4k/sam-morse-brown-mustafar3.jpg?1617978711",
                        "Planeta Mustafar"));
        list.add(
                new CarouselItem("https://static.wikia.nocookie.net/starwars/images/8/81/Hoth_AoRCR.png/revision/latest?cb=20170222025915",
                        "Planeta Hoth"));
        list.add(
                new CarouselItem("https://i.pinimg.com/564x/eb/3b/49/eb3b49bc4a367e79f79e523b48775e37.jpg",
                        "Arribo Imperial"));
        list.add(
                new CarouselItem("https://i.pinimg.com/564x/7b/1c/29/7b1c297ebc9219687ebd6a929d068454.jpg",
                        "Halcon Milenario"));
        list.add(
                new CarouselItem("https://i.pinimg.com/564x/ec/05/a0/ec05a028703bafb900889b0e5988ad9f.jpg",
                        "Bespin"));
        list.add(
                new CarouselItem("https://i.pinimg.com/564x/a6/f4/48/a6f44854fc447a93e25301f9024b3535.jpg",
                        "Estrella de la Muerte"));
        list.add(
                new CarouselItem("https://media.gettyimages.com/id/474072032/es/foto/the-original-model-of-han-solos-famous-pirate-freighter-the-millennium-falcon-is-seen-during.jpg?s=612x612&w=0&k=20&c=kQK1X8J8D3Sdmlax3NXUJENBucyLnM-Cw2xXPJ8XCNk=",
                        "Halcon Milenario"));
        list.add(
                new CarouselItem("https://swrpggm.com/wp-content/uploads/2022/02/501st-Legion-Clone-Trooper_FE.jpg",
                        "Clone Trooper Fase 2"));
        list.add(
                new CarouselItem("https://upload.wikimedia.org/wikipedia/en/7/72/SW_binary_sunset.png",
                        "Los 2 Soles de Tatooine"));
        list.add(
                new CarouselItem("https://static.wikia.nocookie.net/starwars/images/e/ee/DeathStar2.jpg/revision/latest?cb=20150615015212",
                        "Segunda Estrella de la Muerte"));
        list.add(
                new CarouselItem("https://static.wikia.nocookie.net/theclonewiki/images/b/b4/Tatooine-TCW.png/revision/latest?cb=20180427165120",
                        "Tatooine en Clone Wars"));
        carousel.addData(list);

        //Set Carrousel Listener
        carousel.setCarouselListener(new CarouselListener() {
            @Nullable
            @Override
            public ViewBinding onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup parent) {
                // ...
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewBinding viewBinding, @NonNull CarouselItem carouselItem, int i) {

            }

            @Override
            public void onLongClick(int position, @NotNull CarouselItem dataObject) {
                // ...
            }

            @Override
            public void onClick(int position, @NotNull CarouselItem carouselItem) {
                Toast.makeText(getContext(), "Imagen de Star Wars: " + carouselItem.getCaption(), Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton btn1 = view.findViewById(R.id.btnAtrasGallery);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragmentInicio);
            }
        });
    }
}