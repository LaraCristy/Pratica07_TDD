
package com.pratica_07;

public class Cliente {
    private int id;
    private String nome;
    private int desconto;
    private String genero;

    public Cliente(int id, String nome, int desconto) {
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
    }

    public Cliente(int id, String nome, int desconto, String genero) {
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "";
    }
}
