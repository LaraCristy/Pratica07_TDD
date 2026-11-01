
package com.pratica07;

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

    // Testes adicionais criados pela dupla

    @Test
    void deveAceitarGeneroM() {
        Cliente cliente = new Cliente(2, "João", 20, "m");

        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveAceitarGeneroNd() {
        Cliente cliente = new Cliente(1, "Ana", 10, "nd");

        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(NullPointerException.class,
                () -> new Cliente(1, null, 10));
    }

    @Test
    void deveLancarExcecaoQuandoGeneroForNulo() {
        assertThrows(NullPointerException.class,
                () -> new Cliente(1, "Ana", 10, null));
    }

    @Test
    void deveConverterGeneroParaMinusculo() {
        Cliente cliente = new Cliente(1, "Ana", 10, "F");

        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveRemoverEspacosDoGenero() {
        Cliente cliente = new Cliente(1, "Ana", 10, " M ");

        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveLancarExcecaoParaGeneroInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente(1, "Ana", 10, "x"));
    }

    @Test
    void deveLancarExcecaoParaDescontoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente(1, "Ana", -1));
    }

    @Test
    void deveLancarExcecaoParaDescontoMaiorQueCem() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente(1, "Ana", 101));
    }
}
