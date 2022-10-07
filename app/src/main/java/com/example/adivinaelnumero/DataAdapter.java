package com.example.adivinaelnumero;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolderDatos> {
    ArrayList<Scores> scoreData = new ArrayList<Scores>();

    public DataAdapter(ArrayList<Scores> scoreData) {
        this.scoreData = scoreData;
    }

    @NonNull
    @androidx.annotation.NonNull
    @Override
    public DataAdapter.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.asignData(scoreData.get(position));
    }

    @Override
    public int getItemCount() {
        return scoreData.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView tv;
        public ViewHolderDatos(@NonNull @androidx.annotation.NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.txtView_data);
        }

        public void asignData(Scores scores) {
            tv.setText(scores.toString());
        }
    }
}

