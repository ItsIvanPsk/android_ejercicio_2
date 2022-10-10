package com.example.adivinaelnumero;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolderDatos> {
    ArrayList<Scores> scoreData = new ArrayList<Scores>();

    public DataAdapter(ArrayList<Scores> scoreData) {
        this.scoreData = scoreData;
    }

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
        public ViewHolderDatos(ViewHolderDatos holder, View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.txtView_data);
        }

        public ViewHolderDatos(View view) {
            super(view);
            tv = view.findViewById(R.id.txtView_data);
        }

        public void asignData(Scores scores) {
            tv.setText(scores.toString());
        }
    }
}

