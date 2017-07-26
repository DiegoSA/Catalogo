package com.example.diego.catalogo.banco;

/**
 * Created by dblac on 24/07/2017.
 */

public class ScriptSQL {

    /*public static String inserirFotos(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO PRODUTOS (CAMINHO, DESCRICAO) VALUES ('R.drawable.sabonete_liq_audax_all_clean_antisep_5l', '151 - SABONETE LIQ AUDAX ALL CLEAN ANTISEP 5L'); ");
        stringBuilder.append("INSERT INTO PRODUTOS (CAMINHO, DESCRICAO) VALUES ('R.drawable.balde_espremedor', '836 - BALDE ESPREMEDOR BRALIMPIA DOBLO'); ");
        stringBuilder.append("INSERT INTO PRODUTOS (CAMINHO, DESCRICAO) VALUES ('R.drawable.multiuso_audax', '1483 - MULTIUSO AUDAX LAVANDA 500ML'); ");
        stringBuilder.append("INSERT INTO PRODUTOS (CAMINHO, DESCRICAO) VALUES ('R.drawable.palito_dente_billa', '2618 - PALITO DENTE BAMBU BILLA EMBALADO 2000UN'); ");
        stringBuilder.append("INSERT INTO PRODUTOS (CAMINHO, DESCRICAO) VALUES ('R.drawable.pano_multiuso_billa', '4421 - PANO MULTIUSO BILLA 600UN'); ");
        stringBuilder.append("INSERT INTO PRODUTOS (CAMINHO, DESCRICAO) VALUES ('R.drawable.placa_sinalizacao', '818 - PLACA SINAL BRAL PISO MOLHADO'); ");

        return stringBuilder.toString();
    }*/

    public static String createProdutos(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE PRODUTOS ( ");
        stringBuilder.append("ID        INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("CAMINHO   STRING  NOT NULL, ");
        stringBuilder.append("DESCRICAO STRING  NOT NULL ");
        stringBuilder.append("); ");

        return stringBuilder.toString();
    }

    public static String createDepartamento(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE DEPARTAMENTO ( ");
        stringBuilder.append("ID           INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("DEPARTAMENTO STRING, ");
        stringBuilder.append("PRODUTO      INTEGER REFERENCES PRODUTOS (ID) ");
        stringBuilder.append("); ");

        return stringBuilder.toString();
    }

    public static String createSegmento(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CREATE TABLE SEGMENTO ( ");
        stringBuilder.append("ID       INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilder.append("SEGMENTO STRING  NOT NULL, ");
        stringBuilder.append("PRODUTO  INTEGER REFERENCES PRODUTOS (ID) NOT NULL ");
        stringBuilder.append("); ");

        return stringBuilder.toString();
    }

}
