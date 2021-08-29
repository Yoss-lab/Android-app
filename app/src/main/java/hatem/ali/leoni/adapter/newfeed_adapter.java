package hatem.ali.leoni.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import hatem.ali.leoni.R;
import hatem.ali.leoni.items.Newfeed;

import static hatem.ali.leoni.helpers.ServerAdress.url_image;


public class newfeed_adapter  extends RecyclerView.Adapter<newfeed_adapter.MyViewHolder> {

    private Context mContext;
    public List<Newfeed> newfeedList;

   /* Urlimage urlimage;
    String url=urlimage.url;*/
   //String url = "http://192.168.1.3/leoni/images/";


    public newfeed_adapter(Context mContext, List<Newfeed> newfeedList) {
        this.mContext = mContext;
        this.newfeedList = newfeedList;
    }//end constructor



    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_newfeed_raw, parent, false);
        return new newfeed_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        Newfeed newfeed = newfeedList.get(position);
        Glide.with(mContext).load( url_image+ newfeed.getImage()).into(holder.image);
        //Picasso.get().load(newfeed.getImage()).into(holder.image);
        //Glide.with(mContext).load(newfeed.getImage()).into(holder.image);
        holder.text.setText(newfeed.getText_act());
        holder.date.setText(newfeed.getDat());
       // holder.image.setImageURI(url2 + newfeed.getImage());

    }

    @Override
    public int getItemCount() {
        int m = newfeedList.size();
        return m;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text,date;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.newfeed_image);
            text = itemView.findViewById(R.id.newfeed_text);
            date = itemView.findViewById(R.id.newfedd_date);

        }
    }
}
