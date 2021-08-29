package hatem.ali.leoni.Network.Network.bases.Manages;

import android.content.Context;

import java.util.HashMap;
import java.util.List;

import hatem.ali.leoni.Network.Network.bases.RemoteCallback;
import hatem.ali.leoni.Network.Network.bases.ServiceFactory;
import hatem.ali.leoni.Network.Network.bases.services.UserServices;
import hatem.ali.leoni.items.Conge;
import hatem.ali.leoni.items.Emploi;
import hatem.ali.leoni.items.Event;
import hatem.ali.leoni.items.History;
import hatem.ali.leoni.items.Newfeed;
import hatem.ali.leoni.items.Price;
import hatem.ali.leoni.items.Stage;
import hatem.ali.leoni.items.User;
import hatem.ali.leoni.storage.SessionManager;

import static com.facebook.FacebookSdk.getApplicationContext;
import static hatem.ali.leoni.helpers.ServerAdress.baseUrl;

public class UsersManager {

    //String baseUrl;
    private static UsersManager instance;
    private UserServices userServices;
User user;
    Context context;

    public UsersManager(Context context) {
        this.context = context;
        //baseUrl ="http://192.168.1.3/leoni/";
        userServices = new ServiceFactory<>(UserServices.class, baseUrl).makeService();



    }

    public static UsersManager getInstance(Context context) {
        if (instance == null)
            instance = new UsersManager(context);
        return instance;
    }

   /* public void congeUser( RemoteCallback<List<Conge>> conges) {
        userServices.congeUser().enqueue(conges);
    }*/


    public void getAllUser( RemoteCallback<List<User>> users) {
        userServices.getAllUser().enqueue(users);
    }

    public void getAllAct( RemoteCallback<List<Newfeed>> acts) {
        userServices.getAllAct().enqueue(acts);
    }

    public void getAllHistory( RemoteCallback<List<History>> historys) {
        userServices.getAllHistory().enqueue(historys);
    }

    public Event[] getAllEvent(RemoteCallback<List<Event>> events) {
        userServices.getAllEvent().enqueue(events);
        return new Event[0];
    }



    public void getAllPrice( RemoteCallback<List<Price>> prices) {
        userServices.getAllPrice().enqueue(prices);
    }

   /* public void getAllStage(RemoteCallback<List<Stage>> stages) {
        userServices.getAllStage().enqueue(stages);
    }*/

    public void getAllEmploi( RemoteCallback<List<Emploi>> emplois) {
        userServices.getAllEmploi().enqueue(emplois);
    }

    public User getUser(){
        return user;
    }
    

    public void insert(User user, RemoteCallback<Boolean> response) {
        userServices.insert(user).enqueue(response);
    }


}