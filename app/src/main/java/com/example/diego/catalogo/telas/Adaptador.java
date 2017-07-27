package com.example.diego.catalogo.telas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dblac on 25/07/2017.
 */

public class Adaptador extends BaseAdapter {

    private Context context;
    private int[] itens;

    public Adaptador(Context context, int[] itens){
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.length;
    }

    @Override
    public Object getItem(int position) {
        return itens[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(itens[position]);
        imageView.setAdjustViewBounds(true);

        return imageView;
    }
}
