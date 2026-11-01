
package com.pratica07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void deveCriarClienteComGeneroPadrao() {
        Cliente1 cliente = new Cliente1(1, "Ana", 10);

        assertEquals(1, cliente.getId());
        assertEquals("Ana", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveCriarClienteComGeneroInformado() {
        Cliente1 cliente = new Cliente1(2, "João", 20, "m");

        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveLancarExcecaoQuandoNomeForNulo() {
        assertThrows(NullPointerException.class,
                () -> new Cliente1(1, null, 10));
    }

    @Test
    void deveLancarExcecaoQuandoGeneroForNulo() {
        assertThrows(NullPointerException.class,
                () -> new Cliente1(1, "Ana", 10, null));
    }

    @Test
    void deveAceitarGeneroF() {
        Cliente1 cliente = new Cliente1(1, "Ana", 10, "f");

        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveAceitarGeneroNd() {
        Cliente1 cliente = new Cliente1(1, "Ana", 10, "nd");

        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveConverterGeneroParaMinusculo() {
        Cliente1 cliente = new Cliente1(1, "Ana", 10, "F");

        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveRemoverEspacosDoGenero() {
        Cliente1 cliente = new Cliente1(1, "Ana", 10, " M ");

        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveLancarExcecaoParaGeneroInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente1(1, "Ana", 10, "x"));
    }

    @Test
    void deveAlterarDesconto() {
        Cliente1 cliente = new Cliente1(1, "Ana", 10);

        cliente.setDesconto(25);

        assertEquals(25, cliente.getDesconto());
    }

    @Test
    void deveAceitarDescontoZero() {
        Cliente1 cliente = new Cliente1(1, "Ana", 0);

        assertEquals(0, cliente.getDesconto());
    }

    @Test
    void deveAceitarDescontoCem() {
        Cliente1 cliente = new Cliente1(1, "Ana", 100);

        assertEquals(100, cliente.getDesconto());
    }

    @Test
    void deveLancarExcecaoParaDescontoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente1(1, "Ana", -1));
    }

    @Test
    void deveLancarExcecaoParaDescontoMaiorQueCem() {
        assertThrows(IllegalArgumentException.class,
                () -> new Cliente1(1, "Ana", 101));
    }

    @Test
    void deveRetornarToStringCorretamente() {
        Cliente1 cliente = new Cliente1(1, "Ana", 15);

        assertEquals("Ana(1)(15%)", cliente.toString());
    }
}
