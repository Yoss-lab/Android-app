package hatem.ali.leoni.Network.Network.bases.Manages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static hatem.ali.leoni.helpers.ServerAdress.baseUrl;

public class ApiClient {
   // public static final String baseUrl ="http://192.168.1.3/leoni/";
    public static Retrofit retrofit=null;

    public static Retrofit getApiClient(){
        if(retrofit==null){
            Gson gson=new GsonBuilder().setLenient().create();

            retrofit=new  Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
        return retrofit;
    }
}
