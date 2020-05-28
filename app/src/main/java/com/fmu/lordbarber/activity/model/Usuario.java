package com.fmu.lordbarber.activity.model;

public class Usuario {
    private String nome;
    private String email;
    private String senha;


    //Contrutor Usuario
    //Com construtor vazio consigo configura o nome e a senha direto no objeto (email e senha)

    public Usuario() {

    }

    // Gets and Sets Usuario

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
