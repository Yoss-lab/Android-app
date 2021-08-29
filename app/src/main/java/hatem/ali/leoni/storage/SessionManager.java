package hatem.ali.leoni.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

import hatem.ali.leoni.activities.LoginActivity;

public class SessionManager {

    // Shared Preferences
    SharedPreferences pref;

    private static SessionManager mInstance;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "leoniPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // (make variable public to access from outside)
    public static final String KEY_NAME = "name";
    public static final String KEY_PRENOM = "prenom";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_GRADE= "grade";

    public static final String KEY_DATNAISS= "datnaiss";
    public static final String KEY_VILLE= "ville";
    public static final String KEY_CODEPOST= "codepost";
    public static final String KEY_ADRESSE= "adresse";
    public static final String KEY_PHONE2= "phone2";
    public static final String KEY_SITE= "site";
    public static final String KEY_LINKEDIN= "linkedin";
    public static final String KEY_EDUCATION= "education";
    public static final String KEY_COMPETANCE= "competance";
    public static final String KEY_INFO= "info";
    public static final String KEY_LANG= "lang";

    //data cv
  /*  public static final String KEY_NAMECONGE = "nameconge";
    public static final String KEY_PRENOMCONGE = "prenomconge";
    public static final String KEY_EMAILCONGE = "emailconge";
    public static final String KEY_IDCONGE= "idconge";
    public static final String KEY_PHONE1 = "phone1";
    public static final String KEY_PHONE2 = "phone2";
    public static final String KEY_IDUSER = "iduser";
    public static final String KEY_DATENAISS = "datenaiss";
    public static final String KEY_VILLE = "ville";
    public static final String KEY_CODEPOSTALE = "codepostale";
    public static final String KEY_SITE = "site";
    public static final String KEY_LINKEDIN = "linkedin";
    public static final String KEY_EDUCATION = "education";
    public static final String KEY_COMPETANCE = "competance";
    public static final String KEY_INFO = "info";
    public static final String KEY_LANG = "lang";*/


    //hedhi zedtha me SharedPrefManager
    public static synchronized SessionManager getInstance(Context context){
        if (mInstance==null){
            mInstance=new SessionManager(context);
        }
        return mInstance;
    }

    // Constructor
    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String id, String name, String prenom, String email, String phone, String password, String success
                                   ,String datnaiss,String ville,String codepost,String adresse,String phone2,String site,String linkedin,
                                   String education,String competance,String info,String lang
    ){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_ID, id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_PRENOM, prenom);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PHONE, phone);

        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_GRADE, success);

        editor.putString(KEY_DATNAISS,datnaiss);
        editor.putString(KEY_VILLE,ville);
        editor.putString(KEY_CODEPOST,codepost);
        editor.putString(KEY_ADRESSE,adresse);
        editor.putString(KEY_PHONE2,phone2);
        editor.putString(KEY_SITE,site);
        editor.putString(KEY_LINKEDIN,linkedin);
        editor.putString(KEY_EDUCATION,education);
        editor.putString(KEY_COMPETANCE,competance);
        editor.putString(KEY_INFO,info);
        editor.putString(KEY_LANG,lang);

        // commit changes
        editor.commit();
    }

    /**
     * Create cv session
     * */
   /* public void createCvSession(String id, String iduser , String name, String prenom, String datenaiss,String ville,
                                String codepostale,String phone,String phone2, String email,String site,String linkedin,
                                String education,String competance,String info,String lang){
        // Storing login value as TRUE
        //editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_IDCONGE, id);
        editor.putString(KEY_IDUSER, iduser);
        editor.putString(KEY_NAMECONGE, name);
        editor.putString(KEY_PRENOMCONGE, prenom);
        editor.putString(KEY_DATENAISS, datenaiss);
        editor.putString(KEY_VILLE, ville);
        editor.putString(KEY_CODEPOSTALE, codepostale);
        editor.putString(KEY_EMAILCONGE, email);
        editor.putString(KEY_PHONE1, phone);
        editor.putString(KEY_PHONE2, phone2);
        editor.putString(KEY_SITE, site);
        editor.putString(KEY_LINKEDIN, linkedin);
        editor.putString(KEY_EDUCATION, education);
        editor.putString(KEY_COMPETANCE, competance);
        editor.putString(KEY_INFO, info);
        editor.putString(KEY_LANG, lang);


        // commit changes
        editor.commit();
    }*/

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(context, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Staring Login Activity
            context.startActivity(i);
        }
    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_PRENOM, pref.getString(KEY_PRENOM, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_PHONE, pref.getString(KEY_PHONE, null));
        user.put(KEY_GRADE, pref.getString(KEY_GRADE, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
        user.put(KEY_PHONE2, pref.getString(KEY_PHONE2, null));
        user.put(KEY_LANG, pref.getString(KEY_LANG, null));
        user.put(KEY_INFO, pref.getString(KEY_INFO, null));
        user.put(KEY_COMPETANCE, pref.getString(KEY_COMPETANCE, null));
        user.put(KEY_CODEPOST, pref.getString(KEY_CODEPOST, null));
        user.put(KEY_EDUCATION, pref.getString(KEY_EDUCATION, null));
        user.put(KEY_ADRESSE, pref.getString(KEY_ADRESSE, null));
        user.put(KEY_DATNAISS, pref.getString(KEY_DATNAISS, null));
        user.put(KEY_VILLE, pref.getString(KEY_VILLE, null));
        user.put(KEY_SITE, pref.getString(KEY_SITE, null));
        user.put(KEY_LINKEDIN, pref.getString(KEY_LINKEDIN, null));
        // return user
        return user;
    }

    /**
     * Get stored session data
     * */
   /* public HashMap<String, String> getCvDetails(){
        HashMap<String, String> cv = new HashMap<String, String>();

        cv.put(KEY_IDCONGE, pref.getString(KEY_IDCONGE, null));
        cv.put(KEY_IDUSER, pref.getString(KEY_IDUSER, null));
        cv.put(KEY_NAMECONGE, pref.getString(KEY_NAMECONGE, null));
        cv.put(KEY_PRENOMCONGE, pref.getString(KEY_PRENOMCONGE, null));
        cv.put(KEY_EMAILCONGE, pref.getString(KEY_EMAILCONGE, null));
        cv.put(KEY_PHONE1, pref.getString(KEY_PHONE1, null));
        cv.put(KEY_PHONE2, pref.getString(KEY_PHONE2, null));
        cv.put(KEY_LANG, pref.getString(KEY_LANG, null));
        cv.put(KEY_CODEPOSTALE, pref.getString(KEY_CODEPOSTALE, null));

        // return user
        return cv;
    }*/



    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);

    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }


}


