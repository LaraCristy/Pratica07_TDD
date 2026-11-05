
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

    @Test
    void deveRetornarDadosDaFatura() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);

    assertEquals(
        "Fatura [id=1, cliente=Lara(1)(10%), valor=100.0 ]",
        fatura.toString()
    );
    }

}
