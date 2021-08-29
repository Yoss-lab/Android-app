package hatem.ali.leoni.Network.Network.bases.services;

import java.util.List;

import hatem.ali.leoni.items.Conge;
import hatem.ali.leoni.items.Emploi;
import hatem.ali.leoni.items.Event;
import hatem.ali.leoni.items.History;
import hatem.ali.leoni.items.Newfeed;
import hatem.ali.leoni.items.Price;
import hatem.ali.leoni.items.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserServices {

    @GET("get_all_users.php")
    Call<List<User>> getAllUser();

    @GET("get_all_act.php")
    Call<List<Newfeed>> getAllAct();


    @GET("get_all_history.php")
    Call<List<History>> getAllHistory();

    @GET("get_all_event.php")
    Call<List<Event>> getAllEvent();


    @GET("get_all_price.php")
    Call<List<Price>> getAllPrice();



    @GET("get_all_emplois.php")
    Call<List<Emploi>> getAllEmploi();


  /*   @GET("congeUser.php")
    Call<List<Conge>> congeUser(@Field("idUser")String id
    );*/


   /* @POST("loginuser.php")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("login.php")
    Call<JsonObject> studentLogin(@Query("email") String email,
                                  @Query("password") String password);

    @GET("loginuser.php")
    Call<User> getUser(@Path("email") String email);*/

   /* @FormUrlEncoded
    @POST("loginuser.php")
    Call<String> getUserLogin(

            @Field("email") String email,
            @Field("password") String password
    );*/






    // for register user
    @POST("create_user.php")
    Call<Boolean> insert(@Body User user);
}
