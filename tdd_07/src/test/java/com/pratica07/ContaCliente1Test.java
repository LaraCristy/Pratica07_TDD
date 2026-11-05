package com.pratica07;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ContaCliente1Test {

    @Test
    void deveCriarContaComTodosOsDados() {
        Cliente1 cliente = new Cliente1(1, "Lara", 10);
        ContaCliente1 conta = new ContaCliente1(8, cliente, 25.5);

        assertEquals(8, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(25.5, conta.getSaldo());
    }

    @Test
    void deveCriarContaComSaldoInicialZero() {
        Cliente1 cliente = new Cliente1(1, "Lara", 10);
        ContaCliente1 conta = new ContaCliente1(8, cliente);

        assertEquals(0.0, conta.getSaldo());
        assertEquals(cliente, conta.getCliente());
    }

    @Test
    void deveCriarContaInformandoSomenteId() {
        ContaCliente1 conta = new ContaCliente1(8);

        assertEquals(8, conta.getId());
        assertNull(conta.getCliente());
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    void devePermitirAlterarClienteESaldo() {
        ContaCliente1 conta = new ContaCliente1(8);
        Cliente1 cliente = new Cliente1(2, "Ana", 15);

        conta.setCliente(cliente);
        conta.setSaldo(50.75);

        assertEquals(cliente, conta.getCliente());
        assertEquals(50.75, conta.getSaldo());
    }

    @Test
    void deveAdicionarDepositoRetornarEMostrarSaldoAtualizado() throws Exception {
        ContaCliente1 conta = new ContaCliente1(8, new Cliente1(1, "Lara", 10), 10.25);
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida, true, "UTF-8"));

            assertEquals(15.5, conta.addDeposito(5.25));
        } finally {
            System.setOut(saidaOriginal);
        }

        assertEquals(15.5, conta.getSaldo());
        assertTrue(saida.toString(StandardCharsets.UTF_8.name()).contains("15.50"));
    }

    @Test
    void deveSubtrairSaldoQuandoHaSaldoSuficiente() {
        ContaCliente1 conta = new ContaCliente1(8, new Cliente1(1, "Lara", 10), 20.0);

        assertEquals(12.5, conta.subSaldo(7.5));
        assertEquals(12.5, conta.getSaldo());
    }

    @Test
    void devePermitirSaqueDoSaldoExato() {
        ContaCliente1 conta = new ContaCliente1(8, new Cliente1(1, "Lara", 10), 20.0);

        assertEquals(0.0, conta.subSaldo(20.0));
    }

    @Test
    void deveAvisarEManterSaldoQuandoSaqueNaoForPossivel() throws Exception {
        ContaCliente1 conta = new ContaCliente1(8, new Cliente1(1, "Lara", 10), 10.0);
        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida, true, "UTF-8"));

            assertEquals(10.0, conta.subSaldo(10.01));
        } finally {
            System.setOut(saidaOriginal);
        }

        assertEquals(10.0, conta.getSaldo());
        assertTrue(saida.toString(StandardCharsets.UTF_8.name())
                .toLowerCase().contains("insuficiente"));
    }

    @Test
    void deveExibirNomeIdESaldoComDuasCasasDecimais() {
        Cliente1 cliente = new Cliente1(1, "Lara", 10);
        ContaCliente1 conta = new ContaCliente1(8, cliente, 1234.5);

        assertEquals("Lara(1) saldo=R$1234.50", conta.toString());
    }
}
