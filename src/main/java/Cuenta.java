public class Cuenta {
    private int saldo;

    //Constructor que inicializa el saldo
    public Cuenta(int saldo) {
        this.saldo = saldo;
    }

    //Método sincronizado para depositar dinero en la cuenta
    public synchronized void depositar(int cantidad) {
        saldo += cantidad;
        System.out.println("Depositando " + cantidad + "€");
        System.out.println("Saldo actual: " + saldo + "€");
        notifyAll();
    }
    //Método sincronizado para retirar dinero de la cuenta
    public synchronized void retirar(int cantidad) {
        while (saldo < cantidad) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        saldo -= cantidad;
        System.out.println("Retirando " + cantidad + "€");
        System.out.println("Saldo actual: " + saldo + "€");
    }
    //Método sincronizado para consultar el saldo actual de la cuenta
    public synchronized void getSaldo() {
        System.out.println("Saldo actual: " + saldo + "€");
    }

}
