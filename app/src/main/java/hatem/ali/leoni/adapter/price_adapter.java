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
import hatem.ali.leoni.items.Price;

import static hatem.ali.leoni.helpers.ServerAdress.url_image;

public class price_adapter extends RecyclerView.Adapter<price_adapter.MyViewHolder> {

    private Context mContext;
    public List<Price> priceList;

    public price_adapter(Context mContext,List<Price> priceList) {
        this.mContext = mContext;
        this.priceList = priceList;

    }//end constructor


    @Override
    public price_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_price_raw, parent, false);
        return new price_adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull price_adapter.MyViewHolder holder, int position) {

        Price prix = priceList.get(position);
        Glide.with(mContext).load(url_image+prix.getImage_prix()).into(holder.image);
        holder.title.setText(prix.getTitle_prix());
        holder.subtitle.setText(prix.getSubtitle_prix());
        holder.description.setText(prix.getText_prix());
    }

    @Override
    public int getItemCount() {
        int m = priceList.size();
        return m;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView subtitle;
        public TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.price_image);
            title = itemView.findViewById(R.id.price_title);
            subtitle= itemView.findViewById(R.id.price_subtitle);
            description = itemView.findViewById(R.id.price_description);



        }//END Constructor

    }//end class of MyViewHolder
}//end adapter