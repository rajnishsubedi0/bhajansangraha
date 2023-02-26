package com.rkant2023_2.bhajansangraha;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class logics_recycler_view extends androidx.recyclerview.widget.RecyclerView.Adapter<logics_recycler_view.MyViewHolder>{
    private ArrayList<logic_data_holder> arrayList;
    public logics_recycler_view(ArrayList<logic_data_holder> arrayList){
        this.arrayList=arrayList;
    }
    public class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);

        }
    }
    @NonNull
    @Override
    public logics_recycler_view.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.logics_recycler_holder,parent,false);
        return new logics_recycler_view.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull logics_recycler_view.MyViewHolder holder, int position) {
        String string=arrayList.get(position).getString();
        holder.textView.setText(string);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
