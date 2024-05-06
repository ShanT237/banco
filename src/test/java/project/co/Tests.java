package project.co;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import project.co.CuentaAhorros;
import project.co.CuentaBancaria;
import project.co.CuentaCorriente;
import project.co.Titular;

public class Tests {

    @Test
    public void assertion() {

    }

    @Test
    public void retiroMayor() {
        Collection<CuentaBancaria> cuentas = new ArrayList<>();

        var cuenta = new CuentaAhorros("Santiago", "Torres", "4747", 3.000, 5);

        assertThrows(Throwable.class, () -> {
            cuenta.retirar(6.000);
        });

        System.out.println(cuenta.toString());

    }

    @Test
    public void retiroNegativo() {
        var cuenta = new CuentaAhorros("Arquimedes", "Poincaré", "33", 3.1415, 2.7182);

        assertThrows(Throwable.class, () -> {
            cuenta.retirar(-6.000);
        });

    }

    @Test
    public void depositoEntreCuentas() {
        CuentaBancaria cuenta = new CuentaAhorros("Albert", "Einstein", "123", 5.000, 10.0);
        CuentaBancaria cuenta1 = new CuentaAhorros("Santiago", "Fayman", "223", 5.000, 10.0);

        Transaccion transaccion = new Transaccion(1, 2.000, "Depósito de dinero");

        assertEquals(2.000, transaccion.depositarEntreCuentas(cuenta, cuenta1));

    }

    @Test
    public void verificarCuentasNoNull() {
        CuentaBancaria cuentaOrigen = new CuentaAhorros("Albert", "Einstein", "123", 5000.0, 10.0);
        CuentaBancaria cuentaDestino = new CuentaAhorros("Santiago", "Fayman", "223", 5000.0, 10.0);

        boolean resultado = Transaccion.verificarCuentas(cuentaOrigen, cuentaDestino);

        // Verificar que el resultado no sea null
        assertNotNull(resultado);
    }

    @Test
    public void estadoActivo() {
        CuentaBancaria cuenta = new CuentaAhorros("Albert", "Einstein", "123", 5000.0, 10.0);
        cuenta.activarCuenta(); // Activar la cuenta

        boolean estado = cuenta.isEstado();

        // Verificar que el estado de la cuenta sea activo
        assertTrue(estado);
    }

}
