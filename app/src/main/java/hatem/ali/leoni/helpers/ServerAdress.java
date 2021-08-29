package hatem.ali.leoni.helpers;


/**
 * Created by Jamal Eddine Mahjoub.
 */
public class ServerAdress {
    public static  String url_image="http://192.168.1.4/leoni/images/";
    public static  String baseUrl ="http://192.168.1.4/leoni/";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        ServerAdress.baseUrl = baseUrl;
    }

    public static void setUrl_image(String url_image) {
        ServerAdress.url_image = url_image;
    }

    //String url_cnx="http://192.168.1.16/leoni_backend/";
        //String url_cnx="http://lee.leocontact.tn/";
        //String url_cnx="https://www.msaken-city.com/";

    public static String getUrl_cnx() {
        return url_image;
    }



}