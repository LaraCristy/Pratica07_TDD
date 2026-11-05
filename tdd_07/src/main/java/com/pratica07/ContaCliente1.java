
package com.pratica07;

import java.util.Locale;

public class ContaCliente1 {

    private int id;
    private Cliente1 cliente;
    private double saldo;

    public ContaCliente1(int id, Cliente1 cliente, double saldo) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public ContaCliente1(int id, Cliente1 cliente) {
        this(id, cliente, 0.0);
    }

    public ContaCliente1(int id) {
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double addDeposito(double valor) {
        saldo += valor;
        System.out.println("Novo saldo: " + formatarSaldo());
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

        return nomeEIdCliente + " saldo=" + formatarSaldo();
    }

    private String formatarSaldo() {
        return String.format(Locale.ROOT, "R$%.2f", saldo);
    }
}
