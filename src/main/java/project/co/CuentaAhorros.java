package project.co;

public class CuentaAhorros extends CuentaBancaria{
    double tasaInteresAnual;

    public CuentaAhorros(String nombre, String apellidos, String numero, double saldo, double tasaInteres) {
        super(nombre, apellidos, numero, saldo);
        this.tasaInteresAnual = tasaInteres;
    }

    public void retirar(double valor){
        assert valor > 0 : "No se puede sacar un valor negativo";
        assert valor <= saldo : "Saldo insuficiente ";
        saldo = saldo - valor;

        if (saldo == 0){
        estado = false;
        }
    }

    public double calcularIntereses(int meses) {
        double tasaInteresMensual = tasaInteresAnual / 12.0 / 100.0;

        return saldo * Math.pow(1 + tasaInteresMensual, meses) - saldo;
    }

    // Método para agregar intereses al saldo
    public void agregarIntereses(int meses) {
        double intereses = calcularIntereses(meses);
        saldo += intereses;
    }
    
    
}
