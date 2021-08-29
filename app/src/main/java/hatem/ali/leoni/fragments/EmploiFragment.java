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

import hatem.ali.leoni.adapter.emploi_adapter;
import hatem.ali.leoni.items.Emploi;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmploiFragment extends Fragment {

    RecyclerView recyclerView;
    emploi_adapter myadapter;
    List<Emploi> emploiList=new ArrayList<>();


    public static EmploiFragment newInstance(String param1) {
        EmploiFragment fragment = new EmploiFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public EmploiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_emploi, container, false);
        recyclerView=v.findViewById(R.id.job_recycler);
        UsersManager.getInstance(getActivity()).getAllEmploi(new RemoteCallback<List<Emploi>>(getActivity())
        {

            @Override
            public void onSuccess(List<Emploi> response) {
                myadapter = new emploi_adapter(getActivity(), response);
                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(myadapter);
            }
            @Override
            public void onUnauthorized() {
            }
            @Override
            public void onFailed(Throwable throwable) {
            }
        });


        // row click listener
      /*  recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Event event = eventList.get(position);

                Intent intent=new Intent(getActivity(), AfficheventActivity.class);
                //intent.putExtra("image",event.getImage());
                //intent.putExtra("date",event.getDate());
                intent.putExtra("title",event.getTitle_event());
                intent.putExtra("text",event.getText_event());
                //intent.putExtra("place",event.getPlace());

                getActivity().startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/
        return v;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
