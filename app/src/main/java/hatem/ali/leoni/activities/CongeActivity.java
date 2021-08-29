package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.items.Conge;
import hatem.ali.leoni.storage.SessionManager;
import hatem.ali.leoni.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CongeActivity extends AppCompatActivity {


    private String datefin,datedebut;
    Calendar myCalendar = Calendar.getInstance();


    // Session Manager Class
    SessionManager session;

    Spinner spinner;
    TextView mOutputSpinnerTv,id,nom,prenom,allconge;
    EditText datDebut,datFin,cause;
    Button send;

    ApiInterface apiInterface;
    Context context;

    //options to be displayed in spinner
    String[] mOptions = {"CONGÉ PAYÉ", "CONGÉ SANS SOLDE", "CONGÉ ANNUEL", "CONGÉ MALADIE","CONGÉ MATERNITÉ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conge);

        // Session class instance
        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        spinner = findViewById(R.id.typeconge);
        mOutputSpinnerTv = findViewById(R.id.outputSpinnerTv);

        id=findViewById(R.id.idUser);
        nom=findViewById(R.id.nomUser);
        prenom=findViewById(R.id.prenomUser);
        datDebut=findViewById(R.id.datedebut);
        datFin=findViewById(R.id.datefin);
        cause=findViewById(R.id.cause);
        send=findViewById(R.id.btnSendconge);
        allconge=findViewById(R.id.allconge);

        datFin.setFocusableInTouchMode(false);
        datFin.setFocusable(false);
        datFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CongeActivity.this, datef, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        datDebut.setFocusableInTouchMode(false);
        datDebut.setFocusable(false);
        datDebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CongeActivity.this, dated, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        context=this;
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);


        //Creating the ArrayAdapter instance having the list of options
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, mOptions);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);

        //spinner item click handler
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //METHOD 1: Get text from selected item's position & set it to TextView
                mOutputSpinnerTv.setText(parent.getItemAtPosition(position).toString());

                //METHOD 2: Get the position of item selected, & perform specific task
               /* if (position==0){
                    mOutputSpinnerTv.setText("Canada is selected...");
                }
                if (position==1){
                    mOutputSpinnerTv.setText("Pakistan is selected...");
                }
                if (position==2){
                    mOutputSpinnerTv.setText("Turkey is selected...");
                }
                if (position==3){
                    mOutputSpinnerTv.setText("US is selected...");
                }
*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String iduser=user.get(SessionManager.KEY_ID);
        String name = user.get(SessionManager.KEY_NAME);
        String pren = user.get(SessionManager.KEY_PRENOM);

        // displaying user data
        id.setText(iduser);
        nom.setText( name );
        prenom.setText( pren );

        allconge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CongeActivity.this,MyCongeActivity.class);
                startActivity(intent);
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createConge();
            }
        });

    }

    public void createConge(){

        Call<Conge> callRegister = apiInterface.createConge(
                id.getText().toString(),
                nom.getText().toString(),
                prenom.getText().toString(),
                mOutputSpinnerTv.getText().toString(),
                datDebut.getText().toString(),
                datFin.getText().toString(),
                cause.getText().toString());

        callRegister.enqueue(new Callback<Conge>() {
            @Override
            public void onResponse(Call<Conge> call, Response<Conge> response) {

                if (response.isSuccessful() && response.body() !=null){
                    Conge conge=response.body();

                    if (conge.isSuccess()){
                        Toast.makeText(CongeActivity.this,"send successful ",Toast.LENGTH_SHORT).show();


                    }else {
                        Toast.makeText(CongeActivity.this,"Congé Mateb3athech ! ",Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<Conge> call, Throwable t) {


                Toast.makeText(CongeActivity.this,"Error \n"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }


    //calendrier
    DatePickerDialog.OnDateSetListener datef = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setdatf();
        }

    };


    private void setdatf() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        datFin.setText(sdf.format(myCalendar.getTime()));
    }

    DatePickerDialog.OnDateSetListener dated = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setdatd();
        }

    };


    private void setdatd() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        datDebut.setText(sdf.format(myCalendar.getTime()));
    }

}

