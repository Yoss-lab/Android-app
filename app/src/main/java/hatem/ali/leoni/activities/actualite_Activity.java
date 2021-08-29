package hatem.ali.leoni.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;
import hatem.ali.leoni.adapter.newfeed_adapter;
import hatem.ali.leoni.items.Newfeed;


public class actualite_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    newfeed_adapter myadapter;
    List<Newfeed> newfeedList=new ArrayList<>();
    Context context;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualite);

        toolbar= getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);

        context=this;
        recyclerView=findViewById(R.id.newfedd_recycler);
        UsersManager.getInstance(this).getAllAct(new RemoteCallback<List<Newfeed>>(this) {
            @Override
            public void onSuccess(List<Newfeed> response) {
                myadapter=new newfeed_adapter(context,response);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(myadapter);
            }
         @Override

          public void onUnauthorized() {
            }
           @Override
           public void onFailed(Throwable throwable) {
            }
        });




    }//end onCreate

}
