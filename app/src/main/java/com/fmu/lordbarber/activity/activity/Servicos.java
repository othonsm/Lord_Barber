package com.fmu.lordbarber.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fmu.lordbarber.R;

public class Servicos extends AppCompatActivity {
    public Button btnCabelo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);

        btnCabelo = findViewById(R.id.btnCabelo);

        btnCabelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CorteCabelo.class);
                startActivity(intent);
            }
        });

    }
}
