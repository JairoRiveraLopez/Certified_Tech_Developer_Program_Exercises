package Resolucion_ejerciciopreclase_patronfacade;

public class ServicioCaja {
    public void entregarDinero(Cuenta cuenta, Double saldoARetirar){
        Double nuevoSaldo;
        if(cuenta.getSaldo() >= saldoARetirar){
            nuevoSaldo = cuenta.getSaldo() - saldoARetirar;
            System.out.println("Se ha retirado el valor de " + saldoARetirar + ". Su nuevo saldo es: " + nuevoSaldo + ".");
            cuenta.setSaldo(nuevoSaldo);
        }else{
            System.out.println("No es posible retirar saldo ya que el valor ingresado supera la cantidad que tiene en su cuenta.");
        }
    }
}
