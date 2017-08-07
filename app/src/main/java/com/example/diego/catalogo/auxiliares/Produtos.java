package com.example.diego.catalogo.auxiliares;

import android.content.Context;

/**
 * Created by Diego Souza on 03/08/2017.
 */

public class Produtos {
    private String descricao;
    private int departamento;
    private String caminho;
    private Context context;
    private int imagem;

    public Produtos(Context context){
        this.context = context;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem() {
        this.imagem = context.getResources().getIdentifier(this.caminho, "drawable", context.getPackageName());
    }
}
