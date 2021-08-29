package hatem.ali.leoni.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import hatem.ali.leoni.R;
import hatem.ali.leoni.fragments.EvenementFragment;
import hatem.ali.leoni.fragments.HistoriqueFragment;
import hatem.ali.leoni.fragments.PrixFragment;
import hatem.ali.leoni.fragments.StatistiqueFragment;


public class aboutLeoniActivity extends AppCompatActivity /*implements View.OnClickListener*/ {
    private ActionBar toolbar;


    // CardView card_one,card_two,card_three,card_four;

    FloatingActionButton fab, fab1, fab2;
    LinearLayout fabLayout1,fabLayout2;
    View fabBGLayout;
    boolean isFABOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_leoni);

        toolbar= getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);

        // load fragment by default
        //toolbar.setTitle("Historique");
        //loadFragment(new HistoriqueFragment());


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(R.id.navigationHome);
        toolbar.setTitle("Home");

      //  CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
       // layoutParams.setBehavior(new BottomNavigationBehavior());




/*
        card_one=findViewById(R.id.card_one);
        card_two=findViewById(R.id.card_two);
        card_three=findViewById(R.id.card_three);
        card_four=findViewById(R.id.card_four);
        //card_five=findViewById(R.id.card_five);

        card_one.setOnClickListener(this);
        card_two.setOnClickListener(this);
        card_three.setOnClickListener(this);
        card_four.setOnClickListener(this);
        //card_five.setOnClickListener(this);
*/

        fabLayout1 = (LinearLayout) findViewById(R.id.fabLayout1);
        fabLayout2 = (LinearLayout) findViewById(R.id.fabLayout2);
        //fabLayout3 = (LinearLayout) findViewById(R.id.fabLayout3);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        //fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fabBGLayout = findViewById(R.id.fabBGLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aboutLeoniActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aboutLeoniActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        //add fragment to this activity



    }//end onCreate()



   // @Override
  /*  public void onClick(View view) {

        Intent i;
        switch (view.getId()){
            case R.id.card_one:i=new Intent(this,historique.class);startActivity(i);break;
            case R.id.card_two:i=new Intent(this, EvenementActivity.class);startActivity(i);break;
            case R.id.card_three:i=new Intent(this, PrixActivity.class);startActivity(i);break;
            case R.id.card_four:i=new Intent(this, ActivityStatistique.class);startActivity(i);break;
            //case R.id.card_five:i=new Intent(this,ActivityStatistique.class);startActivity(i);break;

        }


    }
*/
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    private void showFABMenu() {
        isFABOpen = true;
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        //fabLayout3.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);
        //fab.animate().rotationBy(180);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        // fabLayout3.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabBGLayout.setVisibility(View.GONE);
        //fab.animate().rotation(0);
        fabLayout1.animate().translationY(0);
        fabLayout2.animate().translationY(0);
        // fabLayout3.animate().translationY(0);

        fabLayout2.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!isFABOpen) {
                    fabLayout1.setVisibility(View.GONE);
                    fabLayout2.setVisibility(View.GONE);
                    // fabLayout3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isFABOpen) {
            closeFABMenu();
        } else {
            super.onBackPressed();
        }
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigationHisto:
                    toolbar.setTitle("Historique");
                    fragment=new HistoriqueFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigationEvent:
                    toolbar.setTitle("Evenement");
                    fragment=new EvenementFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigationHome:
                    toolbar.setTitle("HOME" );

                    return true;
                case  R.id.navigationPrice:
                    toolbar.setTitle("Prix");
                    fragment=new PrixFragment();
                    loadFragment(fragment);
                    return true;
                case  R.id.navigationStatic:
                    toolbar.setTitle("Statistique");
                    fragment= new StatistiqueFragment();
                    loadFragment(fragment);
                    return true;


            }
            return false;
        }
    };


    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
