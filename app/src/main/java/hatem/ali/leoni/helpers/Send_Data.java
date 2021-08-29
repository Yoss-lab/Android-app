package hatem.ali.leoni.helpers;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Send_Data extends StringRequest{

    private static final String SEND_DATA_URL="http://127.0.0.1/leoni/register.php";
    private Map<String,String> MapData;

    public Send_Data(String pseudo, String email, String password, Response.Listener<String> listener) {
        super(Method.POST, SEND_DATA_URL, listener ,null);
        MapData=new HashMap<>();
        MapData.put("pseudo",pseudo);
        MapData.put("email",email);
        MapData.put("password",password);
    }

    @Override
    public Map<String,String> getParams(){
        return MapData;
    }


}
