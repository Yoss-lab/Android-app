package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.image_adapter;
import hatem.ali.leoni.items.image;
import hatem.ali.leoni.R;

public class ActivityStatistique extends AppCompatActivity {

    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistique);
        viewPager2=findViewById(R.id.price_viewpager);

        List<image> imageList=new ArrayList<>();
        imageList.add(new image(R.drawable.event1));
        imageList.add(new image(R.drawable.event2));
        imageList.add(new image(R.drawable.event3));

        viewPager2.setAdapter(new image_adapter(imageList,viewPager2));
    }
}
