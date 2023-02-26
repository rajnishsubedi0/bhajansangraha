package com.rkant2023_2.bhajansangraha;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    String[] strings;
    String[] nepaliNumbers={"१","२","३","४","५","६","७","८","९","१०","११","१२","१३","१४","१५","१६","१७","१८","१९","२०","२१","२२","२३","२४","२५","२६","२७","२८","२९","३०","३१","३२","३३","३४","३५","३६","३७","३८","३९","४०","४१","४२","४३","४४","४५","४६","४७","४८","४९","५०","५१","५२","५३","५४","५५","५६","५७","५८","५९","६०","६१","६२","६३","६४","६५","६६","६७","६८","६९","७०","७१","७२","७३","७४","७५","७६","७७","७८","७९","८०","८१","८२","८३","८४","८५","८६","८७","८८","८९","९०"};
ArrayList<first_data_holder> arrayList;
AdapterView.OnItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        arrayList=new ArrayList<>();

        addingData();
        settingAdapter();
    }

    private void settingAdapter() {
        first_recycler_activity recyclerCustomAdapter=new first_recycler_activity(arrayList,listener,MainActivity.this,nepaliNumbers);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerCustomAdapter);

    }


    private void addingData() {
        strings=getResources().getStringArray(R.array.list_opening_bhajan_lists);
        for(int i=0; i<strings.length; i++){
            arrayList.add(new first_data_holder(strings[i],i));
        }

    }
}