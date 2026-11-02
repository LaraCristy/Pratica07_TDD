package com.pratica07;

/**
 * Representa um cliente do sistema.
 */
public class Cliente {
    private int id;
    private String nome;
    private int desconto;
    private String genero;

    public Cliente(int id, String nome, int desconto) {
        this(id, nome, desconto, "nd");
    }

    public Cliente(int id, String nome, int desconto, String genero) {
        if (nome == null) {
            throw new NullPointerException("O nome não pode ser nulo.");
        }

        this.id = id;
        this.nome = nome;
        setDesconto(desconto);
        setGenero(genero);
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
        if (desconto < 0 || desconto > 100) {
            throw new IllegalArgumentException(
                    "O desconto deve estar entre 0 e 100.");
        }

        this.desconto = desconto;
    }

    private void setGenero(String genero) {
        if (genero == null) {
            throw new NullPointerException("O gênero não pode ser nulo.");
        }

        genero = genero.trim().toLowerCase();

        if (!generoValido(genero)) {
            throw new IllegalArgumentException("Gênero inválido.");
        }

        this.genero = genero;
    }

    private boolean generoValido(String genero) {
        return genero.equals("m")
                || genero.equals("f")
                || genero.equals("nd");
    }
    @Override
    public String toString() {
    return nome + "(" + id + ")(" + desconto + "%)";
    }
}