package com.example.myapplication.Classes;

public class Cliente {
    //Variaveis

    private String nome;
    private String apelido;
    private String morada;
    private String email;
    private int contacto;



    private String dataDeNascimento;

    //Construtor
    public Cliente (String nomeRecebido, String emailRecebido, int numeroContactoRecebido){
        this.nome = nomeRecebido;
        this.email = emailRecebido;
        this.apelido = "";
        this.morada = "";
        this.contacto = numeroContactoRecebido;
        this.dataDeNascimento ="";

    }
    //region Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    //endregion

}
