package project.co;

public abstract class CuentaBancaria {
    String nombreTitular;
    String apellidos;
    String numeroCuenta;
    double saldo;
    boolean estado;

    public CuentaBancaria(String nombre, String apellidos, String numero, double saldo) {
        this.nombreTitular = nombre;
        this.apellidos = apellidos;
        this.numeroCuenta = numero;
        this.saldo = saldo;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        assert valor > 0 : "El saldo debe ser de valor positivo";
        this.saldo += valor;
        estado = true;
    }

    public abstract void retirar(double valor);

    // Metodo: verifica el estado de la cuenta y retorno un valor
    public String estadoCuenta() {
        String estadoCuenta;

        if (estado == true) {
            estadoCuenta = "Activo";
        } else {
            estadoCuenta = "Inactivo";
        }

        return estadoCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [Nombre del Titular: " + nombreTitular + ", Apellidos: " + apellidos
                + ", Numero de Cuenta: " + numeroCuenta + ", Saldo: " + String.format("%.3f", saldo) + "]";
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void activarCuenta() {
        estado = true;
    }
    

}
