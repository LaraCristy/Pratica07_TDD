
package com.pratica_07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComTresParametros() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        assertEquals(1, cliente.getId());
        assertEquals("Lara", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveCriarClienteComQuatroParametros() {
        Cliente cliente = new Cliente(2, "Ana", 20, "f");

        assertEquals(2, cliente.getId());
        assertEquals("Ana", cliente.getNome());
        assertEquals(20, cliente.getDesconto());
        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveRetornarIdDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        assertEquals(1, cliente.getId());
    }

    @Test
    void deveRetornarNomeDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        assertEquals("Lara", cliente.getNome());
    }

    @Test
    void deveRetornarGeneroDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10, "f");

        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveRetornarDescontoDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        assertEquals(10, cliente.getDesconto());
    }

    @Test
    void deveAlterarDescontoDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        cliente.setDesconto(20);

        assertEquals(20, cliente.getDesconto());
    }

    @Test
    void deveAceitarDescontoMinimo() {
        Cliente cliente = new Cliente(1, "Lara", 0);

        assertEquals(0, cliente.getDesconto());
    }

    @Test
    void deveAceitarDescontoMaximo() {
        Cliente cliente = new Cliente(1, "Lara", 100);

        assertEquals(100, cliente.getDesconto());
    }

    @Test
    void deveRetornarDadosDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        assertEquals("Lara[1,Lara,10]", cliente.toString());
    }
}
