package com.examen2.iteso.itesoclient;


import android.content.ContentResolver;
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
        //products.add(new ItemProduct("Title","Location","Phone","Description","Store"));
        //products.add(new ItemProduct("Title","Location","Phone","Description","Store"));
        //products.add(new ItemProduct("Title","Location","Phone","Description","Store"));
        //products.add(new ItemProduct("Title","Location","Phone","Description","Store"));
        //products.add(new ItemProduct("Title","Location","Phone","Description","Store"));
        getTechnology();
        adapterProduct = new AdapterProduct(products, getActivity(), Constant.FRAGMENT_TECHNOLOGY);
        recyclerView.setAdapter(adapterProduct);
    }

    static final String PROVIDER_NAME = "com.iteso.pdm18_scrollabletabs";
    static final int PRODUCTS_BY_CATEGORY = 1;


    private void getTechnology(){
        ContentResolver resolver = getContext().getContentResolver();
        Uri uri = Uri.parse("content://" + PROVIDER_NAME + "/products/category/" + PRODUCTS_BY_CATEGORY);
        String[] projection = new String[]{"id", "name", "description", "tienda", "ciudad", "telefono"};
        Cursor cursor =
                resolver.query(uri,
                        projection,
                        null,
                        null,
                        null);


        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    //long id = cursor.getLong(0);
                    String word = cursor.getString(1);
                    products.add(new ItemProduct(word, word, word, word, word));
                }while (cursor.moveToNext());
            }
        }else {
            Log.e("HOLA", "no funciono");
        }


    }
}
