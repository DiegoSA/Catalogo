package com.example.diego.catalogo.auxiliares;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.diego.catalogo.banco.DBController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by dblac on 31/07/2017.
 */

public class LerProdutos {

    private DBController dbController;

    public LerProdutos(Context context){
        dbController = new DBController(context);
    }

 try {

    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
    }

}
