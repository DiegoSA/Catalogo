package com.example.diego.catalogo.banco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by dblac on 24/07/2017.
 */

public class DBController {
    private SQLiteDatabase db;
    private DBHelper banco;

    public DBController(Context context){
        banco = new DBHelper(context);
    }

    public void preencherBanco() {
        try {
            FileReader arq = new FileReader("produtos.txt");

            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {

                String[] dados = linha.split(";"); //Separa os campos através do separador ';'
                int codigo = Integer.valueOf(dados[0]); //pega o primeiro campo que representa o nome
                String descricao = dados[1]; //pega o segundo campo que representa a idade
                int departamento = Integer.valueOf(dados[2]);
                String caminho = dados[3]; //pega o terceiro campo que representa o sexo
                String padaria = dados[4];
                String mercadinho = dados[5];
                String restaurante = dados[6];
                String clinica = dados[7];
                //String hoteis = dados[8];

                db.execSQL(ScriptSQL.inserirFotoBanco(codigo, descricao, departamento, caminho, padaria, mercadinho, restaurante, clinica)); //Aqui usa o método que fará um insert no banco

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cursor listarProdutos(){

        String[] campos = {"CAMINHO"};

        db = banco.getReadableDatabase();

        Cursor cursor = db.query("PRODUTOS", campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();

        return cursor;
    }

}
