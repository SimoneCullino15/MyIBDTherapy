package com.developer.cullino.myibdtherapy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.developer.cullino.myibdtherapy.DB.DBManager;
import com.developer.cullino.myibdtherapy.Model.Farmaco;
import com.developer.cullino.myibdtherapy.Model.FarmacoNotifica;
import com.developer.cullino.myibdtherapy.Model.Notifica;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment implements FarStoryAdapterListener, FarNowAdapterListener {
    int page_position;
    ArrayList<FarmacoNotifica> attuali;
    ArrayList<Farmaco> storico;
    FarNowAdapter adapterAttuali;
    FarStoryAdapter adapterStorico;
    Context context;
    RecyclerView rView;

    public MainFragment(int i, Context ctx) {
        page_position=i;
        context = ctx;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.activity_fragment;
        //infilo view nel fragment
        View view = inflater.inflate(layout_id,container,false);

        DBManager db = new DBManager(context);
        if(page_position == 0 ){
            attuali = db.getFarmacoNotifica();
            Log.d("attuali",attuali.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            rView = view.findViewById(R.id.rView1);
            rView.setHasFixedSize(false);
            rView.setLayoutManager((linearLayoutManager));
            rView.setNestedScrollingEnabled(false);
            adapterAttuali = new FarNowAdapter(getActivity(),attuali);
            rView.setAdapter(adapterAttuali);
            adapterAttuali.setClickListener(this);
        }
        else{
            storico = db.getAllFarmaci();
            Log.d("storico",storico.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            rView = view.findViewById(R.id.rView1);
            rView.setHasFixedSize(false);
            rView.setLayoutManager(linearLayoutManager);
            rView.setNestedScrollingEnabled(false);
            adapterStorico = new FarStoryAdapter(getActivity(),storico);
            rView.setAdapter(adapterStorico);
            adapterStorico.setClickListener(this);
        }
        return view;
    }

    @Override
    public void ItemClicked(View view, int position) {

    }
}
