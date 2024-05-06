package project.co;

import java.time.LocalDate;

public class Transaccion {
    private int codigo;
    private double valor;
    private LocalDate fechaActual;
    private String descripcion;
    public double getValor;

    public Transaccion(int codigo, double valor, String descripcion) {
        this.codigo = codigo;
        this.valor = valor;
        this.fechaActual = LocalDate.now();
        this.descripcion = descripcion;
    }
    public double depositarEntreCuentas(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        if (verificarCuentas(cuentaOrigen, cuentaDestino)) {
            if (cuentaOrigen.getSaldo() >= valor) {
                cuentaOrigen.retirar(valor);
                cuentaDestino.depositar(valor);
                System.out.println("Depósito exitoso de " + valor + " desde la cuenta " + cuentaOrigen.getNumeroCuenta() + " a la cuenta " + cuentaDestino.getNumeroCuenta());
                return valor;
            } else {
                System.out.println("La cuenta origen no tiene suficientes fondos para realizar el depósito.");
            }
        }
        return 0.0; 
    }
    
    public double retirarEntreCuentas(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        if (verificarCuentas(cuentaOrigen, cuentaDestino)) {
            if (cuentaOrigen.getSaldo() >= valor) {
                cuentaOrigen.retirar(valor);
                cuentaDestino.depositar(valor);
                System.out.println("Retiro exitoso de " + valor + " desde la cuenta " + cuentaOrigen.getNumeroCuenta() + " a la cuenta " + cuentaDestino.getNumeroCuenta());
                return valor;
            } else {
                System.out.println("La cuenta origen no tiene suficientes fondos para realizar el retiro.");
            }
        }
        return 0.0; // Retornar 0 si la transacción no se pudo realizar
    }
    public static boolean verificarCuentas(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino) {
        if (cuentaOrigen == null) {
            System.out.println("No se puede realizar la transacción. La cuenta origen no existe o está inactiva.");
            return false;
        }
        if (cuentaDestino == null) {
            System.out.println("No se puede realizar la transacción. La cuenta destino no existe o está inactiva.");
            return false;
        }
        return true;
    }


    
}
