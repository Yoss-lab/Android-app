package hatem.ali.leoni.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.adapter.user_adapter;
import hatem.ali.leoni.items.User;
import hatem.ali.leoni.Network.Network.bases.Manages.UsersManager;
import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.R;


public class UserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    user_adapter myadapter;
    List<User> userList = new ArrayList<>();
    // private dataBaseHelper db;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        context = this;
        recyclerView = findViewById(R.id.user_recycler);
        UsersManager.getInstance(this).getAllUser(new RemoteCallback<List<User>>(this) {
            @Override
            public void onSuccess(List<User> response) {
                myadapter = new user_adapter(response,context );
                RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(myLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(myadapter);
            }


            @Override
            public void onUnauthorized() {

            }

            @Override
            public void onFailed(Throwable throwable) {
                Log.d("usersResp", "onFailed: " + throwable.getMessage());
            }
        });
        // db = new dataBaseHelper(UserActivity.this);

       // preparedata();
        //displaydata();

    }

   /* void displaydata(){
        Cursor cursor= (Cursor) db.getAllUser();
        if (cursor.getCount() == 0){
            Toast.makeText(this,"NO DATA ! ",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
               userList.add(new User(cursor.getInt(0),
                       cursor.getString(1),
                       cursor.getString(2),
                       cursor.getString(3)
                       ));
            }
        }
    }*/

   /* void preparedata() {
        User user = new User("1234", "soso", "soso@gmail.com", "pass123");
        userList.add(user);
    }*/
}
