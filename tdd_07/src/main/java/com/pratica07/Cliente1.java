
package com.pratica07;

import java.util.Locale;
import java.util.Objects;

/**
 * Representa um cliente do sistema.
 */
public class Cliente1 {

    private static final String GENERO_PADRAO = "nd";
    private static final int DESCONTO_MINIMO = 0;
    private static final int DESCONTO_MAXIMO = 100;

    private int id;
    private String nome;
    private int desconto;
    private String genero;

    public Cliente1(int id, String nome, int desconto) {
        this(id, nome, desconto, GENERO_PADRAO);
    }

    public Cliente1(int id, String nome, int desconto, String genero) {
        this.id = id;
        this.nome = Objects.requireNonNull(
                nome, "O nome não pode ser nulo.");

        setDesconto(desconto);
        setGenero(genero);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getDesconto() {
        return desconto;
    }

    public String getGenero() {
        return genero;
    }

    public void setDesconto(int desconto) {
        if (desconto < DESCONTO_MINIMO
                || desconto > DESCONTO_MAXIMO) {
            throw new IllegalArgumentException(
                    "O desconto deve estar entre 0 e 100.");
        }

        this.desconto = desconto;
    }

    private void setGenero(String genero) {
        Objects.requireNonNull(
                genero, "O gênero não pode ser nulo.");

        String generoNormalizado =
                genero.trim().toLowerCase(Locale.ROOT);

        if (!generoNormalizado.equals("m")
                && !generoNormalizado.equals("f")
                && !generoNormalizado.equals(GENERO_PADRAO)) {
            throw new IllegalArgumentException("Gênero inválido.");
        }

        this.genero = generoNormalizado;
    }

    @Override
    public String toString() {
        return String.format(
                Locale.ROOT,
                "%s(%d)(%d%%)",
                nome,
                id,
                desconto);
    }
}
