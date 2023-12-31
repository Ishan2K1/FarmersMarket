package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {

    Context context;
    List<MarketModel> filteredList;
    List<MarketModel> listFull;

    public ListAdapter(Context context, List<MarketModel> list) {
        this.context = context;
        filteredList = list;
        listFull = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.market_card, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MarketDetailActivity.class);
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(filteredList.get(position).getImage());
        holder.name.setText(filteredList.get(position).getName());
        holder.distance.setText(filteredList.get(position).getDistance() + " miles");
        holder.date.setText(filteredList.get(position).getTime() + " days from now");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(v.getContext(), "My Item position: " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MarketDetailActivity.class);
                intent.putExtra("name", filteredList.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<MarketModel> filteredMarkets = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredMarkets.addAll(listFull);
            } else {
                String arginput = "10,2";
                String[] args = (arginput).split(",");
                int maxdistance = Integer.parseInt(args[0]);
                int maxtime = Integer.parseInt(args[1]);
//                String maxtime = args[1];
////                Log.d("maxtime", maxtime);
                for(int i = 0; i < args.length; i++) {
                    Log.d("args", args[i]);
                }


                for (MarketModel marketModel: listFull) {
                    if (marketModel.getDistance() <= maxdistance) {
                        filteredMarkets.add(marketModel);
                    }
                }
            }
            Log.d("filteredmarkets", filteredMarkets.toString());
            FilterResults results = new FilterResults();
            results.values = filteredMarkets;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (List)results.values;
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, distance, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            distance = itemView.findViewById(R.id.distance);
            date = itemView.findViewById(R.id.date);
        }
    }
}
