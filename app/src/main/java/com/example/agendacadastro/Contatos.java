package com.example.agendacadastro;

import java.io.Serializable;

public class Contatos implements Serializable{
    //aributos
    private String nome, endereco, telefone;

    //construtor
    public Contatos(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    //geters
    public String getNome() {

        return nome;
    }

    //metodos
    public String mostrarDados(){
        return "\nNome: " + nome + "\nEndereo: " + endereco + "\nTelefone: " + telefone;
    }

}
