package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import java.util.List;

import hatem.ali.leoni.adapter.price_adapter;
import hatem.ali.leoni.items.Price;
import hatem.ali.leoni.R;

public class PrixActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    price_adapter myadapter;
    List<Price> priceList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prix);

        recyclerView=findViewById(R.id.prix_recycler);
        myadapter=new price_adapter(this,priceList);

        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myadapter);





    }//end onCreate



}
