package hatem.ali.leoni.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hatem.ali.leoni.R;

public class AfficheCongeActivity extends AppCompatActivity {

    TextView type,cause,statut,debut,fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_conge);

        type=findViewById(R.id.typeConge);
        cause=findViewById(R.id.causeConge);
        statut=findViewById(R.id.statutConge);
        debut=findViewById(R.id.dtdebut);
        fin=findViewById(R.id.dtfin);

    }
}
