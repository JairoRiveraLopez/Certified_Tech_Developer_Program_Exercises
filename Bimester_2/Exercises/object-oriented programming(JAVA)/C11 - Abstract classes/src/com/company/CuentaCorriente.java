package com.company;

public class CuentaCorriente extends Cuenta {

    private Double saldo;
    private Double descubierto;

    public CuentaCorriente(Double saldo, Double descubierto) {
        this.saldo = saldo;
        this.descubierto = descubierto;
    }

    @Override
    public void depositar(Double monto) {
        this.saldo += monto;
    }

    @Override
    public void extraerEfectivo(Double monto) {

        if ((saldo + descubierto) >= monto) {
            this.saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void informarSaldo() {
        System.out.println("El saldo de la cuenta corriente es " + this.saldo);
    }

}
