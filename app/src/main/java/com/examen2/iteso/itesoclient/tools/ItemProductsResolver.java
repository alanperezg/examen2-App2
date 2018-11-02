package com.examen2.iteso.itesoclient.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.examen2.iteso.itesoclient.beans.ItemProduct;

import java.util.ArrayList;

public class ItemProductsResolver {

    public static ArrayList<ItemProduct> getItemProductsFromCategory(Context context, int category){
        ArrayList<ItemProduct> products = new ArrayList<>();
        ContentResolver resolver = context.getContentResolver();
        Uri uri = Uri.parse("content://" + Constant.PROVIDER_NAME + "/products/category/" + category);
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
                    String name = cursor.getString(1);
                    String description = cursor.getString(2);
                    String tienda = cursor.getString(3);
                    String ciudad = cursor.getString(4);
                    String telefono = cursor.getString(5);
                    products.add(new ItemProduct(name, ciudad, telefono, description, tienda));
                }while (cursor.moveToNext());
            }
        }else {
            Log.e("HOLA", "no funciono");
        }
        return products;
    }
}
