package hatem.ali.leoni.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import hatem.ali.leoni.R;
import hatem.ali.leoni.items.Emploi;

import static hatem.ali.leoni.helpers.ServerAdress.url_image;

public class emploi_adapter extends RecyclerView.Adapter<emploi_adapter.MyViewHolder> {

    String date[],title[],text[],place[];
    int image[];
    private Context mContext;
    private List<Emploi> emploiList;
    ConstraintLayout layoutemploi;


    public emploi_adapter(Context mContext, List<Emploi> emploiList) {
        this.mContext = mContext;
        this.emploiList = emploiList;
    }//end constructor


    @Override
    public emploi_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_emploi_raw, parent, false);
        return new emploi_adapter.MyViewHolder(itemView);

    }



    @Override
    public void onBindViewHolder(@NonNull emploi_adapter.MyViewHolder holder, final int position) {



        final Emploi emploi = emploiList.get(position);
         Glide.with(mContext).load(url_image +emploi.getImage_emploi()).into(holder.image);
        holder.title.setText( emploi.getTitle_emploi());
         holder.date.setText( emploi.getDat());
        holder.description.setText( emploi.getDesc_emploi());
        holder.by.setText( emploi.getAnnonce_de());



    }

    @Override
    public int getItemCount() {
        int m = emploiList.size();
        return m;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title,by,description,date;
        //public ConstraintLayout layoutemploi;


        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image_emploi);
            title =(TextView) itemView.findViewById(R.id.title_emploi);
            date = (TextView)itemView.findViewById(R.id.date_emploi);
            by =(TextView) itemView.findViewById(R.id.by_emploi);
            description =(TextView) itemView.findViewById(R.id.desc_emploi);
            //layoutemploi=itemView.findViewById(R.id.layoutemploi);

        }//END Constructor

    }//end class of MyViewHolder

}
