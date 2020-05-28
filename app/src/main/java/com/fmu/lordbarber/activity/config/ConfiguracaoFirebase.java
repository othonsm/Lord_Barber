package com.fmu.lordbarber.activity.config;

import com.google.firebase.auth.FirebaseAuth;

public class ConfiguracaoFirebase {

    /*O "autenticacao" será configurado dentro da instancia.
      O metodo é estatico automaticamente esse atributo será
      o mesmo independente de quantas instancias eu usar.*/
    private static FirebaseAuth autenticacao;


    //retorna a instancia do Firebase
    public static FirebaseAuth getFirebaseAutenticacao(){
        // Verificação
        if( autenticacao == null){
            autenticacao = FirebaseAuth.getInstance();
        }
        return autenticacao;
    }

}
