package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CuentaTest {
    private Cuenta cuenta;

    @Before
    public void setUp() {
        //Inicializamos la cuenta con un saldo de 1000€
        cuenta = new Cuenta(1000);
    }
    @Test
    public void testDepositar(){
        //Deposita 500€ en la cuenta
        cuenta.depositar(500);
        //Verifica que el saldo sea 1500€
        assertEquals(1500, cuenta.getSaldo());
    }
    @Test
    public void testRetirar(){
        //Retira 500€ de la cuenta
        cuenta.retirar(500);
        //Verifica que el saldo sea 500€
        assertEquals(500, cuenta.getSaldo());
    }
    @Test
    public void testSaldoInicial(){
        //Verifica que el saldo inicial sea 1000€
        assertEquals(1000, cuenta.getSaldo());
    }
    @Test
    public void testDepositoConcurrente(){
        //Prueba el depósito concurrente
        for (int i = 0; i < 100; i++) {
            new Thread(() -> cuenta.depositar(10)).start();
        }
        //Espera un momento para que todas las transacciones finalicen
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //El saldo debería ser 1000 + 1000 = 2000€
        assertEquals(2000, cuenta.getSaldo());
    }
    @Test
    public void testRetiroConcurrente(){
        //Prueba el retiro concurrente
        for (int i = 0; i < 100; i++) {
            new Thread(() -> cuenta.retirar(10)).start();
        }
        //Espera un momento para que todas las transacciones finalicen
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //El saldo debería ser 1000 - 1000 = 0€
        assertEquals(0, cuenta.getSaldo());
    }


}