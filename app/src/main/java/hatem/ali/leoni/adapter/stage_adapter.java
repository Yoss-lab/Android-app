package hatem.ali.leoni.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import hatem.ali.leoni.R;
import hatem.ali.leoni.items.Stage;

public class stage_adapter extends RecyclerView.Adapter<stage_adapter.MyViewHolder> implements Filterable   {

    List<Stage> stages, stagesFilter;
    private Context context;
    private RecyclerViewClickListener mListener;
    stageFilter filter;

    public stage_adapter(List<Stage> stages, Context context, RecyclerViewClickListener listener) {
        this.stages = stages;
        this.stagesFilter = stages;
        this.context = context;
        this.mListener = listener;
    }//end constructor

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_stage_raw, parent, false);
        return new MyViewHolder(itemView, mListener);

    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        //final Stage stage = stageList.get(position);
        holder.title.setText(stages.get(position).getTitle_stage());
        holder.description.setText(stages.get(position).getDesc_stage());
        holder.by.setText(stages.get(position).getAnnonce_de());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.skipMemoryCache(true);
        requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE);
        requestOptions.placeholder(R.drawable.logo);
        requestOptions.error(R.drawable.logo);

        Glide.with(context)
                .load(stages.get(position).getImage_stage())
                .apply(requestOptions)
                .into(holder.image);

        // Glide.with(mContext).load(event.getImage()).into(holder.image);
        // holder.title.setText( stage.getTitle_stage());
        // holder.date.setText( event.getDate());
        //holder.description.setText( stage.getDesc_stage());
        //holder.by.setText( stage.getAnnonce_de());


    }

    @Override
    public int getItemCount() {
        int m = stages.size();
        return m;
    }


    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new stageFilter((ArrayList<Stage>) stagesFilter, (Adapter) stage_adapter.this);

        }
        return filter;
    }




    public class MyViewHolder extends hatem.ali.leoni.adapter.MyViewHolder {
        private RecyclerViewClickListener mListener;
        private ImageView image;
        private TextView title, by, description;
        private LinearLayout mlayoutstage;

        public MyViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            //image = (ImageView) itemView.findViewById(R.id.event_image);
            title = (TextView) itemView.findViewById(R.id.tittle_stage);
            // date = (TextView)itemView.findViewById(R.id.event_date);
            by = (TextView) itemView.findViewById(R.id.by);
            description = (TextView) itemView.findViewById(R.id.desc_stage);
            mlayoutstage = itemView.findViewById(R.id.layoutstage);

            mListener = listener;
            mlayoutstage.setOnClickListener((View.OnClickListener) this);
            //mLove.setOnClickListener(this);

         /*   itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if (mListener != null){
                       int position=getAdapterPosition();
                       if (position!=RecyclerView.NO_POSITION){
                           mListener.onItemClick(position);
                       }
                   }
                }
            });*/

        }//END Constructor




        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.layoutstage:
                    mListener.onRowClick(mlayoutstage, getAdapterPosition());
                    break;
           /* case R.id.love:
                mListener.onLoveClick(mLove, getAdapterPosition());
                break;*/
                default:
                    break;
            }
        }


    }



     public interface RecyclerViewClickListener {
        void onRowClick(View view, int position);
        //void onLoveClick(View view, int position);
    }



}//end adapter
