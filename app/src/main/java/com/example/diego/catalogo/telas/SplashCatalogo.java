package com.example.diego.catalogo.telas;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.diego.catalogo.banco.DBController;
import com.example.suporte.catalogo.R;


public class SplashCatalogo extends AppCompatActivity {
    private DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_catalogo);

        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        }, 3000);
    }

    private void mostrarLogin() {
        Intent intent = new Intent(SplashCatalogo.this,
                TelaOpcoes.class);
        startActivity(intent);
        finish();
    }
}
