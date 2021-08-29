package hatem.ali.leoni.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.R;
import hatem.ali.leoni.items.Cv;
import hatem.ali.leoni.items.User;
import hatem.ali.leoni.storage.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CvActivity extends AppCompatActivity {

    Calendar myCalendar = Calendar.getInstance();

    String picture;
    TextView id;
    EditText nom,prenom,datnaiss,ville,codpost,adr,tel,tel2,eemail,site,linkedin,education,competence,info,langue;
    Button send;
    // Session Manager Class
    SessionManager session;

    ApiInterface apiInterface;
    Context context;
    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);




        // Session class instance
        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        id=findViewById(R.id.cvid);
        nom=findViewById(R.id.nomcv);
        prenom=findViewById(R.id.prenomcv);
        datnaiss=findViewById(R.id.cvnaiss);
        ville=findViewById(R.id.cvville);
        codpost=findViewById(R.id.cvpostal);
        adr=findViewById(R.id.cvAdresse);
        tel=findViewById(R.id.cvphone);
        tel2=findViewById(R.id.cvphone2);
        eemail=findViewById(R.id.cvemail);
        site=findViewById(R.id.cvsite);
        linkedin=findViewById(R.id.cvin);
        education=findViewById(R.id.cveducation);
        competence=findViewById(R.id.cvCompetence);
        info=findViewById(R.id.cvCompINFO);
        langue=findViewById(R.id.cvlangue);

        datnaiss.setFocusableInTouchMode(false);
        datnaiss.setFocusable(false);
        datnaiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CvActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        send=findViewById(R.id.btnSend);


        context=this;
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String iduser=user.get(SessionManager.KEY_ID);
        String name = user.get(SessionManager.KEY_NAME);
        String email = user.get(SessionManager.KEY_EMAIL);
        String phoone = user.get(SessionManager.KEY_PHONE);
        String phoone2 = user.get(SessionManager.KEY_PHONE2);
        String pren = user.get(SessionManager.KEY_PRENOM);
        String dat = user.get(SessionManager.KEY_DATNAISS);
        String villee = user.get(SessionManager.KEY_VILLE);
        String code = user.get(SessionManager.KEY_CODEPOST);
        String competancee = user.get(SessionManager.KEY_COMPETANCE);
        String informa = user.get(SessionManager.KEY_INFO);
        String sitee = user.get(SessionManager.KEY_SITE);
        String linked = user.get(SessionManager.KEY_LINKEDIN);
        String educa = user.get(SessionManager.KEY_EDUCATION);
        String lang = user.get(SessionManager.KEY_LANG);
        String adresse = user.get(SessionManager.KEY_ADRESSE);

        // displaying user data
        id.setText(iduser);
        nom.setText( name );
        eemail.setText( email );
        tel.setText(phoone );
        tel2.setText(phoone2 );
        prenom.setText(pren );
        datnaiss.setText(dat );
        ville.setText(villee );
        codpost.setText(code );
        competence.setText(competancee );
        info.setText(informa );
        site.setText(sitee );
        linkedin.setText(linked );
        education.setText(educa );
        langue.setText(lang );
        adr.setText(adresse );

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCv();
            }
        });

    }

    /**
     * This method is to empty all input edit text
     */



    public void createCv(){

        Call<User> callRegister = apiInterface.createCv(
                id.getText().toString(),
                nom.getText().toString(),
                prenom.getText().toString(),
                datnaiss.getText().toString(),
                ville.getText().toString(),
                codpost.getText().toString(),
                adr.getText().toString(),
                tel.getText().toString(),
                tel2.getText().toString(),
                eemail.getText().toString(),
                site.getText().toString(),
                linkedin.getText().toString(),
                education.getText().toString(),
                competence.getText().toString(),
                info.getText().toString(),
                langue.getText().toString());


        callRegister.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful() && response.body() !=null){
                    User user=response.body();

                    if (user.getSuccess()==1){
                        Toast.makeText(CvActivity.this,"send successful ",Toast.LENGTH_SHORT).show();
                        session.createLoginSession(String.valueOf(user.getId()), user.getPseudo(), user.getPrenom(), user.getEmail(), user.getPhone(), user.getPassword(), user.getGrade(),user.getDatnaiss(),user.getVille(),user.getCode_post(),user.getAdresse(),user.getTel(),user.getSiteWeb(),user.getLinkedIn(),user.getEducation(),user.getCompetence(),user.getInformatique(),user.getLangue());


                    }else {
                        Toast.makeText(CvActivity.this,"CV Mateb3athech ! ",Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {


                Toast.makeText(CvActivity.this,"Error \n"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    //calendrier
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setdatnaiss();
        }

    };


    private void setdatnaiss() {
        String myFormat = "dd MMMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        datnaiss.setText(sdf.format(myCalendar.getTime()));
    }

}
