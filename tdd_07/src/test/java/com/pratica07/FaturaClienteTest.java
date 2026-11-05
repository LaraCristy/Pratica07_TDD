
package com.pratica07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FaturaClienteTest {

    @Test
    void deveCriarFaturaComTresParametros() {
        Cliente cliente = new Cliente(1, "Lara", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);

        assertEquals(1, fatura.getId());
        assertEquals(cliente, fatura.getCliente());
        assertEquals(100.0, fatura.getValor());
    }
    
    @Test
    void deveCalcularValorComDesconto() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);

    assertEquals(90.0, fatura.getValorComDesconto());
    }

}
