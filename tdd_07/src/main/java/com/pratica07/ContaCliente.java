
package com.pratica07;

import java.util.Locale;

public class ContaCliente {

    private int id;
    private Cliente cliente;
    private double saldo;

    public ContaCliente(int id, Cliente cliente, double saldo) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public ContaCliente(int id, Cliente cliente) {
        this(id, cliente, 0.0);
    }

    public ContaCliente(int id) {
        this(id, null, 0.0);
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double addDeposito(double valor) {
        saldo += valor;
        System.out.println(String.format(
                Locale.ROOT, "Novo saldo: R$%.2f", saldo));
        return saldo;
    }

    public double subSaldo(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return saldo;
        }

        saldo -= valor;
        return saldo;
    }

    @Override
    public String toString() {
        String nomeEIdCliente = cliente == null
                ? "null"
                : cliente.getNome() + "(" + cliente.getId() + ")";

        return String.format(
                Locale.ROOT, "%s saldo=R$%.2f", nomeEIdCliente, saldo);
    }
}
