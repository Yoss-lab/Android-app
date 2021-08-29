package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.histo_adapter;
import hatem.ali.leoni.items.History;
import hatem.ali.leoni.R;

public class historique extends AppCompatActivity {
    RecyclerView recyclerView;
    histo_adapter myadapter;
    List<History>histoList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);

        recyclerView=findViewById(R.id.recycler_view);
        myadapter=new histo_adapter(this,histoList);

        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myadapter);


    }//end onCreate

}
