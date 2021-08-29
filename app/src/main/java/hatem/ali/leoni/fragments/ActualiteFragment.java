package hatem.ali.leoni.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.newfeed_adapter;
import hatem.ali.leoni.items.Newfeed;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActualiteFragment extends Fragment {

    RecyclerView recyclerView;
    newfeed_adapter myadapter;
    List<Newfeed> newfeedList=new ArrayList<>();

    public ActualiteFragment() {
        // Required empty public constructor
    }

    public static ActualiteFragment newInstance(String param1) {
        ActualiteFragment fragment = new ActualiteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_actualite, container, false);

        recyclerView=v.findViewById(R.id.newfedd_recycler);
        UsersManager.getInstance(getActivity()).getAllAct(new RemoteCallback<List<Newfeed>>(getActivity()){

            @Override
            public void onSuccess(List<Newfeed> response) {
                myadapter=new newfeed_adapter(getActivity(),response);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
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
