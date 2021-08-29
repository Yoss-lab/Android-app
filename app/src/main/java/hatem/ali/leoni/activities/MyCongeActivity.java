package hatem.ali.leoni.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hatem.ali.leoni.Network.Network.bases.Manages.ApiClient;
import hatem.ali.leoni.Network.Network.bases.Manages.ApiConge;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.Network.Network.bases.ServiceFactory;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterface;
import hatem.ali.leoni.Network.Network.bases.services.ApiInterfaceConge;
import hatem.ali.leoni.Network.Network.bases.services.UserServices;
import hatem.ali.leoni.R;
import hatem.ali.leoni.adapter.Adapter;
import hatem.ali.leoni.adapter.newfeed_adapter;
import hatem.ali.leoni.items.Conge;
import hatem.ali.leoni.items.Newfeed;
import hatem.ali.leoni.items.Stage;
import hatem.ali.leoni.storage.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static hatem.ali.leoni.helpers.ServerAdress.baseUrl;

public class MyCongeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    List<Conge> congeList =new ArrayList<>();
    Context context;
    // Session Manager Class
    SessionManager session;
    public TextView iddUser;
     ApiInterfaceConge apiInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_conge);

        iddUser=findViewById(R.id.idd);
        context=this;
        recyclerView=findViewById(R.id.conge_recycler);
       // layoutManager = new LinearLayoutManager(this);
       // recyclerView.setLayoutManager(layoutManager);

        // Session class instance
        session = new SessionManager(getApplicationContext());
        session.checkLogin();
        // get user data from session
        HashMap<String, String> user = session.getUserDetails();

        String iduser=user.get(SessionManager.KEY_ID);
        // displaying user data
        iddUser.setText(iduser);



        apiInterface = ApiConge.getApiConge().create(ApiInterfaceConge.class);

        Call<List<Conge>> call = apiInterface.getConge(
                iddUser.getText().toString()       );
        call.enqueue(new RemoteCallback<List<Conge>>() {


            @Override
            public void onSuccess(List<Conge> response) {
                adapter=new Adapter(context,response);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onUnauthorized() {

            }

            @Override
            public void onFailed(Throwable throwable) {

            }
        });








       // userServices = new ServiceFactory<>(UserServices.class, baseUrl).makeService();
       // UsersManager.getInstance(this).userServices.congeUser().enqueue(RemoteCallback<List<Conge>> conges){

       // UsersManager.getInstance(this).congeUser(new RemoteCallback<List<Conge>>(this) {
         /*   @Override
            public void onSuccess(List<Conge> response) {
                adapter=new Adapter(context,response);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(adapter);
            }
            @Override

            public void onUnauthorized() {
            }
            @Override
            public void onFailed(Throwable throwable) {
            }
        });*/

        /*Call<List<Conge>> call = apiInterface.congeUser(idd.getText().toString());
        call.enqueue(new Callback<List<Conge>>() {
                         @Override
                         public void onResponse(Call<List<Conge>> call, Response<List<Conge>> response) {

                             adapter=new Adapter(context,response);

                             RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                             recyclerView.setLayoutManager(myLayoutManager);
                             recyclerView.setItemAnimator(new DefaultItemAnimator());
                             recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
                             recyclerView.setAdapter(adapter);

                         }

                         @Override
                         public void onFailure(Call<List<Conge>> call, Throwable t) {

                         }
                     });*/









      /*  listener = new Adapter.RecyclerViewClickListener() {
            @Override
            public void onRowClick(View view, final int position) {

                Intent intent = new Intent(MyCongeActivity.this, AfficheCongeActivity.class);
                intent.putExtra("type", congesList.get(position).getTypeConge());
                intent.putExtra("cause", congesList.get(position).getCauseConge());
                intent.putExtra("statut", congesList.get(position).getStatut());
                intent.putExtra("datD", congesList.get(position).getDateDebut());
                intent.putExtra("datF", congesList.get(position).getDateFin());
                startActivity(intent);

            }



           /* @Override
            public void onLoveClick(View view, int position) {

                final int id = petsList.get(position).getId();
                final Boolean love = petsList.get(position).getLove();
                final ImageView mLove = view.findViewById(R.id.love);

                if (love){
                    mLove.setImageResource(R.drawable.likeof);
                    petsList.get(position).setLove(false);
                    updateLove("update_love", id, false);
                    adapter.notifyDataSetChanged();
                } else {
                    mLove.setImageResource(R.drawable.likeon);
                    petsList.get(position).setLove(true);
                    updateLove("update_love", id, true);
                    adapter.notifyDataSetChanged();
                }

            }*/
       /* };*/


        /*Call<List<Conge>> call = apiInterface.congeUser(
                idd.getText().toString() );
        call.enqueue(new Callback<List<Conge>>() {
            @Override
            public void onResponse(Call<List<Conge>> call, Response<List<Conge>> response) {
                //progressBar.setVisibility(View.GONE);
                congeList = response.body();
                Log.i(MainActivity.class.getSimpleName(), response.body().toString());
                adapter = new Adapter(MyCongeActivity.this,congeList);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));


                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Conge>> call, Throwable t) {
                Toast.makeText(MyCongeActivity.this, "rp :"+
                                t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }//end onCreate

    /*
       myadapter=new Adapter(context,response);

                                  RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                                  recyclerView.setLayoutManager(myLayoutManager);
                                  recyclerView.setItemAnimator(new DefaultItemAnimator());
                                  recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));
                                  recyclerView.setAdapter(myadapter);
    * */

  /*  public void getConges(){

        Call<List<Conge>> call = apiInterface.congeUser();
        call.enqueue(new Callback<List<Conge>>() {
            @Override
            public void onResponse(Call<List<Conge>> call, Response<List<Conge>> response) {
                //progressBar.setVisibility(View.GONE);
                congesList = response.body();
                Log.i(MainActivity.class.getSimpleName(), response.body().toString());
                adapter = new Adapter(congesList, MyCongeActivity.this, listener);

                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL));


                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Conge>> call, Throwable t) {
                Toast.makeText(MyCongeActivity.this, "rp :"+
                                t.getMessage().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }*/



}
