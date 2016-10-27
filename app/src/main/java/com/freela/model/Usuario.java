package com.freela.model;

import android.support.annotation.ColorRes;

import java.io.Serializable;

/**
 * Created by Gabriel on 27/10/2016.
 */

public class Usuario implements Serializable {
    private String email;
    private String nome;
    private Localizacao localizacao;

    public Usuario() {}

    public  Usuario(String email, String nome, Localizacao localizacao) {
        this.email = email;
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}