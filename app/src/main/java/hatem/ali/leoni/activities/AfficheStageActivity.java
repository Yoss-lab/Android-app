package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import hatem.ali.leoni.R;

import static hatem.ali.leoni.R.id.by_affich_stage;

public class AfficheStageActivity extends AppCompatActivity {

    TextView text,titre,place;

    ImageView image;
    String mtext,mtitre,mplace;
    int mimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_stage);

        titre=findViewById(R.id.title_affich_stage);
        text=findViewById(R.id.desc_affich_stage);
        place=findViewById(R.id.by_affich_stage);
        image=findViewById(R.id.img_affich_stage);

       /* Intent intent=getIntent();
        mtitre=intent.getStringExtra("title");
        mtext=intent.getStringExtra("text");
        mplace=intent.getStringExtra("place");

        titre.setText(mtitre);
        text.setText(mtext);
        place.setText(mplace);*/
        getData();
        setData();
    }

    private void getData(){
        if (/*getIntent().hasExtra("image")*/ getIntent().hasExtra("title" ) && getIntent().hasExtra("text")
            && getIntent().hasExtra("place")){

            Intent intent=getIntent();
            mtitre=intent.getStringExtra("title");
            mtext=intent.getStringExtra("text");
            mplace=intent.getStringExtra("place");


        }else {
            Toast.makeText(this,"NO DATA ",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){

        //date.setText(mdate);
        titre.setText(mtitre);
        text.setText(mtext);
        place.setText(mplace);
      //  image.setImageResource(mimage);
    }

}
