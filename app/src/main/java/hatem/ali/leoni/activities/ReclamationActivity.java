package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.R;
import hatem.ali.leoni.items.Reclamation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReclamationActivity extends AppCompatActivity {
    EditText champ;
    Button btn;
    ApiInterface apiInterface;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamation);

        champ=findViewById(R.id.reclamation);
        btn=findViewById(R.id.btnReclamation);

        context=this;
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createReclamation();
            }
        });

    }

    private void emptyInputEditText() {
        champ.setText(null);
    }

    public void createReclamation(){

        Call<Reclamation> callRegister = apiInterface.createReclamation(

                champ.getText().toString());

        callRegister.enqueue(new Callback<Reclamation>() {
            @Override
            public void onResponse(Call<Reclamation> call, Response<Reclamation> response) {

                if (response.isSuccessful() && response.body() !=null){
                    Reclamation reclamation=response.body();

                    if (reclamation.isSuccess()){
                        Toast.makeText(ReclamationActivity.this,"send successful ",Toast.LENGTH_SHORT).show();
                        emptyInputEditText();


                    }else {
                        Toast.makeText(ReclamationActivity.this,"Reclamation Mateb3athech ! ",Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<Reclamation> call, Throwable t) {


                Toast.makeText(ReclamationActivity.this,"Error \n"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

}
