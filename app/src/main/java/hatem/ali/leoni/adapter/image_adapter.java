package hatem.ali.leoni.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import hatem.ali.leoni.R;

import hatem.ali.leoni.items.image;

public class image_adapter extends RecyclerView.Adapter<image_adapter.MyViewHolder> {
    private List<image> imageList;
    private ViewPager2 viewPager2;

    public image_adapter(List<image> imageList, ViewPager2 viewPager2) {
        this.imageList = imageList;
        this.viewPager2 = viewPager2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.slide_image,parent,false
        ));
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setImage(imageList.get(position));

    }

    @Override
    public int getItemCount()
    {
        int m = imageList.size();
        return m;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
         MyViewHolder(@NonNull View itemView) {

             super(itemView);
             imageView=itemView.findViewById(R.id.image_slide);
        }
        void setImage(image image){
             imageView.setImageResource(image.getImage());
        }
    }
}
