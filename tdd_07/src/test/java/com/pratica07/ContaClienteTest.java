
package com.pratica07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaClienteTest {

    @Test
    void deveAdicionarDeposito() {
        Cliente cliente = new Cliente(1, "Lara", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);

        assertEquals(150.0, conta.addDeposito(50.0));
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    void deveSubtrairSaldo() {
        Cliente cliente = new Cliente(1, "Lara", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);

        assertEquals(60.0, conta.subSaldo(40.0));
        assertEquals(60.0, conta.getSaldo());
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {
        Cliente cliente = new Cliente(1, "Lara", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);

        assertEquals(100.0, conta.subSaldo(150.0));
        assertEquals(100.0, conta.getSaldo());
    }
    
@Test
void deveCriarContaComTresParametros() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    ContaCliente conta = new ContaCliente(1, cliente, 100.0);

    assertEquals(1, conta.getId());
    assertEquals(cliente, conta.getCliente());
    assertEquals(100.0, conta.getSaldo());
}

@Test
void deveCriarContaComDoisParametros() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    ContaCliente conta = new ContaCliente(1, cliente);

    assertEquals(1, conta.getId());
    assertEquals(cliente, conta.getCliente());
    assertEquals(0.0, conta.getSaldo());
}

@Test
void deveCriarContaComApenasId() {
    ContaCliente conta = new ContaCliente(1);

    assertEquals(1, conta.getId());
    assertNull(conta.getCliente());
    assertEquals(0.0, conta.getSaldo());
}

@Test
void deveAlterarClienteDaConta() {
    ContaCliente conta = new ContaCliente(1);
    Cliente cliente = new Cliente(2, "Ana", 20);

    conta.setCliente(cliente);

    assertEquals(cliente, conta.getCliente());
}

@Test
void deveAlterarSaldoDaConta() {
    ContaCliente conta = new ContaCliente(1);

    conta.setSaldo(200.0);

    assertEquals(200.0, conta.getSaldo());
}

@Test
void deveRetornarDadosDaConta() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    ContaCliente conta = new ContaCliente(1, cliente, 100.0);

    assertEquals("Lara(1) saldo=R$100.00", conta.toString());
}

@Test
void devePermitirSaqueIgualAoSaldo() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    ContaCliente conta = new ContaCliente(1, cliente, 100.0);

    assertEquals(0.0, conta.subSaldo(100.0));
    assertEquals(0.0, conta.getSaldo());
}

@Test
void deveAvisarQuandoSaldoForInsuficiente() {
    Cliente cliente = new Cliente(1, "Lara", 10);
    ContaCliente conta = new ContaCliente(1, cliente, 100.0);

    java.io.ByteArrayOutputStream saida =
            new java.io.ByteArrayOutputStream();
    java.io.PrintStream original = System.out;

    try {
        System.setOut(new java.io.PrintStream(saida));

        conta.subSaldo(150.0);

        assertTrue(saida.toString().contains("Saldo insuficiente"));
    } finally {
        System.setOut(original);
    }
}

}
