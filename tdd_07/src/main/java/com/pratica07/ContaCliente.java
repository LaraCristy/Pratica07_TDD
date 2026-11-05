
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
    if (valor < 0) {
        throw new IllegalArgumentException("O deposito nao pode ser negativo.");
    }

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
