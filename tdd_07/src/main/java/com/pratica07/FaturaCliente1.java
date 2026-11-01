
package com.pratica07;

public class FaturaCliente1 {
    private int id;
    private Cliente1 cliente;
    private double valor;

    public FaturaCliente1(int id, Cliente1 cliente, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
    }

    public FaturaCliente1(int id) {
        this(id, null, 0.0);
    }

    public int getId() {
        return id;
    }

    public Cliente1 getCliente() {
        return cliente;
    }

    public void setCliente(Cliente1 cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorComDesconto() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "";
    }
}
