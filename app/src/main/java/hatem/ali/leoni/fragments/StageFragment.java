package hatem.ali.leoni.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.R;
import hatem.ali.leoni.adapter.stage_adapter;
import hatem.ali.leoni.items.Stage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class StageFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    //private Adapter adapter;
    private stage_adapter myadapter;
    private List<Stage> stageList;
    ApiInterface apiInterface;
    stage_adapter.RecyclerViewClickListener listener;


    public static StageFragment newInstance(String param1) {
        StageFragment fragment = new StageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public StageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_stage, container, false);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        recyclerView=v.findViewById(R.id.stage_recycler);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

       /* listener = new stage_adapter.RecyclerViewClickListener() {            @Override
            public void onRowClick(View view, final int position) {

                Intent intent = new Intent(getActivity(), AfficheStageActivity.class);

                 intent.putExtra("image", stageList.get(position).getImage_stage());
                 intent.putExtra("title", stageList.get(position).getTitle_stage());
                 intent.putExtra("text", stageList.get(position).getDesc_stage());
                 intent.putExtra("place", stageList.get(position).getAnnonce_de());

                startActivity(intent);

            }

          /*  @Override
            public void onLoveClick(View view, int position) {

                final int id = petsList.get(position).getId();
                final Boolean love = petsList.get(position).getLove();
                final ImageView mLove = view.findViewById(R.id.love);

                if (love){
                    mLove.setImageResource(R.drawable.likeof);
                    petsList.get(position).setLove(false);
                    updateLove("update_love", id, false);
                    adapter.notifyDataSetChanged();
                } else {
                    mLove.setImageResource(R.drawable.likeon);
                    petsList.get(position).setLove(true);
                    updateLove("update_love", id, true);
                    adapter.notifyDataSetChanged();
                }

            }*/
        //};

        /*UsersManager.getInstance(getActivity()).getAllStage(new RemoteCallback<List<Stage>>(getActivity())
        {

            @Override
            public void onSuccess(List<Stage> response) {
                myadapter = new stage_adapter(getActivity(), response);
                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity() , LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(myadapter);
               // myadapter.setOnItemClickListener(StageFragment.this);

                // row click listener
               /* recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Stage stage = stageList.get(position);

                        Intent intent=new Intent(getActivity(), AfficheStageActivity.class);
                        intent.putExtra("image",stage.getImage_stage());
                        //intent.putExtra("date",event.getDate());
                        intent.putExtra("title",stage.getTitle_stage());
                        intent.putExtra("text",stage.getDesc_stage());
                        intent.putExtra("place",stage.getAnnonce_de());

                        getActivity().startActivity(intent);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));*/


                 /*         }
            @Override
            public void onUnauthorized() {
            }
            @Override
            public void onFailed(Throwable throwable) {
            }
        });*/


        getStages();



        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

   /* @Override
    public void onItemClick(int position) {

        Stage stage = stageList.get(position);

        Intent intent=new Intent(getActivity(), AfficheStageActivity.class);
        intent.putExtra("image",stage.getImage_stage());
        //intent.putExtra("date",event.getDate());
        intent.putExtra("title",stage.getTitle_stage());
        intent.putExtra("text",stage.getDesc_stage());
        intent.putExtra("place",stage.getAnnonce_de());

        getActivity().startActivity(intent);

    }*/

    public void getStages(){

        Call<List<Stage>> call = apiInterface.getAllStage();
        call.enqueue(new Callback<List<Stage>>() {
            @Override
            public void onResponse(Call<List<Stage>> call, Response<List<Stage>> response) {
                //progressBar.setVisibility(View.GONE);
                stageList = response.body();
                Log.i(StageFragment.class.getSimpleName(), response.body().toString());
                stage_adapter adapter = new stage_adapter(stageList, getActivity(), listener);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Stage>> call, Throwable t) {
                Toast.makeText(getActivity(), "rp :"+
                                t.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

