package hatem.ali.leoni.fragments;


import android.content.Intent;
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

import hatem.ali.leoni.activities.AfficheventActivity;
import hatem.ali.leoni.adapter.event_adapter;
import hatem.ali.leoni.helpers.RecyclerTouchListener;
import hatem.ali.leoni.items.Event;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EvenementFragment extends Fragment {


     RecyclerView recyclerView;
     event_adapter myadapter;
     List<Event> eventList=new ArrayList<>();

    Event event[];
    public EvenementFragment() {
        // Required empty public constructor
    }
    public static EvenementFragment newInstance(String param1) {
        EvenementFragment fragment = new EvenementFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_evenement, container, false);

        recyclerView=v.findViewById(R.id.event_recyclerview);

       event= UsersManager.getInstance(getActivity()).getAllEvent(new RemoteCallback<List<Event>>(getActivity())
        {

            @Override
            public void onSuccess(List<Event> response) {
                myadapter = new event_adapter(getActivity(), response);
                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(myadapter);

                // row click listener
                recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
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
                }));
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
