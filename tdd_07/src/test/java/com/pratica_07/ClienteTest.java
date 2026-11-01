
package com.pratica_07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    @Test
    void deveRetornarIdDoCliente() {
        Cliente cliente = new Cliente(1, "Lara", 10);

        assertEquals(1, cliente.getId());
    }
    @Test
    void deveRetornarDadosDoCliente() {
    Cliente cliente = new Cliente(1, "Lara", 10);

    assertEquals("Lara[1,Lara,10]", cliente.toString());
    }
}
