package com.fmu.lordbarber.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fmu.lordbarber.R;

public class Agendamento extends AppCompatActivity {
    public Button icoReturnServico;
    public Button btnAgendarCorfirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        //Botão de retorno para Activity_Servicos
        icoReturnServico = findViewById(R.id.icoReturnServico);

        icoReturnServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Servicos.class);
                startActivity(intent);
            }
        });

        //Botão para Activity_Agendamento
        btnAgendarCorfirma = findViewById(R.id.btnAgendarCorfirma);

        btnAgendarCorfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModalCliente.class);
                startActivity(intent);
            }
        });

    }
}
