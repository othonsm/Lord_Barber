package com.fmu.lordbarber.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fmu.lordbarber.R;

public class CorteCabelo extends AppCompatActivity {
    public Button icoReturn;
    public Button btnAgendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corte_cabelo);

        //Botão de retorno para Activity_Servicos
        icoReturn = findViewById(R.id.icoReturn);

        icoReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Servicos.class);
                startActivity(intent);
            }
        });

        //Botão para Activity_Agendamento
        btnAgendar = findViewById(R.id.btnAgendar);

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Agendamento.class);
                startActivity(intent);
            }
        });
    }
}
