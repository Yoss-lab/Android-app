package hatem.ali.leoni.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

abstract class MyViewHolder extends RecyclerView.ViewHolder {
    public MyViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onClick(View v);
}
