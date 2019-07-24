package com.lukmo.retrofitpractise;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    public List<User> userList = new ArrayList<>();

    public CustomAdapter(List<User> userList){
        this.userList = userList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTitle.setText(userList.get(i).getTitle());
        myViewHolder.tvBody.setText(userList.get(i).getId()+"");
        myViewHolder.tvId.setText(userList.get(i).getId()+"");
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvId, tvBody, tvTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.user_id);
            tvTitle = (TextView) itemView.findViewById(R.id.user_title);
            tvBody = (TextView) itemView.findViewById(R.id.user_body);
        }
    }
}
