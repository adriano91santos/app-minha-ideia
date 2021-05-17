package com.example.appminhaideia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.appminhaideia.R;
import com.example.appminhaideia.controller.ClienteController;
import com.example.appminhaideia.core.AppUtil;
import com.example.appminhaideia.model.Cliente;

public class SplashActivity extends AppCompatActivity {

    int tempoDeEspera = 1000 * 3;

    Cliente objCliente;

    ClienteController clienteController;

    TextView txtAppVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.d(AppUtil.TAG, "onCreate: Tela Splash carregada...");

        txtAppVersion = findViewById(R.id.txtAppVersion);
        txtAppVersion.setText(AppUtil.versaoDoAplicativo());

        clienteController = new ClienteController();

        trocarTela();

    }

    private void trocarTela() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                objCliente = new Cliente("Adriano", "teste@teste.com",
                        "14988060412",30,true);

                Log.d(AppUtil.TAG, "trocarTela: Mudando de tela...");

                Intent trocarDeTela = new Intent(SplashActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nome", objCliente.getNome());
                bundle.putString("email", objCliente.getEmail());

                trocarDeTela.putExtras(bundle);

                startActivity(trocarDeTela);
                finish();

            }
        }, tempoDeEspera);
    }
}