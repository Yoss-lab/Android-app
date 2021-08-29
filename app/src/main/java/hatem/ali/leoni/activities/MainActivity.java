package hatem.ali.leoni.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.HashMap;

import hatem.ali.leoni.R;
import hatem.ali.leoni.storage.SessionManager;

public class MainActivity extends AppCompatActivity {
    TextView varSuccess;

    //declaration area start

    SessionManager session;
    ImageView logo, car, imageView_Slogan, imageView_Contact, bg, bg2, fb, in, yt, imageView_slogan2, inst;

    Animation fade_in_logo, translate_y, translate_x, fade_in_slogan, translate_y_2, fade_out, fade_in_btn,
            translate_y_3;
    Button userspace, about, workerspace;
    YouTubePlayerView youTubePlayerView;
    View vh1, vh2, vh3, vh4, vv1, vv2, vv3;
    TextView lc, lc2;
    public static String FACEBOOK_URL = "https://www.facebook.com/LEONI.tunisia";
    public static String FACEBOOK_PAGE_ID = "LEONI.tunisia";
    public static String YOUTUBE_URL = "https://www.youtube.com/channel/UCWsOpAU5611JldGgbvkAnww";
    public static String YOUTUBE_PAGE_ID = "LEONI TUNISIE";

    //declaration area end

    //onCreate start

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Session Manager

        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        // get user data from session
        final HashMap<String, String> user = session.getUserDetails();
         final String grade = user.get(SessionManager.KEY_GRADE);
        String name = user.get(SessionManager.KEY_NAME);
       // varSuccess=findViewById(R.id.varSuccess);
       // varSuccess.setText(success);


        Log.d("valsucess", "valeur de success "+name+"***");
        Log.d("valsuccess", "valeur de success "+grade+"***");

        //accedé a la base de donnée à travers le navigateur
        Stetho.initializeWithDefaults(this);

        //Video player start
        final YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.setVisibility(View.GONE);
        //Video player end


        // animation start
        logo = findViewById(R.id.imageView_logo);
        car = findViewById(R.id.imageView_Car);
        bg = findViewById(R.id.imageView_bg);
        bg2 = findViewById(R.id.imageView_bg2);
        fb = findViewById(R.id.icon_fb);
        in = findViewById(R.id.icon_in);
        yt = findViewById(R.id.icon_yt);
        inst = findViewById(R.id.icon_inst);
        imageView_Slogan = findViewById(R.id.imageView_Slogan);
        imageView_slogan2 = findViewById(R.id.imageView_slogan2);
        imageView_Contact = findViewById(R.id.imageView_Contact);

        //button
        userspace = findViewById(R.id.userspace);
        about = findViewById(R.id.about);
        workerspace = findViewById(R.id.workerspace);
        //view
        vh1 = findViewById(R.id.view_horizontal_1);
        vh1.setVisibility(View.GONE);
        vh2 = findViewById(R.id.view_horizontal_2);
        vh2.setVisibility(View.GONE);
        vh3 = findViewById(R.id.view_horizontal_3);
        vh3.setVisibility(View.GONE);
        vh4 = findViewById(R.id.view_horizontal_4);
        vh4.setVisibility(View.GONE);
        vv1 = findViewById(R.id.view_vertical_1);
        vv1.setVisibility(View.GONE);
        vv2 = findViewById(R.id.view_vertical_2);
        vv2.setVisibility(View.GONE);
        vv3 = findViewById(R.id.view_vertical_3);
        vv3.setVisibility(View.GONE);

        lc = findViewById(R.id.leoni);
        lc2 = findViewById(R.id.corporate);
        lc.setVisibility(View.GONE);
        lc2.setVisibility(View.GONE);
        fade_in_logo = AnimationUtils.loadAnimation(this, R.anim.fade_in_enter);
        fade_in_slogan = AnimationUtils.loadAnimation(this, R.anim.fade_in_enter);
        fade_in_btn = AnimationUtils.loadAnimation(this, R.anim.fade_in_enter);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.fade_out_exit_fast);
        translate_y = AnimationUtils.loadAnimation(this, R.anim.translatey);
        translate_y_2 = AnimationUtils.loadAnimation(this, R.anim.translatey2);
        translate_y_3 = AnimationUtils.loadAnimation(this, R.anim.translatey3);
        translate_x = AnimationUtils.loadAnimation(this, R.anim.translatex);
        fb.setVisibility(View.GONE);
        in.setVisibility(View.GONE);
        yt.setVisibility(View.GONE);
        inst.setVisibility(View.GONE);
        imageView_Slogan.setVisibility(View.GONE);
        imageView_slogan2.setVisibility(View.GONE);
        imageView_Contact.setVisibility(View.GONE);
        workerspace.setVisibility(View.GONE);
        about.setVisibility(View.GONE);
        userspace.setVisibility(View.GONE);
        logo.startAnimation(fade_in_logo);

        fade_in_logo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.startAnimation(translate_y);
                car.startAnimation(translate_x);
            }
        });
        translate_x.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView_Slogan.setVisibility(View.VISIBLE);
                imageView_Slogan.startAnimation(fade_in_slogan);
                imageView_Contact.setVisibility(View.VISIBLE);
                imageView_Contact.startAnimation(fade_in_slogan);
            }
        });
        fade_in_slogan.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fade_out.reset();
                car.clearAnimation();
                imageView_Contact.clearAnimation();
                imageView_Slogan.clearAnimation();
                car.startAnimation(fade_out);
                imageView_Slogan.startAnimation(fade_out);
                imageView_Contact.startAnimation(fade_out);


            }
        });
        fade_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bg.startAnimation(translate_y_2);

                bg2.startAnimation(translate_y_3);
                car.setVisibility(View.GONE);
                imageView_Slogan.setVisibility(View.GONE);
                imageView_Contact.setVisibility(View.GONE);


            }
        });
        translate_y_2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                userspace.setVisibility(View.VISIBLE);

                about.setVisibility(View.VISIBLE);
                workerspace.setVisibility(View.VISIBLE);
                fb.setVisibility(View.VISIBLE);
                in.setVisibility(View.VISIBLE);
                yt.setVisibility(View.VISIBLE);
                inst.setVisibility(View.VISIBLE);
                youTubePlayerView.setVisibility(View.VISIBLE);
                userspace.startAnimation(fade_in_btn);
                about.startAnimation(fade_in_btn);
                workerspace.startAnimation(fade_in_btn);
                youTubePlayerView.startAnimation(fade_in_btn);
                fb.startAnimation(fade_in_btn);
                in.startAnimation(fade_in_btn);
                yt.startAnimation(fade_in_btn);
                inst.startAnimation(fade_in_btn);
                vh1.setVisibility(View.VISIBLE);
                vh2.setVisibility(View.VISIBLE);
                vh3.setVisibility(View.VISIBLE);
                vh4.setVisibility(View.VISIBLE);
                vv1.setVisibility(View.VISIBLE);
                vv2.setVisibility(View.VISIBLE);
                vv3.setVisibility(View.VISIBLE);
                vh1.startAnimation(fade_in_btn);
                vh2.startAnimation(fade_in_btn);
                vh3.startAnimation(fade_in_btn);
                vh4.startAnimation(fade_in_btn);
                vv1.startAnimation(fade_in_btn);
                vv2.startAnimation(fade_in_btn);
                vv3.startAnimation(fade_in_btn);
                imageView_slogan2.setVisibility(View.VISIBLE);
                imageView_slogan2.startAnimation(fade_in_btn);
                //lc.setVisibility(View.VISIBLE);
                lc.startAnimation(fade_in_btn);
                //lc2.setVisibility(View.VISIBLE);
                lc2.startAnimation(fade_in_btn);
            }
        });
        // animation end

        // Buttons action start

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, aboutLeoniActivity.class);
                startActivity(intent);
            }
        });

        workerspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (session.isLoggedIn() && grade.equals("visitor")){
                    Intent intent = new Intent(MainActivity.this, EspacemembreActivity.class);
                    startActivity(intent);
                }
                else if (session.isLoggedIn() && grade.equals("employe") ){
                    Intent intent = new Intent(MainActivity.this, EspaceemployeActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        userspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, actualite_Activity.class);
                startActivity(intent);
            }
        });


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(getApplicationContext());
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);


            }
        });

        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent youtubeIntent = new Intent(Intent.ACTION_VIEW);
                String youtubeUrl = getYoutubePageURL(getApplicationContext());
                youtubeIntent.setData(Uri.parse(youtubeUrl));
                startActivity(youtubeIntent);

            }
        });
        // Buttons action end
    }
    //onCreate end


    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    public String getYoutubePageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();

        try {
            int versionCode = packageManager.getPackageInfo("com.youtube.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "yt://facewebmodal/f?href=" + YOUTUBE_URL;
            } else { //older versions of fb app
                return "yt://page/" + YOUTUBE_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return YOUTUBE_URL; //normal web url
        }

    }
}