package com.pratica07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class FaturaClienteTest {

    @Test
    void deveCriarFaturaComTodosOsDados() {
        Cliente cliente = new Cliente(1, "Lara", 10);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 200.0);

        assertEquals(7, fatura.getId());
        assertEquals(cliente, fatura.getCliente());
        assertEquals(200.0, fatura.getValor());
    }

    @Test
    void deveCriarFaturaInformandoSomenteId() {
        FaturaCliente fatura = new FaturaCliente(7);

        assertEquals(7, fatura.getId());
        assertNull(fatura.getCliente());
        assertEquals(0.0, fatura.getValor());
    }

    @Test
    void devePermitirAlterarClienteEValor() {
        FaturaCliente fatura = new FaturaCliente(7);
        Cliente cliente = new Cliente(2, "Ana", 15);

        fatura.setCliente(cliente);
        fatura.setValor(80.5);

        assertEquals(cliente, fatura.getCliente());
        assertEquals(80.5, fatura.getValor());
    }

    @Test
    void deveCalcularValorComDescontoDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 25);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 200.0);

        assertEquals(150.0, fatura.getValorComDesconto());
    }

    @Test
    void deveRetornarValorIntegralQuandoDescontoForZero() {
        Cliente cliente = new Cliente(1, "Lara", 0);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 120.0);

        assertEquals(120.0, fatura.getValorComDesconto());
    }

    @Test
    void deveRetornarZeroQuandoDescontoForCemPorCento() {
        Cliente cliente = new Cliente(1, "Lara", 100);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 120.0);

        assertEquals(0.0, fatura.getValorComDesconto());
    }

    @Test
    void deveRetornarDadosDaFatura() {
        Cliente cliente = new Cliente(1, "Lara", 10);
        FaturaCliente fatura = new FaturaCliente(7, cliente, 120.5);

        assertEquals(
                "Fatura [id=7, cliente=Lara(1)(10%), valor=120.5 ]",
                fatura.toString());
    }
}
