package com.examen2.iteso.itesoclient;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examen2.iteso.itesoclient.beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private ArrayList<ItemProduct> products;
    private Context context;
    private int fragment;

    public AdapterProduct(ArrayList<ItemProduct> products, Context context, int fragment) {
        this.products = products;
        this.context = context;
        this.fragment = fragment;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle;
        TextView mStore;
        TextView mLocation;
        TextView mDescription;
        TextView mPhone;

        ViewHolder(View v){
            super(v);
            mTitle = v.findViewById(R.id.item_product_title);
            mStore = v.findViewById(R.id.item_product_store);
            mLocation = v.findViewById(R.id.item_product_location);
            mDescription = v.findViewById(R.id.item_product_description);
            mPhone = v.findViewById(R.id.item_product_phone);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(products.get(holder.getAdapterPosition()).getTitle());
        holder.mStore.setText(products.get(holder.getAdapterPosition()).getStore());
        holder.mLocation.setText(products.get(holder.getAdapterPosition()).getLocation());
        holder.mDescription.setText(products.get(holder.getAdapterPosition()).getDescription());
        holder.mPhone.setText(products.get(holder.getAdapterPosition()).getPhone());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
