package com.example.diego.catalogo.telas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.diego.catalogo.auxiliares.Produtos;

import java.util.ArrayList;

/**
 * Created by Diego Souza on 25/07/2017.
 */

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Produtos> itens;


    public Adaptador(Context context, ArrayList<Produtos> itens){
        this.context = context;
        this.itens = itens;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);

        Glide.with(context)
                .load(itens.get(position).getImagem())
                .override(250,250)
                .into(imageView);

        /*imageView.setLayoutParams(new GridView.LayoutParams(200,200));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(itens.get(position).getImagem());
        imageView.setAdjustViewBounds(true);*/

        return imageView;
    }
}
