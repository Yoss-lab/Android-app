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
import hatem.ali.leoni.helpers.ServerAdress;
import hatem.ali.leoni.items.History;

public class histo_adapter extends RecyclerView.Adapter<histo_adapter.MyViewHolder> {
    private Context context;
    public List<History> histoList ;
    //String url = "http://192.168.1.3/leoni/images/";

    private String url= ServerAdress.getUrl_cnx();

    public histo_adapter(Context context, List<History> histoList){

      this.context=context;
      this.histoList=histoList;
  }//end constructor


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView= LayoutInflater.from(context).inflate(R.layout.template_histo_raw,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

      History histo=histoList.get(position);
      holder.title.setText(histo.getText_hist());
      holder.year.setText(histo.getAnnee_hist());
      Glide.with(context).load( url+ histo.getImage_hist()).into(holder.image);

        //holder.image.setImageResource(histo.getImage());
        //imageView.setImageResource(mImageIds[index]);

    }

    @Override
    public int getItemCount() {
       int m= histoList.size();
        return m;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView year;
        public ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title_histo);
            year=itemView.findViewById(R.id.year_histo);
            image=itemView.findViewById(R.id.imagehisto);

        }//END Constructor
    }//end class of MyViewHolder
}//end adapter
