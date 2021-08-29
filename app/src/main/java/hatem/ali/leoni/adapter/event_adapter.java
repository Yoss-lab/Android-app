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
import hatem.ali.leoni.items.Event;

import static hatem.ali.leoni.helpers.ServerAdress.url_image;

public class event_adapter extends RecyclerView.Adapter<event_adapter.MyViewHolder> {

    String date[],title[],text[],place[];
    int image[];

    private Context context;
    private List<Event> eventList;
    ConstraintLayout layoutevent;


    public event_adapter(Context mContext, List<Event> eventList) {
        this.context = mContext;
        this.eventList = eventList;
    }//end constructor

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title,date,place,description;
        public ConstraintLayout layoutevent;


        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.event_image);
            title =(TextView) itemView.findViewById(R.id.event_title);
           // date = (TextView)itemView.findViewById(R.id.event_date);
           // place =(TextView) itemView.findViewById(R.id.event_place);
            description =(TextView) itemView.findViewById(R.id.event_description);
            layoutevent=itemView.findViewById(R.id.layoutevent);

        }//END Constructor

    }//end class of MyViewHolder




    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_event_raw, parent, false);
        return new event_adapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {



        final Event event = eventList.get(position);
        Glide.with(context).load(url_image+event.getImage_event()).into(holder.image);
        holder.title.setText( event.getTitle_event());
       // holder.date.setText( event.getDate());
        //holder.place.setText( event.getPlace());
        holder.description.setText( event.getText_event());


    }

    @Override
    public int getItemCount() {
        int m = eventList.size();
        return m;
    }




}//end adapter

