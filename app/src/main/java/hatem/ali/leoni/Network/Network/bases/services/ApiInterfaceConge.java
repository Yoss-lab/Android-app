package hatem.ali.leoni.Network.Network.bases.services;

import java.util.List;

import hatem.ali.leoni.items.Conge;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterfaceConge {

    @FormUrlEncoded
    @POST("congeUser.php")
    Call<List<Conge>> getConge(@Field("idUser")String idUser);

}
