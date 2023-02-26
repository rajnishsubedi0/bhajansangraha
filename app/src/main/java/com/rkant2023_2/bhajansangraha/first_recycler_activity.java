package com.rkant2023_2.bhajansangraha;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class first_recycler_activity extends androidx.recyclerview.widget.RecyclerView.Adapter<first_recycler_activity.MyViewHolder>{
    private ArrayList<first_data_holder> arrayList;
    AdapterView.OnItemSelectedListener listener;
    Context context;
    String[] nepaliNumbers;
    public first_recycler_activity(ArrayList<first_data_holder> arrayList, AdapterView.OnItemSelectedListener listener, Context context, String[] nepaliNumbers){
        this.arrayList=arrayList;
        this.listener=listener;
        this.context=context;
        this.nepaliNumbers=nepaliNumbers;
    }
    public class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        TextView textView,textViewNepaliNumber;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            linearLayout=itemView.findViewById(R.id.layout_name);
            textViewNepaliNumber=itemView.findViewById(R.id.textViewNepaliNumber);
        }
    }
    @NonNull
    @Override
    public first_recycler_activity.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull first_recycler_activity.MyViewHolder holder, int position) {
        String string=arrayList.get(position).getString();
        Integer number=arrayList.get(position).getInteger();
        holder.textView.setText(string);
        holder.textViewNepaliNumber.setText(nepaliNumbers[position]);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           Intent intent= new Intent(context,logic_activity.class);
           intent.putExtra("position",number);
           context.startActivity(intent);
                            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
