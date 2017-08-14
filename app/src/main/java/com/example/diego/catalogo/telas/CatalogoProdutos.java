package com.example.diego.catalogo.telas;


import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.diego.catalogo.auxiliares.Produtos;
import com.example.diego.catalogo.banco.DBController;
import com.example.suporte.catalogo.R;
import java.util.ArrayList;


public class CatalogoProdutos extends AppCompatActivity {

    private DBController dbController;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_produtos);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        dbController = new DBController(getBaseContext());

        Bundle bundle = getIntent().getExtras();

        if(bundle == null){
            cursor = dbController.listarProdutos();
        }else {
            if(bundle.getString("opcoes")!= null) {
                String opcoes = bundle.getString("opcoes");
                cursor = dbController.listarProdutos(opcoes);
            }else {
                int segmento = bundle.getInt("segmento");
                String opcao = null;
                switch (segmento) {
                    case 1:
                        opcao = "clinica = 'S'";
                        cursor = dbController.listarProdutos(opcao);
                        break;
                    case 2:
                        opcao = "hotelaria = 'S'";
                        cursor = dbController.listarProdutos(opcao);
                        break;
                    case 3:
                        int subgrupo = bundle.getInt("subgrupo");
                        switch (subgrupo){
                            case 1:
                                opcao = "mercadinho = 'S' AND consumo = 'S'";
                                break;
                            case 2:
                                opcao = "mercadinho = 'S' AND revenda = 'S'";
                                break;
                        }
                        cursor = dbController.listarProdutos(opcao);
                        break;
                    case 4:
                        opcao = "restaurante = 'S'";
                        cursor = dbController.listarProdutos(opcao);
                        break;
                }
            }
        }

        final ArrayList<Produtos> produtos = new ArrayList<Produtos>();

        do{
            Produtos p = new Produtos(this);
            p.setDescricao(cursor.getString(cursor.getColumnIndex("codigo")) + "-" + cursor.getString(cursor.getColumnIndex("descricao")));
            p.setCaminho(cursor.getString(cursor.getColumnIndex("caminho")));
            p.setImagem();
            produtos.add(p);
        } while (cursor.moveToNext());

        GridView gridView = (GridView) findViewById(R.id.gridView);
        final Adaptador adaptador = new Adaptador(CatalogoProdutos.this, produtos);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(CatalogoProdutos.this);
                String nomeProduto = (String) produtos.get(position).getDescricao();
                dialog.setContentView(R.layout.informacao_produto);
                final TextView descricao = (TextView) dialog.findViewById(R.id.textViewInfProd);
                descricao.setText(nomeProduto);
                final ImageView fotoProduto = (ImageView) dialog.findViewById(R.id.imageViewInfProd);
                Glide.with(getBaseContext())
                        .load(produtos.get(position).getImagem())
                        .override(400,400)
                        .fitCenter()
                        .into(fotoProduto);

                /*fotoProduto.setImageResource(produtos.get(position).getImagem());
                fotoProduto.setLayoutParams(new LinearLayout.LayoutParams(400,400));
                fotoProduto.setAdjustViewBounds(true);*/
                dialog.show();
            }
        });
    }
}
