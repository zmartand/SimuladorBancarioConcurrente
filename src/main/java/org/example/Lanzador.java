package org.example;

public class Lanzador {
    public static void main(String[] args){
        //Crea una cuenta con un saldo inicial de 10.000€
        Cuenta cuenta = new Cuenta(10000);
        //Arreglo de hilos de clientes
        HiloCliente[] hilos = new HiloCliente[10];
        //Inicializa y lanza los hilos de los clientes
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new HiloCliente(cuenta);
            Thread hilo = new Thread(hilos[i]);
            hilo.start();
        }
        //Espera a que terminen todos los hilos
        for (int i = 0; i < hilos.length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Obtiene el saldo final de la cuenta
        int saldoFinal = cuenta.getSaldo();
        //Verifica si el saldo final es 10.000€
        if (saldoFinal == 10000) {
            System.out.println("El saldo final es correcto: " + saldoFinal + "€");
        } else {
            System.out.println("El saldo final es incorrecto: " + saldoFinal + "€");
        }

    }
}
