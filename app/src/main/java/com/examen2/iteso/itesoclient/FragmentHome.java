package com.examen2.iteso.itesoclient;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.examen2.iteso.itesoclient.beans.ItemProduct;
import com.examen2.iteso.itesoclient.tools.Constant;
import com.examen2.iteso.itesoclient.tools.ItemProductsResolver;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ItemProduct> products;
    AdapterProduct adapterProduct;


    public FragmentHome() {
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
        products = ItemProductsResolver.getItemProductsFromCategory(getContext(), Constant.PRODUCTS_HOME);
        adapterProduct = new AdapterProduct(products, getActivity(), Constant.FRAGMENT_HOME);
        recyclerView.setAdapter(adapterProduct);
    }

}
