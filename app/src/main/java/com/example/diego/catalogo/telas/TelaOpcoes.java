package com.example.diego.catalogo.telas;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.suporte.catalogo.R;


public class TelaOpcoes extends AppCompatActivity {

    private Button btGerar;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcoes);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        btGerar = (Button) findViewById(R.id.buttonGerar);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.tipoCatalogo);

        btGerar.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                int selected = radioGroup.getCheckedRadioButtonId(); //pegar o radio selecionado
                AlertDialog.Builder ad = new AlertDialog.Builder(TelaOpcoes.this);

                switch (selected){//passo o radio para verificar a devolução
                    case R.id.radioButtonDep:
                        ad.setView(R.layout.checkbox_catalogo);
                        alertDialog = ad.create();
                        alertDialog.show();

                        Button okDep = (Button) alertDialog.findViewById(R.id.buttonOkDep);
                        final CheckBox limpeza = (CheckBox) alertDialog.findViewById(R.id.limpeza);
                        final CheckBox descartaveis = (CheckBox) alertDialog.findViewById(R.id.descartaveis);
                        final CheckBox papelaria = (CheckBox) alertDialog.findViewById(R.id.papelaria);
                        final CheckBox confeitaria = (CheckBox) alertDialog.findViewById(R.id.confeitaria);
                        final CheckBox sorveteria = (CheckBox) alertDialog.findViewById(R.id.sorveteria);

                        okDep.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String opcoes = null;
                                boolean choice = false;
                                if(limpeza.isChecked()){
                                    choice = true;
                                    if(opcoes == null) {
                                        opcoes = "departamento in (102";
                                    }else {
                                        opcoes = opcoes + ",102";
                                    }

                                }
                                if(papelaria.isChecked()){
                                    choice = true;
                                    if(opcoes == null) {
                                        opcoes = "departamento in (103";
                                    }else {
                                        opcoes = opcoes + ",103";
                                    }
                                }
                                if(descartaveis.isChecked()){
                                    choice = true;
                                    if(opcoes == null) {
                                        opcoes = "departamento in (101";
                                    }else {
                                        opcoes = opcoes + ",101";
                                    }
                                }
                                if(confeitaria.isChecked()){
                                    choice = true;
                                    if(opcoes == null) {
                                        opcoes = "departamento in (106";
                                    }else {
                                        opcoes = opcoes + ",106";
                                    }
                                }
                                if(sorveteria.isChecked()){
                                    choice = true;
                                    if(opcoes == null) {
                                        opcoes = "departamento in (100";
                                    }else {
                                        opcoes = opcoes + ",100";
                                    }
                                }
                                if(choice){
                                    Intent intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                                    opcoes = opcoes + ")";
                                    intent.putExtra("opcoes", opcoes);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(getBaseContext(), "Escolha uma(s) da(s) opção(ões)!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        break;
                    case R.id.radioButtonSeg:
                        ad.setView(R.layout.radio_segmento);
                        alertDialog = ad.create();
                        alertDialog.show();
                        Button okSegmento = (Button) alertDialog.findViewById(R.id.buttonOkSegmento);
                        okSegmento.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                RadioGroup radioSegmento = (RadioGroup) alertDialog.findViewById(R.id.RadioporSegmento);
                                int selection = radioSegmento.getCheckedRadioButtonId();
                                Intent intent;
                                switch (selection){
                                    case R.id.radioButtonClinica:
                                        intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                                        intent.putExtra("segmento",1);
                                        startActivity(intent);
                                        break;
                                    case R.id.radioButtonHotelaria:
                                        intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                                        intent.putExtra("segmento",2);
                                        startActivity(intent);
                                        break;
                                    case R.id.radioButtonMercadinho:
                                        AlertDialog.Builder dialog = new AlertDialog.Builder(TelaOpcoes.this);
                                        dialog.setView(R.layout.subgrupo_segmento);
                                        AlertDialog ad;
                                        ad = dialog.create();
                                        ad.show();


                                        final Button consumo = (Button) ad.findViewById(R.id.buttonConsumo);
                                        final Button revenda = (Button) ad.findViewById(R.id.buttonrRevenda);

                                        consumo.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                                                intent.putExtra("subgrupo", 1);
                                                intent.putExtra("segmento",3);
                                                startActivity(intent);
                                            }
                                        });

                                        revenda.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                                                intent.putExtra("subgrupo", 2);
                                                intent.putExtra("segmento",3);
                                                startActivity(intent);
                                            }
                                        });

                                        //dialog.show();

                                        break;
                                    case R.id.radioButtonRestaurantes:
                                        intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                                        intent.putExtra("segmento",4);
                                        startActivity(intent);
                                        break;
                                    default:
                                        Toast.makeText(getBaseContext(), "escolha uma das opções!!", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                        break;
                    case R.id.radioButtonGeral:
                        Intent intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getBaseContext(), "escolha uma das opções!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
