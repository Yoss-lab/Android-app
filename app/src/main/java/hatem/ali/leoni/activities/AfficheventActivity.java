package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import hatem.ali.leoni.R;

public class AfficheventActivity extends AppCompatActivity {

    //ImageView image;
    TextView date,text,titre,place;

    String mdate,mtext,mtitre,mplace;
    int mimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichevent);

       // image=findViewById(R.id.img_affich_event);
        text=findViewById(R.id.desc_affich_event);
        date=findViewById(R.id.dat_affich_event);
        place=findViewById(R.id.plac_affich_event);
        titre=findViewById(R.id.title_affich_event);

        getData();
        setData();
    }


    private void getData(){
        if (/*getIntent().hasExtra("image") && getIntent().hasExtra("date")
        && */ getIntent().hasExtra("title" ) && getIntent().hasExtra("text")
                /*&& getIntent().hasExtra("place")*/
        ){
           // mdate=getIntent().getStringExtra("date");
            mtitre=getIntent().getStringExtra("title");
            mtext=getIntent().getStringExtra("text");
           // mplace=getIntent().getStringExtra("place");
            //mimage=getIntent().getIntExtra("image",1);

        }else {
            Toast.makeText(this,"NO DATA ",Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){

        //date.setText(mdate);
        titre.setText(mtitre);
        text.setText(mtext);
        //place.setText(mplace);
        //image.setImageResource(mimage);
    }
}
