package com.fmu.lordbarber.activity.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fmu.lordbarber.R;
import com.fmu.lordbarber.activity.config.ConfiguracaoFirebase;
import com.fmu.lordbarber.activity.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    public Button btnLoginReturn;

    private EditText campoNome, campoEmail, campoSenha; //, campoCpf, campoTelefone

    private Button btnCadastrarBD;

    //Instanciar o banco
    private FirebaseAuth autenticacao;

    //Atributo Usuario
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        //Button retorno para Login
        btnLoginReturn = findViewById(R.id.btnLoginReturn);

        btnLoginReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);


            }
        });

        //Recuperando dados da activity.xml
        campoNome = findViewById(R.id.textNome);
        campoEmail = findViewById(R.id.textEmail);

        campoSenha = findViewById(R.id.textSenha);

        btnCadastrarBD = findViewById(R.id.btnCadastrarBD);

        btnCadastrarBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Confirmando que foi digitado algo
                String textoNome = campoNome.getText().toString();
                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();


                // Validar se os campos foram preenchidos
                if ( !textoNome.isEmpty() ){
                    if ( !textoEmail.isEmpty() ){
                        if ( !textoSenha.isEmpty() ){

                            usuario = new Usuario();
                            usuario.setNome( textoNome );
                            usuario.setEmail( textoEmail );
                            usuario.setSenha( textoSenha );
                            cadastrarUsuario();

                        }else{
                            Toast.makeText(Cadastro.this,"Preencha o senha!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Cadastro.this,"Preencha o email!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Cadastro.this,"Preencha o nome!", Toast.LENGTH_SHORT).show();
                }




            }
        });

    }
    public void cadastrarUsuario(){
        // Intancia do objeto firebase que permite cadastrar o usuario.
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao(); //Assim sempre usamos objeto "autenticacao" para salvar os dados em Usuarios e fazer as verificações.
        autenticacao.createUserWithEmailAndPassword( usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if( task.isSuccessful( ) ){
                    Toast.makeText(Cadastro.this,
                            "Cadastro Realizado!",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Cadastro.this,
                            "Erro ao cadastrar usuário!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}
