package com.developer.cullino.myibdtherapy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.cullino.myibdtherapy.Model.Farmaco;

import java.util.ArrayList;

public class FarStoryAdapter extends RecyclerView.Adapter<FarStoryAdapter.ItemViewHolder>{
    private Context context;
    private ArrayList<Farmaco> data;
    private FarStoryAdapterListener farStoryAdapterListener = null;
    private LayoutInflater layoutInflater;


    public FarStoryAdapter(Context ctx, ArrayList<Farmaco> storico) {
        context = ctx;
        data = storico;
        layoutInflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.far_story_row,viewGroup,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        String img = data.get(i).getImg();
        String title = data.get(i).getNome();
        String bugiardino = data.get(i).getBugiardino();
        Log.d("img",img);
        switch (img){
            case("uno"):
                itemViewHolder.image.setImageResource(R.drawable.pillole);
                break;
            case("due"):
                itemViewHolder.image.setImageResource(R.drawable.siringa);
                break;
            case("tre"):
                itemViewHolder.image.setImageResource(R.drawable.clisma);
                break;
            case("quattro"):
                itemViewHolder.image.setImageResource(R.drawable.flebo);
                break;
            case("cinque"):
                itemViewHolder.image.setImageResource(R.drawable.bustina);
                break;
        }
        itemViewHolder.title.setText(title);
        itemViewHolder.bugiardino.setTag(bugiardino);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(FarStoryAdapterListener farStoryAdapterListener) {
        this.farStoryAdapterListener = farStoryAdapterListener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView title;
        Button bugiardino;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = itemView.findViewById(R.id.imageStory);
            title = itemView.findViewById(R.id.titleStory);
            bugiardino = itemView.findViewById(R.id.buttonStory);


        }

        @Override
        public void onClick(View v) {
            if(farStoryAdapterListener != null){
                farStoryAdapterListener.ItemClicked(v,getAdapterPosition());
            }
        }

        public void btBugiardino_Click(View view) {
                
        }
    }
}
