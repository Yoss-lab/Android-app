package hatem.ali.leoni.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.R;
import hatem.ali.leoni.helpers.inputValidation;
import hatem.ali.leoni.items.User;
import hatem.ali.leoni.storage.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    // Alert Dialog Manager

    // Session Manager Class
    SessionManager session;
    private final AppCompatActivity activity = LoginActivity.this;
     String mPass;
     String mEmail;


    TextView textid;
    //private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText email;
    private TextInputEditText password;

    private Button ButtonLogin;

   // private AppCompatTextView textViewLinkRegister;

    private inputValidation inputvalidation;

    ApiInterface apiInterface;


       /* private static final Pattern PASSWORD_PATTERN =
                Pattern.compile("^" +
                        //"(?=.*[0-9])" +         //at least 1 digit
                        //"(?=.*[a-z])" +         //at least 1 lower case letter
                        //"(?=.*[A-Z])" +         //at least 1 upper case letter
                        "(?=.*[a-zA-Z])" +      //any letter
                        "(?=.*[@#$%^&+=])" +    //at least 1 special character
                        "(?=\\S+$)" +           //no white spaces
                        ".{4,}" +               //at least 4 characters
                        "$");

        private TextInputLayout textInputEmail;
       // private TextInputLayout textInputUsername;
        private TextInputLayout textInputPassword;
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        //nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        // Session Manager
        session = new SessionManager(getApplicationContext());

  //      Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();


        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputPassword);

        email = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        password = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);


        ButtonLogin = (Button) findViewById(R.id.LoginButton);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);


        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();
               // Login(mEmail,mPass);
                //verifyFromSQLite();
            }
        });



        inputvalidation = new inputValidation(activity);


        //textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);


       /* textInputEmail = findViewById(R.id.textInputEmail);
        //textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.textInputPassword);
        */
        }

         public void onLoginClick(View View){
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
        }
/*
        private boolean validateEmail() {
            String emailInput = textInputEmail.getEditText().getText().toString().trim();

            if (emailInput.isEmpty()) {
                textInputEmail.setError("Field can't be empty");
                return false;

            } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                textInputEmail.setError("Please enter a valid email address");
                return false;
            } else {
                textInputEmail.setError(null);
                return true;
            }
        }

*/

       /* private boolean validateUsername() {
            String usernameInput = textInputUsername.getEditText().getText().toString().trim();

            if (usernameInput.isEmpty()) {
                textInputUsername.setError("Field can't be empty");
                return false;
            } else if (usernameInput.length() > 15) {
                textInputUsername.setError("Username too long");
                return false;
            } else {
                textInputUsername.setError(null);
                return true;
            }
        }*/
/*
        private boolean validatePassword() {
            String passwordInput = textInputPassword.getEditText().getText().toString().trim();

            if (passwordInput.isEmpty()) {
                textInputPassword.setError("Field can't be empty");
                return false;
            } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                textInputPassword.setError("Password too weak");
                return false;
            } else {
                textInputPassword.setError(null);
                return true;
            }
        }
*/


       /* public void confirmInput(View v) {
            if (!validateEmail() | !validatePassword()) {
                return;
            }

            String input = "Email: " + textInputEmail.getEditText().getText().toString();
            input += "\n";
            /*input += "Username: " + textInputUsername.getEditText().getText().toString();
            input += "\n";
            input += "Password: " + textInputPassword.getEditText().getText().toString();

            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        }*/

    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
 /*   private void verifyFromSQLite() {
        if (!inputvalidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputvalidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputvalidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
                , textInputEditTextPassword.getText().toString().trim())) {


            Toast.makeText(this,"Login avec succé", Toast.LENGTH_SHORT).show();


             // send informations of User to espace membre activity

            Intent intent = new Intent(activity, EspacemembreActivity.class);


           // String use=databaseHelper.checkId(textInputEditTextEmail.getText().toString());
            //sellection id
           // intent.putExtra("id", use);

           /* User use;
            use = databaseHelper.getUser(textInputEditTextEmail.getText().toString());

            intent.putExtra("id", use.getName());*/
            // Bitmap bitmap = BitmapFactory.decodeByteArray(userImage, 0, userImage.length);
            // userImageView.setImageBitmap(bitmap);

           // userNameTexView.setText(User.getUserName());


            //intent.putExtra("password", textInputEditTextPassword.getText().toString().trim());
       /*     intent.putExtra("mail", textInputEditTextEmail.getText().toString().trim());
           // intent.putExtra("phone", "phone depuis data base");
            emptyInputEditText();
            startActivity(intent);


        } else {
            // Snack Bar to show success message that record is wrong
            Toast.makeText(this,"Echec login", Toast.LENGTH_SHORT).show();
           // Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }*/

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        email.setText(null);
        password.setText(null);
    }



    public void loginUser(){

        Call<User> userCall=apiInterface.loginUser(textInputLayoutEmail.getEditText().getText().toString(),
                textInputLayoutPassword.getEditText().getText().toString());

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful() && response.body()!= null){
                    User user=response.body();


                    if (user.getSuccess()==1) {
                        Toast.makeText(LoginActivity.this, "vous etes visiteur ", Toast.LENGTH_SHORT).show();

                        session.createLoginSession(String.valueOf(user.getId()), user.getPseudo(), user.getPrenom(), user.getEmail(), user.getPhone(), user.getPassword(), user.getGrade(),user.getDatnaiss(),user.getVille(),user.getCode_post(),user.getAdresse(),user.getTel(),user.getSiteWeb(),user.getLinkedIn(),user.getEducation(),user.getCompetence(),user.getInformatique(),user.getLangue());

                        Intent i = new Intent(LoginActivity.this, EspacemembreActivity.class);
                        startActivity(i);
                        finish();
                    }else if (user.getSuccess()==2){

                        Toast.makeText(LoginActivity.this, "vous etes employe ", Toast.LENGTH_SHORT).show();

                        session.createLoginSession(String.valueOf(user.getId()), user.getPseudo(), user.getPrenom(), user.getEmail(), user.getPhone(), user.getPassword(), user.getGrade(),user.getDatnaiss(),user.getVille(),user.getCode_post(),user.getAdresse(),user.getTel(),user.getSiteWeb(),user.getLinkedIn(),user.getEducation(),user.getCompetence(),user.getInformatique(),user.getLangue());

                        Intent i = new Intent(LoginActivity.this, EspaceemployeActivity.class);
                        startActivity(i);
                        finish();

                    }else {
                        Toast.makeText(LoginActivity.this,"User not found! ",Toast.LENGTH_SHORT).show();

                    }
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(LoginActivity.this,"Error \n "+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }



}

