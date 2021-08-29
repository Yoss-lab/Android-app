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

import hatem.ali.leoni.adapter.histo_adapter;
import hatem.ali.leoni.items.History;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoriqueFragment extends Fragment {


    RecyclerView recyclerView;
    histo_adapter myadapter;
    List<History> histoList= new ArrayList<>();

    public HistoriqueFragment() {
        // Required empty public constructor
    }

    public static HistoriqueFragment newInstance(String param1) {
       HistoriqueFragment fragment = new HistoriqueFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_historique, container, false);

        recyclerView=v.findViewById(R.id.recycler_view);
        UsersManager.getInstance(getActivity()).getAllHistory(new RemoteCallback<List<History>>(getActivity())
        {

            @Override
            public void onSuccess(List<History> response) {
                myadapter = new histo_adapter(getActivity(), response);
                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
               // recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
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



    }//end onCreateView

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


}
