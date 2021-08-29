package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


import hatem.ali.leoni.items.User;
import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {


    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPhone;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPhone;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private Button ButtonRegister;

    ApiInterface apiInterface;

    // changeStatusBarColor();
/*

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$");

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +        //any letter
                    //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +             //no white spaces
                    ".{4,}" +                 //at least 4 characters
                    "$");

*/
Context context;
ProgressDialog progressDialog;
User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context=this;

        //nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutName = (TextInputLayout) findViewById(R.id.textInputName);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputEmail);
        textInputLayoutPhone = (TextInputLayout) findViewById(R.id.textInputMobile);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputPassword);
        textInputLayoutConfirmPassword = (TextInputLayout) findViewById(R.id.textConfirmPassword);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.editTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.editTextEmail);
        textInputEditTextPhone = (TextInputEditText) findViewById(R.id.editTextMobile);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.editTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.confirmTextPassword);

        ButtonRegister = (Button) findViewById(R.id.RegisterButton);

        //appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);

        ButtonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                registerUser();


            }
        });


    }


    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPhone.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

    @Override
    public void onClick(View v) {

    }

    /**
     * Background Async Task to Create new product
     */

    public void registerUser(){
        Call<User> callRegister = apiInterface.registerUser(textInputLayoutName.getEditText().getText().toString(),
                textInputLayoutEmail.getEditText().getText().toString(),
                textInputLayoutPhone.getEditText().getText().toString(),
                textInputLayoutPassword.getEditText().getText().toString());


        callRegister.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful() && response.body() !=null){
                    User user=response.body();

                    if (user.getSuccess()==1){
                        Toast.makeText(RegisterActivity.this,"Register successful ",Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(RegisterActivity.this,"user matsajalech ! ",Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Toast.makeText(RegisterActivity.this,"Error \n"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

}


