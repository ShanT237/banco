package project.co;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<CuentaBancaria> cuentas = new ArrayList<>();

        var cuenta = new CuentaAhorros("Santiago", "Torres", "4747", 3.000, 5);
        cuentas.add(cuenta);
        var cuentaAho = new CuentaAhorros("Philip", "Churchil", "4247", 20.000, 5);
        cuentas.add(cuentaAho);

        var cuenta1 = new CuentaCorriente("Alan", "Quintero", "4748", 5.000, 3.000);
        var cuenta2 = new CuentaCorriente("Josefino", "Uchua", "3447", 3.000, 5.000);
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);

        cuenta.retirar(1.000);
        cuentaAho.depositar(1);

        cuenta1.depositar(3.000);
        cuenta2.retirar(3.000);

        Titular titular = new Titular(cuentas);

        titular.mostrarListaNombres();

        System.out.println("\n" + cuenta.toString());
        System.out.println(cuentaAho.toString());
        System.out.println(cuenta1.toString());
        System.out.println(cuenta2.toString());

    System.out.println("\n" + cuenta.estadoCuenta());
    System.out.println("\n" + cuentaAho.estadoCuenta());
    }
}
