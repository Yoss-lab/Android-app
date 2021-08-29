package hatem.ali.leoni.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import hatem.ali.leoni.R;
import hatem.ali.leoni.fragments.ActualiteemployeFragment;
import hatem.ali.leoni.fragments.EmploiFragment;
import hatem.ali.leoni.fragments.MenuemployeFragment;
import hatem.ali.leoni.fragments.StageFragment;

public class EspaceemployeActivity extends AppCompatActivity {

    TextView id,name,mail,phone;
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espaceemploye);


       toolbar= getSupportActionBar();
       toolbar.setDisplayHomeAsUpEnabled(true);

        //id=findViewById(R.id.memberid);
        // name=findViewById(R.id.membername);
        // mail=findViewById(R.id.membermail);
        // phone=findViewById(R.id.memberphone);

      /*  Intent intent = getIntent();
        String cid = intent.getStringExtra("id");
        String cmail = intent.getStringExtra("mail");
        id.setText(cid);
        mail.setText(cmail);*/



        BottomNavigationView navigation = findViewById(R.id.navigation_space);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        // load fragment by default
        toolbar.setTitle("Actualité");
        navigation.setSelectedItemId(R.id.navigationAct);
        loadFragment(new ActualiteemployeFragment());



    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigationAct:
                    toolbar.setTitle("Actualité");
                    fragment=new ActualiteemployeFragment();
                    loadFragment(fragment);

                    return true;

                case R.id.navigationEmploi:
                    toolbar.setTitle("offres d'emplois");
                    fragment=new EmploiFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigationStage:
                    toolbar.setTitle("offres de stages");
                    fragment=new StageFragment();
                    loadFragment(fragment);
                    return true;
                case  R.id.navigationMenu:
                    toolbar.setTitle("Menu");
                    fragment=new MenuemployeFragment();
                    loadFragment(fragment);
                    return true;


            }
            return false;
        }
    };




    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_espaceEmploye, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
