package com.example.diego.catalogo.telas;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;

import com.example.diego.catalogo.banco.DBController;
import com.example.suporte.catalogo.R;


public class CatalogoProdutos extends AppCompatActivity {

    private DBController dbController;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_produtos);

        dbController = new DBController(CatalogoProdutos.this);
        //cursor = dbController.listarProdutos();
        //preencherCatalogo(cursor);

        int[] itens = new int[]{R.drawable.arcollor_massa_elastica_500g,
                R.drawable.arcollor_pasta_americana_800g,
                R.drawable.audax_base_seladora_innovation,
                R.drawable.audax_cera_liquida_innovation,
                R.drawable.audax_desinfetante_cleosol_lavanda,
                R.drawable.audax_desinfetante_gold_floral,
                R.drawable.audax_desinfetante_max_lavanda,
                R.drawable.audax_detergente_cletex,
                R.drawable.audax_detergente_gold_clorado,
                R.drawable.audax_detergente_gold_neutro,
                R.drawable.audax_hipoclorito_de_sodio,
                R.drawable.audax_multiuso_lavanda_500ml,
                R.drawable.audax_sabonete_antisseptico_all_clean,
                R.drawable.audax_sabonete_desengraxante_5l,
                R.drawable.audax_sabonete_espuma_all_clean,
                R.drawable.aurea_doce_de_leite,
                R.drawable.aurea_doce_de_leite_com_chocolate,
                //R.drawable.aurea_ketchup,
                //R.drawable.aurea_maionese,
                //R.drawable.aurea_mostarda
                };
        GridView gridView = (GridView) findViewById(R.id.gridView);
        Adaptador adaptador = new Adaptador(CatalogoProdutos.this, itens);
        gridView.setAdapter(adaptador);

    }

    /*public SimpleCursorAdapter preencherCatalogo(Cursor cursor){
        String[] columns = new String[]{"CAMINHO", "DESCRICAO"};
        int[] to = new int[]{R.id.imageViewLeft, R.id.textViewLeft};

        adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.produtos, cursor, columns, to, 0);
        return adapter;
    }*/
}
