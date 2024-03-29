package com.freela.model;



import java.io.Serializable;

/**
 * Created by Gabriel on 27/10/2016.
 */

public class Usuario implements Serializable {
    private int id;
    private String email;
    private String nome;
    private Papel papel;
    private String senha;

    public Usuario() {}

    public Usuario(int id, String email, String nome, String senha) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }
    public Usuario(int id, String email, String nome, Papel papel, String senha) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.papel = papel;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
}
