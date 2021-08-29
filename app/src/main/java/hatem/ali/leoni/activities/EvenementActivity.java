package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.event_adapter;
import hatem.ali.leoni.items.Event;
import hatem.ali.leoni.R;

public class EvenementActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private event_adapter myadapter;
    private List<Event> eventList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);

        recyclerView=findViewById(R.id.static_recyclerview);
        myadapter=new event_adapter(this,eventList);

        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(myadapter);


    }//end onCreate


}//end class
