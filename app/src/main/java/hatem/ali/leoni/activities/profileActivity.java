package hatem.ali.leoni.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.HashMap;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.R;
import hatem.ali.leoni.items.User;
import hatem.ali.leoni.storage.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profileActivity extends AppCompatActivity {

    // Session Manager Class
    SessionManager session;

    EditText pseudo,mail,password,phone;
    TextView id,grade;
    Button back_btn,update_btn;
    ApiInterface apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Session class instance
        session = new SessionManager(getApplicationContext());
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);


        id=findViewById(R.id.idprofile);
        grade=findViewById(R.id.success);
        pseudo=findViewById(R.id.pseudo);
        mail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        back_btn=findViewById(R.id.returnespace);
        update_btn=findViewById(R.id.updateProfile);



       // Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        session.checkLogin();
       // session.createLoginSession(String.valueOf(user.getId()), user.getPseudo(), user.getPrenom(), user.getEmail(), user.getPhone(), user.getPassword(), user.getGrade(),user.getDatnaiss(),user.getVille(),user.getCode_post(),user.getAdresse(),user.getTel(),user.getSiteWeb(),user.getLinkedIn(),user.getEducation(),user.getCompetence(),user.getInformatique(),user.getLangue());

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String idd=user.get(SessionManager.KEY_ID);
        String name = user.get(SessionManager.KEY_NAME);
        String email = user.get(SessionManager.KEY_EMAIL);
        String passwoord = user.get(SessionManager.KEY_PASSWORD);
        String phoone = user.get(SessionManager.KEY_PHONE);
        String su = user.get(SessionManager.KEY_GRADE);

        // displaying user data
        id.setText(idd);
        pseudo.setText( name );
        mail.setText( email );
        password.setText(passwoord );
        phone.setText(phoone );
        grade.setText(su );

        back_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onBackPressed();
               //Intent intent=new Intent(profileActivity.this,EspacemembreActivity.class);
               //startActivity(intent);
               finish();
           }
       });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfile();
            }
        });




    }



    public void updateProfile(){

        Call<User> callRegister = apiInterface.updateProfile(
                id.getText().toString(),
                mail.getText().toString(),
                password.getText().toString());


        callRegister.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful() && response.body() !=null){
                    User user=response.body();

                    if (user.getSuccess()==1){
                        Toast.makeText(profileActivity.this,"update seccessful ",Toast.LENGTH_SHORT).show();



                        session.createLoginSession(String.valueOf(user.getId()), user.getPseudo(), user.getPrenom(), user.getEmail(), user.getPhone(), user.getPassword(), user.getGrade(),user.getDatnaiss(),user.getVille(),user.getCode_post(),user.getAdresse(),user.getTel(),user.getSiteWeb(),user.getLinkedIn(),user.getEducation(),user.getCompetence(),user.getInformatique(),user.getLangue());



                    }else {
                        Toast.makeText(profileActivity.this,"update 8alta! ",Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {


                Toast.makeText(profileActivity.this,"Error \n"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }



}
