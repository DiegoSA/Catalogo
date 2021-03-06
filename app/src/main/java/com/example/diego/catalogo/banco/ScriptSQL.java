package com.example.diego.catalogo.banco;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import com.example.suporte.catalogo.R;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Diego Souza on 24/07/2017.
 */

public class ScriptSQL {

    public static String createProdutos(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("CREATE TABLE PRODUTOS( ");
        stringBuilder.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("codigo INTEGER NOT NULL UNIQUE,");
        stringBuilder.append("descricao VARCHAR (50) NOT NULL, ");
        stringBuilder.append("departamento INTEGER NOT NULL, ");
        stringBuilder.append("caminho VARCHAR (60) NOT NULL, ");
        stringBuilder.append("hotelaria CHAR CHECK (hotelaria IN ('S', 'N') ), ");
        stringBuilder.append("mercadinho CHAR CHECK (mercadinho IN ('S', 'N') ), ");
        stringBuilder.append("restaurante CHAR CHECK (restaurante IN ('S', 'N') ), ");
        stringBuilder.append("clinica CHAR CHECK (clinica IN ('S', 'N') ), ");
        stringBuilder.append("consumo CHAR CHECK (consumo IN ('S', 'N') ), ");
        stringBuilder.append("revenda CHAR CHECK (revenda IN ('S', 'N') ) ");
        stringBuilder.append("); ");

        return stringBuilder.toString();
    }

    public static ContentValues inserirFotoBanco(int codigo, String descricao, int departamento, String caminho, String hotelaria, String mercadinho, String restaurante, String clinica, String consumo, String revenda){

        ContentValues values = new ContentValues();

        values.put("codigo", codigo);
        values.put("descricao", descricao);
        values.put("departamento", departamento);
        values.put("caminho", caminho);
        values.put("hotelaria", hotelaria);
        values.put("mercadinho", mercadinho);
        values.put("restaurante", restaurante);
        values.put("clinica", clinica);
        values.put("consumo", consumo);
        values.put("revenda", revenda);

        return values;
    }

    public static ArrayList<ContentValues> preencherBanco(Context context) {

        Resources resources = context.getResources();
        ArrayList<ContentValues> scriptProdutos = new ArrayList<ContentValues>();

        try {
            InputStream inputStream = resources.openRawResource(R.raw.produtos);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader lerArq = new BufferedReader(inputStreamReader);
            String linha = lerArq.readLine();
            while (linha != null) {

                String[] dados = linha.split(";");
                int codigo = Integer.valueOf(dados[0]);
                String descricao = dados[1];
                int departamento = Integer.valueOf(dados[2]);
                String caminho = dados[3];
                String hotelaria = dados[4];
                String mercadinho = dados[5];
                String restaurante = dados[6];
                String clinica = dados[7];
                String consumo = dados[8];
                String revenda = dados[9];

                ContentValues values = ScriptSQL.inserirFotoBanco(codigo, descricao, departamento, caminho, hotelaria, mercadinho, restaurante, clinica, consumo, revenda); //Aqui usa o método que fará um insert no banco
                scriptProdutos.add(values);

                linha = lerArq.readLine(); //lê da segunda até a última linha
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scriptProdutos;
    }
}
