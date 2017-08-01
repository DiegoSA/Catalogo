package com.example.diego.catalogo.banco;

import android.content.ContentValues;
import java.util.ArrayList;

/**
 * Created by dblac on 24/07/2017.
 */

public class ScriptSQL {

    public static String createProdutos(){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("CREATE TABLE IF NOT EXISTS PRODUTOS( ");
        stringBuilder.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("codigo INTEGER NOT NULL UNIQUE,");
        stringBuilder.append("descricao VARCHAR (40) NOT NULL, ");
        stringBuilder.append("departamento INTEGER NOT NULL, ");
        stringBuilder.append("caminho VARCHAR (50) NOT NULL, ");
        stringBuilder.append("padaria CHAR CHECK (PADARIA IN ('S', 'N') ), ");
        stringBuilder.append("mercadinho CHAR CHECK (MERCADINHO IN ('S', 'N') ), ");
        stringBuilder.append("restaurante CHAR CHECK (RESTAURANTE IN ('S', 'N') ), ");
        stringBuilder.append("clinica CHAR CHECK (CLINICAS IN ('S', 'N') ) ");
        stringBuilder.append("); ");

        return stringBuilder.toString();
    }

    public static ContentValues inserirFotoBanco(int codigo, String descricao, int departamento, String caminho, String padaria, String mercadinho, String restaurante, String clinica){

        ContentValues values = new ContentValues();

        values.put("codigo", codigo);
        values.put("descricao", descricao);
        values.put("departamento", departamento);
        values.put("caminho", caminho);
        values.put("padaria", padaria);
        values.put("mercadinho", mercadinho);
        values.put("restaurante", restaurante);
        values.put("clinica", clinica);

        return values;
    }
}
