package hatem.ali.leoni.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;

import hatem.ali.leoni.activities.CvActivity;
import hatem.ali.leoni.activities.ReclamationActivity;
import hatem.ali.leoni.activities.profileActivity;
import hatem.ali.leoni.storage.SessionManager;
import hatem.ali.leoni.R;
import hatem.ali.leoni.activities.CongeActivity;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public CardView card_cv,card_profile,card_conge,card_reclam,card_histo,card_event,card_price,card_stat;
    ImageView fb,yt,in,insta;
    Button logout;

    // Session Manager Class
    SessionManager session;

    public static String FACEBOOK_URL = "https://www.facebook.com/LEONI.tunisia";
    public static String FACEBOOK_PAGE_ID = "LEONI.tunisia";
    public static String YOUTUBE_URL = "https://www.youtube.com/channel/UCWsOpAU5611JldGgbvkAnww";
    public static String YOUTUBE_PAGE_ID = "LEONI TUNISIE";



    public MenuFragment() {
        // Required empty public constructor
    }

    public static MenuFragment newInstance(String param1) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //unpack our data from our bundle
       /* String mail=this.getArguments().getString("mailkey");
        frag_mail.setText(mail);*/

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_menu, container, false);
        // Session class instance
        session = new SessionManager(getActivity());

        card_cv=v.findViewById(R.id.card_cv);
        card_profile=v.findViewById(R.id.card_profile);
        card_histo=v.findViewById(R.id.card_one);
        card_event=v.findViewById(R.id.card_two);
        card_price=v.findViewById(R.id.card_three);
        card_stat=v.findViewById(R.id.card_four);
       // card_conge=v.findViewById(R.id.card_conge);
       // card_reclam=v.findViewById(R.id.card_reclam);

        fb=v.findViewById(R.id.icon_fb);
        yt=v.findViewById(R.id.icon_yt);
        in=v.findViewById(R.id.icon_in);
        insta=v.findViewById(R.id.icon_inst);
        logout =v.findViewById(R.id.logout);

        session.checkLogin();

        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String name = user.get(SessionManager.KEY_NAME);
        String email = user.get(SessionManager.KEY_EMAIL);
        String passwoord = user.get(SessionManager.KEY_PASSWORD);
        String phoone = user.get(SessionManager.KEY_PHONE);

        card_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(), profileActivity.class);

                startActivity(i);
            }
        });

      /*  card_conge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(), CongeActivity.class);

                startActivity(i);
            }
        });*/

        card_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getActivity(), CvActivity.class);
                startActivity(i);
            }
        });

       /* card_reclam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(), ReclamationActivity.class);
                startActivity(i);
            }
        });*/
        card_histo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(v.getContext(),HistoriqueFragment.class);
                v.getContext().startActivity(intent);
                getActivity().finish();*/

                /*Fragment mFragment = new HistoriqueFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame_espaceMembre, mFragment).commit();*/


                // Create new fragment and transaction
                Fragment newFragment = new HistoriqueFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.frame_espaceMembre, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

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

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
                getActivity().finish();

            }
        });


        return v;
    }

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
