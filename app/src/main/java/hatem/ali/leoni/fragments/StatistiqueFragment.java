package hatem.ali.leoni.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.image_adapter;
import hatem.ali.leoni.items.image;
import hatem.ali.leoni.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatistiqueFragment extends Fragment {

    private ViewPager2 viewPager2;

    public StatistiqueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_statistique, container, false);
        viewPager2=v.findViewById(R.id.price_viewpager);

        List<image> imageList=new ArrayList<>();
        imageList.add(new image(R.drawable.event1));
        imageList.add(new image(R.drawable.event2));
        imageList.add(new image(R.drawable.event3));

        viewPager2.setAdapter(new image_adapter(imageList,viewPager2));

        return v;
    }

}
