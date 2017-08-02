package com.example.diego.catalogo.telas;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
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
                        opcao = "mercadinho = 'S'";
                        cursor = dbController.listarProdutos(opcao);
                        break;
                    case 4:
                        opcao = "restaurante = 'S'";
                        cursor = dbController.listarProdutos(opcao);
                        break;
                }
            }
        }

        ArrayList<Integer> produtos = new ArrayList<Integer>();

        do{
            produtos.add(this.getResources().getIdentifier(cursor.getString(cursor.getColumnIndexOrThrow("caminho")), "drawable", this.getPackageName()));
        } while (cursor.moveToNext());

        GridView gridView = (GridView) findViewById(R.id.gridView);
        Adaptador adaptador = new Adaptador(CatalogoProdutos.this, produtos);
        gridView.setAdapter(adaptador);

    }
}
