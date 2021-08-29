package hatem.ali.leoni.Network.Network.bases.Manages;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static hatem.ali.leoni.helpers.ServerAdress.baseUrl;

public class ApiConge {

    //private static final String BASE_URL = "http://192.168.43.247/demo_pets/";
    private static Retrofit retrofit;

    public static Retrofit getApiConge(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
