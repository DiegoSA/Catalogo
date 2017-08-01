package com.example.diego.catalogo.telas;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.diego.catalogo.banco.ScriptSQL;
import com.example.suporte.catalogo.R;


public class TelaOpcoes extends AppCompatActivity {

    private Button btGerar;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_opcoes);

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
                                int[] produtos = new int[]{};
                                boolean choice = false;
                                if(limpeza.isChecked()){
                                    choice = true;

                                }
                                if(papelaria.isChecked()){
                                    choice = true;

                                }
                                if(descartaveis.isChecked()){
                                    choice = true;

                                }
                                if(confeitaria.isChecked()){
                                    choice = true;

                                }
                                if(sorveteria.isChecked()){
                                    choice = true;

                                }
                                if(choice){
                                    Intent intent = new Intent(TelaOpcoes.this, CatalogoProdutos.class);
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
                                switch (selection){
                                    case R.id.radioButtonPadaria:
                                        Toast.makeText(getBaseContext(), "Padaria", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.radioButtonMercadinho:
                                        Toast.makeText(getBaseContext(), "Mercadinho", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.radioButtonClinica:
                                        Toast.makeText(getBaseContext(), "Clinica", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.radioButtonRestaurantes:
                                        Toast.makeText(getBaseContext(), "Restaurantes", Toast.LENGTH_SHORT).show();
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
