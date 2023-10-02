package org.example;

import java.util.Random;

public class HiloCliente implements Runnable{
    private Cuenta cuenta;
    private Random random = new Random(); //Generador de números aleatorios

    //Constructor que recibe la cuenta en la que se realizarán las transacciones
    public HiloCliente(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    //Método que se ejecuta cuando se inicia el hilo
    @Override
    public void run() {
        //Realiza 400 depósitos de 100€ cada uno
        for (int i = 0; i < 400; i++) {
            cuenta.depositar(100);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //Realiza 200 depósitos de 50€ cada uno
        for (int i = 0; i < 200; i++) {
            cuenta.depositar(50);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Realiza 600 depósitos de 20€ cada uno
        for (int i = 0; i < 600; i++) {
            cuenta.depositar(20);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Realiza 400 retiradas de 100€ cada una
        for (int i = 0; i < 400; i++) {
            cuenta.retirar(100);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Realiza 200 retiradas de 50€ cada una
        for (int i = 0; i < 200; i++) {
            cuenta.retirar(50);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Realiza 600 retiradas de 20€ cada una
        for (int i = 0; i < 600; i++) {
            cuenta.retirar(20);
            try {
                Thread.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
