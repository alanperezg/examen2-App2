package com.examen2.iteso.itesoclient;


import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import android.provider.BaseColumns;
import android.provider.UserDictionary;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.examen2.iteso.itesoclient.beans.ItemProduct;
import com.examen2.iteso.itesoclient.tools.Constant;
import com.examen2.iteso.itesoclient.tools.ItemProductsResolver;

import java.io.Console;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTechnology extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ItemProduct> products;
    AdapterProduct adapterProduct;

    public FragmentTechnology() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_product, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_recyclerView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        products = new ArrayList<>();
        products = ItemProductsResolver.getItemProductsFromCategory(getContext(), Constant.PRODUCTS_TECH);
        adapterProduct = new AdapterProduct(products, getActivity(), Constant.FRAGMENT_TECHNOLOGY);
        recyclerView.setAdapter(adapterProduct);
    }




}
