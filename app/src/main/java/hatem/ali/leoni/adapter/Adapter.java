package hatem.ali.leoni.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hatem.ali.leoni.R;
import hatem.ali.leoni.items.Conge;
import retrofit2.Response;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<Conge> congeList;
   // private Response<List<Conge>> congesList;
    // ConstraintLayout layoutconge;


    public Adapter(Context mContext, List<Conge> congeList) {
        this.context = mContext;
        this.congeList = congeList;
    }//end constructor

    /*public Adapter(Context context, Response<List<Conge>> response) {
        this.context = context;
        this.congesList = response;
    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView typeconge,causeconge,statutconge,dateDebut,dateFin;
        //public ConstraintLayout layoutconge;


        public MyViewHolder(View itemView) {
            super(itemView);

            typeconge =(TextView) itemView.findViewById(R.id.typconge);
            causeconge = (TextView)itemView.findViewById(R.id.causeconge);
            statutconge =(TextView) itemView.findViewById(R.id.statut);
            dateDebut =(TextView) itemView.findViewById(R.id.datDebut);
            dateFin =(TextView) itemView.findViewById(R.id.datFin);
            //layoutconge=itemView.findViewById(R.id.layoutconge);

        }//END Constructor

    }//end class of MyViewHolder




    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_conge_raw, parent, false);
        return new Adapter.MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {



        final Conge conge = congeList.get(position);
        // Glide.with(mContext).load(event.getImage()).into(holder.image);
        holder.typeconge.setText( conge.getTypeConge());
        holder.causeconge.setText( conge.getCauseConge());
        holder.statutconge.setText( conge.getStatut());
        holder.dateDebut.setText( conge.getDateDebut());
        holder.dateFin.setText( conge.getDateFin());


    }

    @Override
    public int getItemCount() {
        int m = congeList.size();
        return m;
    }





}
