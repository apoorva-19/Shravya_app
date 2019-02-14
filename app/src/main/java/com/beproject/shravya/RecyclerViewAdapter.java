package com.beproject.shravya;

import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{


    private List<InfoClass> information;

    public RecyclerViewAdapter(List<InfoClass> information){

        this.information = information;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_shloka,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Shloka.setText(information.get(position).getOrg_shloka());

    }

    @Override
    public int getItemCount() {
        return information.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Shloka;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Shloka = itemView.findViewById(R.id.shlokaText);
        }
    }
}
