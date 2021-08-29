package hatem.ali.leoni.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.price_adapter;
import hatem.ali.leoni.items.Price;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrixFragment extends Fragment {

    RecyclerView recyclerView;
    price_adapter myadapter;
    List<Price> priceList=new ArrayList<>();

    public PrixFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_prix, container, false);
        recyclerView=v.findViewById(R.id.prix_recycler);

        UsersManager.getInstance(getActivity()).getAllPrice(new RemoteCallback<List<Price>>(getActivity())
        {
            @Override
            public void onSuccess(List<Price> response) {
                myadapter=new price_adapter(getActivity(),response);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(myadapter);
            }

            @Override
            public void onUnauthorized() {

            }

            @Override
            public void onFailed(Throwable throwable) {

            }


        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
