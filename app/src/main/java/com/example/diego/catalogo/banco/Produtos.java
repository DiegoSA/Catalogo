package com.example.diego.catalogo.banco;

/**
 * Created by dblac on 31/07/2017.
 */

public class Produtos {
    private int codigo;
    private String descricao;
    private int departamento;
    private String caminho;
    private String padaria;
    private String mercadinho;
    private String restaurante;
    private String clinica;
    private String hoteis;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getPadaria() {
        return padaria;
    }

    public void setPadaria(String padaria) {
        this.padaria = padaria;
    }

    public String getMercadinho() {
        return mercadinho;
    }

    public void setMercadinho(String mercadinho) {
        this.mercadinho = mercadinho;
    }

    public String getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getHoteis() {
        return hoteis;
    }

    public void setHoteis(String hoteis) {
        this.hoteis = hoteis;
    }
}

