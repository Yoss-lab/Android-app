package hatem.ali.leoni.Network.Network.bases;

import android.app.Activity;

import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public abstract class RemoteCallback<T> implements Callback<T> {
    Activity context;

    public RemoteCallback(Activity context) {
        this.context = context;
    }

    public RemoteCallback() {

    }


    @Override
    public final void onResponse(Call<T> call, Response<T> response) {

        switch (response.code()) {
            case HttpsURLConnection.HTTP_OK:
            case HttpsURLConnection.HTTP_CREATED:
            case HttpsURLConnection.HTTP_ACCEPTED:
            case HttpsURLConnection.HTTP_NOT_AUTHORITATIVE:

                onSuccess(response.body());
                break;

            case HttpURLConnection.HTTP_UNAUTHORIZED:
                onUnauthorized();
                break;
            default:
                dismissAlertDialog();
                onFailed(new Throwable("Default " + response.code() + " " + response.message()));

        }
    }

    @Override
    public final void onFailure(Call<T> call, Throwable t) {
        dismissAlertDialog();
        onFailed(t);

    }


    public abstract void onSuccess(T response);

    public abstract void onUnauthorized();

    public abstract void onFailed(Throwable throwable);


    void dismissAlertDialog()
    {
    }
}