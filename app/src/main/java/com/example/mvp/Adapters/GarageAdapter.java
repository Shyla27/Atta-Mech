package com.example.mvp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.models.Garage;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GarageAdapter extends RecyclerView.Adapter<GarageAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Garage> garageArrayList;
    public GarageAdapter (Context context, ArrayList<Garage> garageArrayList) {
        this.context = context;
        this.garageArrayList = garageArrayList;

    }



    @NonNull
    @Override
    public GarageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent,false);
        return  new  ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GarageAdapter.ViewHolder holder, int position) {
        Garage model = garageArrayList.get(position);
        holder.garagenameTV.setText(model.getGarage_name());
        holder.garageRatingTV.setText(model.getGarage_rating());
        holder.garageIV.setImageResource(model.getGarage_image());

        

    }



    @Override
    public int getItemCount() {
        return garageArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView garageIV;
        private TextView garageRatingTV,garagenameTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            garageIV = itemView.findViewById(R.id.Garage_image);
            garagenameTV = itemView.findViewById(R.id.Garage_name);
            garageRatingTV = itemView.findViewById(R.id.garage_rating);
        }
    }
}
