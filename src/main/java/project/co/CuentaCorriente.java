package project.co;

public class CuentaCorriente extends CuentaBancaria{
    double sobregiro;

    public CuentaCorriente(String nombre, String apellidos, String numero, double saldo, double sobregiro) {
        super(nombre, apellidos, numero, saldo);
        this.sobregiro = sobregiro;
    }

    /**
     * Withdraws money from a bank account.
     * 
     * @param valor The amount to be withdrawn from the account.
     * @throws IllegalArgumentException If the withdrawal amount is negative or exceeds the available balance.
     */
    @Override
    public void retirar(double valor) {
        assert valor > 0 : "El valor del retiro debe ser positivo";

        double totalAvailableBalance = saldo + sobregiro;

        if (valor > totalAvailableBalance) {
            throw new IllegalArgumentException("El retiro excede la cantidad disponible en la cuenta");
        }

        if (valor > saldo) {
            double overdraftUsed = valor - saldo;
            saldo = 0;
            sobregiro -= overdraftUsed;
        } else {
            saldo -= valor;
        }

        if (saldo == 0) {
            estado = false;
        }
    }
}
    
