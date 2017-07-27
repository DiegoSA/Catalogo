package com.example.diego.catalogo.banco;

import com.example.suporte.catalogo.R;

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

    public static String inserirFoto(String caminho, String descricao){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("INSERT INTO PRODUTOS ( ");
        stringBuilder.append("CAMINHO, ");
        stringBuilder.append("DESCRICAO) ");
        stringBuilder.append("VALUES ( ");
        stringBuilder.append("'" + caminho + "', ");
        stringBuilder.append("'" + descricao + "'); ");

        return stringBuilder.toString();
    }

    public static int[] gerarPapelaria(){

        int[] papelaria = new int[]{
                R.drawable.brw_corretivo_em_fita};

        return papelaria;
    }

    public static int[] gerarLimpeza(){

        int[] limpeza = new int[]{
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
                R.drawable.betanin_mop_zig_zag_sekito,
                R.drawable.bettanin_balde_10l_sekito,
                R.drawable.bettanin_balde_14l_zig_zag,
                R.drawable.bettanin_balde_twister_com_pedal_mop_twister,
                R.drawable.bettanin_combo,
                R.drawable.bettanin_desentupidor_grande,
                R.drawable.bettanin_desintupidor_pias_ralos,
                R.drawable.bettanin_escova,
                R.drawable.bettanin_escova_brilhus_multiuso,
                R.drawable.bettanin_escova_com_cabo,
                R.drawable.bettanin_escova_sanitaria_sem_suporte,
                R.drawable.bettanin_escova_sanitaria_suporte,
                R.drawable.bettanin_escova_sanitaria_suporte2,
                R.drawable.bettanin_esponja_brilhus,
                R.drawable.bettanin_esponja_esfrebom_protege_unhas,
                R.drawable.bettanin_luva_fashion,
                R.drawable.bettanin_mop_abrasivo,
                R.drawable.bettanin_mop_esfregao_algodao,
                R.drawable.bettanin_mop_esfregao_limpatudo,
                R.drawable.bettanin_mop_lustrador_algodao,
                R.drawable.bettanin_mop_lustrador_la,
                R.drawable.bettanin_mop_spray,
                R.drawable.bettanin_mop_torcao,
                R.drawable.bettanin_pa,
                R.drawable.bettanin_pa_cabo_longo,
                R.drawable.bettanin_pa_coletora,
                R.drawable.bettanin_refil_abrasivo,
                R.drawable.bettanin_refil_algodao,
                R.drawable.bettanin_refil_limpatudo,
                R.drawable.bettanin_refil_lustrador_algodao,
                R.drawable.bettanin_refil_lustrador_la,
                R.drawable.bettanin_refil_mop_twister,
                R.drawable.bettanin_refil_zig_zag_sekito,
                R.drawable.bettanin_rodo_vai_vem_m,
                R.drawable.bettanin_rodo_vai_vem_p,
                R.drawable.bettanin_vassoura_brilhus,
                R.drawable.bettanin_vassoura_original,
                R.drawable.bettanin_vassoura_piso_delicado,
                R.drawable.bettanin_vassoura_varry,
                R.drawable.bettanin_vassourita_brilhus,
                R.drawable.billa_palito_dente_2000,
                R.drawable.billa_pano_multiuso_azul,
                R.drawable.billa_pano_multiuso_laranja,
                R.drawable.bralimpia_armacao_plus,
                R.drawable.bralimpia_balde_4l_com_alca,
                R.drawable.bralimpia_balde_espremedor_doblo,
                R.drawable.bralimpia_balde_espremedor_mopinho,
                R.drawable.bralimpia_cabo_fosco,
                R.drawable.bralimpia_carro_funcional_america,
                R.drawable.bralimpia_carro_funcional_pan_america,
                R.drawable.bralimpia_cesto_basculhante_14l,
                R.drawable.bralimpia_cesto_basculhante_23l_azul,
                R.drawable.bralimpia_cesto_basculhante_23l_verde,
                R.drawable.bralimpia_cesto_basculhante_23l_vermelho,
                R.drawable.bralimpia_cesto_gari_120l,
                R.drawable.bralimpia_cesto_gari_240l,
                R.drawable.bralimpia_combinado_com_cabo,
                R.drawable.bralimpia_conjunto_high_tech_40cm,
                R.drawable.bralimpia_enceradeira_440mm,
                R.drawable.bralimpia_escada_aluminio,
                //R.drawable.bralimpia_espeto_coletor_lixo_sticher,
                R.drawable.bralimpia_extensao_telescopica,
                R.drawable.bralimpia_guia_removivel,
                R.drawable.bralimpia_haste_com_cabo_euro_azul,
                R.drawable.bralimpia_kit_plus_com_bolsa,
                R.drawable.bralimpia_kit_promocional_1,
                R.drawable.bralimpia_kit_promocional_2,
                R.drawable.bralimpia_laminha_borracha,
                R.drawable.bralimpia_lixeira_50l_com_alca,
                R.drawable.bralimpia_lixeira_50l_sem_gravuras_com_ferragens,
                R.drawable.bralimpia_lixeira_para_copos,
                R.drawable.bralimpia_lt_euro_azul,
                R.drawable.bralimpia_mini_kit,
                R.drawable.bralimpia_modulo_lixeira_50l_com_rodas,
                R.drawable.bralimpia_pa_coletora,
                R.drawable.bralimpia_placa_sinal_piso_molhado,
                R.drawable.bralimpia_pulverizador_500ml_1l,
                R.drawable.bralimpia_raspador_pesado_com_cabo,
                R.drawable.bralimpia_refil_mop_cru_loop_cinta_vermelho,
                R.drawable.bralimpia_refil_mop_microfibra_branco,
                R.drawable.bralimpia_refil_mopinho_30cm,
                R.drawable.bralimpia_rodo_plastico_55cm,
                //R.drawable.bralimpia_rodo_plastico_dry_azul,
                R.drawable.bralimpia_saboneteira_reservatorio,
                R.drawable.bralimpia_super_mop_domestico,
                R.drawable.bralimpia_tela_mictorio_azul_verde,
                R.drawable.bralimpia_tela_mictorio_vermelha_amarela,
                R.drawable.bralimpia_vassoura_macia,
                R.drawable.bralimpia_vassoura_mini_pa_coletora,
                R.drawable.brlimpia_armacao_profissional
        };

        return limpeza;
    }

    public static int[] gerarDescartaveis(){

        int[] descartaveis = new int[]{
                R.drawable.copobras_copo_balada_300ml,
                R.drawable.cristalppote_kit_pote_com_tampa_250ml,
                R.drawable.termica_protetor_fogao};

        return descartaveis;
    }

    public static int[] gerarConfeitaria(){

        int[] confeitaria = new int[]{
                R.drawable.arcollor_massa_elastica_500g,
                R.drawable.arcollor_pasta_americana_800g,
                R.drawable.aurea_doce_de_leite,
                R.drawable.aurea_doce_de_leite_com_chocolate,
                R.drawable.mix_pastamix_800g};

        return confeitaria;
    }

    public static int[] gerarSorveteria(){

        int[] sorveteria = new int[]{
                R.drawable.du_porto_cobertura_1300g,
                R.drawable.du_porto_cobertura_chocolate_300g,
                R.drawable.du_porto_po_para_gelados_1kg};

        return sorveteria;
    }
}
