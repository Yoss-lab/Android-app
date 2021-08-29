package hatem.ali.leoni.Network.Network.bases.services;

import java.util.List;

import hatem.ali.leoni.items.Conge;
import hatem.ali.leoni.items.Cv;
import hatem.ali.leoni.items.Reclamation;
import hatem.ali.leoni.items.Stage;
import hatem.ali.leoni.items.User;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {


    @GET("get_all_stages.php")
    Call<List<Stage>> getAllStage();



   /* @GET("congeUser.php")
    Call<List<Conge>> congeUser(@Field("id")String id
    );*/

    @FormUrlEncoded
    @POST("loginuser.php")
    Call<User> loginUser(@Field("email")String email,
                         @Field("password")String password
    );

    @FormUrlEncoded
    @POST("registeruser.php")
    Call<User> registerUser(@Field("pseudo")String pseudo,
                            @Field("email")String email,
                            @Field("phone")String phone,
                            @Field("password")String password
    );

    @FormUrlEncoded
    @POST("createcv.php")
    Call<User> createCv(@Field("id")String id,
                      @Field("pseudo")String pseudo,
                      @Field("prenom")String prenom,
                      @Field("datnaiss")String datnaiss,
                      @Field("ville")String ville,
                      @Field("code_post")String code_post,
                      @Field("adresse")String adresse,
                      @Field("phone")String tel,
                      @Field("tel")String phone,
                      @Field("email")String email,
                      @Field("siteWeb")String siteWeb,
                      @Field("linkedIn")String linkedIn,
                      @Field("education")String education,
                      @Field("competence")String competence,
                      @Field("informatique")String informatique,
                      @Field("langue")String langue
    );

    @FormUrlEncoded
    @POST("updateProfile.php")
    Call<User> updateProfile(@Field("id")String id,
                             @Field("email")String email,
                        @Field("password")String password


    );

    @FormUrlEncoded
    @POST("createconge.php")
    Call<Conge> createConge(@Field("idUser")String iduser,
                            @Field("nomUser")String nom,
                            @Field("prenomUser")String prenom,
                            @Field("typeConge")String typeConge,
                            @Field("dateDebut")String dateDebut,
                            @Field("dateFin")String dateFin,
                            @Field("causeConge")String causeConge
    );

    @FormUrlEncoded
    @POST("createReclamation.php")
    Call<Reclamation> createReclamation(
                            @Field("commentaire")String commentaire
    );

    @FormUrlEncoded
    @POST("congeUser.php")
    Call<List<Conge>> congeUser(@Field("idUser")String idUser
    );



   /* @GET("posts/{id}/comments")
    Call<List<Conge>> getConge(@Path("idUser") int idUser);*/

}
