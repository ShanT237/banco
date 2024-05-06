package project.co;

import java.util.Collection;

public class Titular {
    private Collection<CuentaBancaria> cuentas;

    public Titular(Collection<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }

    public void agregarNombreCompleto(CuentaBancaria cuenta) {
        String nombreCompleto = cuenta.getNombreTitular() + " " + cuenta.getApellidos();
        System.out.println("Agregando a la lista: " + nombreCompleto);
        
    }

    public void mostrarListaNombres() {
        System.out.println("Lista de nombres completos de los titulares:");
        for (CuentaBancaria cuenta : cuentas) {
            String nombreCompleto = cuenta.getNombreTitular() + " " + cuenta.getApellidos();
            System.out.println(nombreCompleto);
        }
    }
}