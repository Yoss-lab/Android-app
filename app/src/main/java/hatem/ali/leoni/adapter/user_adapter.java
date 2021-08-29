package hatem.ali.leoni.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hatem.ali.leoni.R;
import hatem.ali.leoni.items.User;

public class user_adapter extends RecyclerView.Adapter<user_adapter.UserViewHolder> {

    private Context mContext;
    private List<User> listUsers;


    public user_adapter(List<User> listUsers, Context mContext) {
        this.listUsers = listUsers;
        this.mContext = mContext;
    }//end constructor



    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_user_raw, parent, false);

        return new user_adapter.UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = listUsers.get(position);
        holder.textViewId.setText(user.getId());
        holder.textViewName.setText(user.getPseudo());
        holder.textViewEmail.setText(user.getEmail());

    }

    @Override
    public int getItemCount() {

        int m = listUsers.size();
        return m;
    }


    //ViewHolder class

     class UserViewHolder extends RecyclerView.ViewHolder {

         public TextView textViewName;
         public TextView textViewEmail;
         public TextView textViewId;

         UserViewHolder(View itemView) {
            super(itemView);
            textViewId =  itemView.findViewById(R.id.user_id);
            textViewName =  itemView.findViewById(R.id.user_name);
            textViewEmail =  itemView.findViewById(R.id.user_email);

        }
    }

}
