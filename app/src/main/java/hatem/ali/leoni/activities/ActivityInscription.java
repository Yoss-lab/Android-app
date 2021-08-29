package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInscription extends AppCompatActivity {
 /*   private EditText user_name, password;
    private Button inscription;
    String user_name_val, password_val;

    static String url_cnx = "http://192.168.1.10/leoni_backend/"; //10.0.2.2 pour l'emulateur 10.0.3.2 genymotion
    //http://192.168.1.13:8080/leoni_backend/
    //http://10.0.2.2:8080/


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription_activity);
       /* user_name = (EditText)findViewById(R.id.user_name_text);
        password= (EditText)findViewById(R.id.password);
        Button inscription = (Button)findViewById(R.id.inscription);
        // action
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // recuperation
                user_name_val = user_name.getText().toString();
                password_val = password.getText().toString();
                // verification
                if(user_name.equals("") || password.equals("")){
                    Toast.makeText(ActivityInscription.this, "SVP remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return ;
                }
                //Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                //Matcher m = p.matcher(cmail);
                //if (!m.matches()) {
                    //mail.setError("E-mail invalide");
                    //return;
                //}
                // verification form mail
                // insertion dans la base de dnnées
                insertCondidat();
                Intent intent = new Intent(ActivityInscription.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

        //insert
       /* private void insertCondidat () {
            class PostAsync extends AsyncTask<String, String, String> {
                JSONParser jsonParser = new JSONParser();
                private ProgressDialog pDialog;
                private String url_php = url_cnx + "inscription.php";

                @Override
                protected void onPreExecute() {
                    pDialog = new ProgressDialog(ActivityInscription.this);
                    pDialog.setMessage("Loading...");
                    pDialog.setIndeterminate(false);
                    pDialog.setCancelable(true);
                    pDialog.show();
                }

                @Override
                protected String doInBackground(String... args) {
                    String resultt = null;
                    try {
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("N", user_name_val));
                        params.add(new BasicNameValuePair("PW", password_val));
                        resultt = jsonParser.makeHttpRequest(url_php, "POST", params);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    return resultt;
                }

                protected void onPostExecute(String json) {
                    if (pDialog != null && pDialog.isShowing()) {
                        pDialog.dismiss();
                    }
                    System.out.println("json_data AAAA    : " + json);
                    if (json.contains("ok")) {
                        Toast.makeText(ActivityInscription.this, "Inscription effectuée avec succées", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(ActivityInscription.this, "erreur Inscription ama conection ta3det?", Toast.LENGTH_SHORT).show();
                    }

                }

            }

            PostAsync la = new PostAsync();
            la.execute();
        }

    }*/
}
