package com.developer.cullino.myibdtherapy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developer.cullino.myibdtherapy.Model.FarmacoNotifica;

import java.util.ArrayList;

public class FarNowAdapter extends RecyclerView.Adapter<FarNowAdapter.ItemViewHolder>{
    private ArrayList<FarmacoNotifica>data;
    private FarNowAdapterListener farNowAdapterListener = null;
    private LayoutInflater layoutInflater;
    private Context context;

    public FarNowAdapter(FragmentActivity activity, ArrayList<FarmacoNotifica> attuali) {
        context = activity;
        data = attuali;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.far_actually_row,viewGroup,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        String title = data.get(i).getFarmaco().getNome();
        String ora = data.get(i).getNotifica().getOra();
        String quantita = String.valueOf(data.get(i).getNotifica().getQuantita());
        String img = data.get(i).getFarmaco().getImg();

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
        itemViewHolder.ora.setText(ora);
        itemViewHolder.quantita.setText(quantita);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setClickListener(FarNowAdapterListener farNowAdapterListener) {
        this.farNowAdapterListener = farNowAdapterListener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image;
        TextView title;
        TextView ora;
        TextView quantita;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            image = itemView.findViewById(R.id.imageActually);
            title = itemView.findViewById(R.id.titleActually);
            ora = itemView.findViewById(R.id.oraText);
            quantita = itemView.findViewById(R.id.quantoText);


        }

        @Override
        public void onClick(View v) {
            if(farNowAdapterListener != null){
                farNowAdapterListener.ItemClicked(v,getAdapterPosition());
            }
        }
    }
}
