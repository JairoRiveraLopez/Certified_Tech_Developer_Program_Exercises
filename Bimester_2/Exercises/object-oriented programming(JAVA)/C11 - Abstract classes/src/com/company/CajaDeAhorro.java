package com.company;

public class CajaDeAhorro extends Cuenta {

    private Double tasaInteres;
    private Double saldo;

    public CajaDeAhorro(Double saldo, Double tasaInteres) {
        this.saldo = saldo;
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void depositar(Double monto) {
        this.saldo += monto;
    }

    @Override
    public void extraerEfectivo(Double monto) {

        if (saldo >= monto) {
            this.saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void cobrarInteres() {
        saldo *= tasaInteres;
    }

    @Override
    public void informarSaldo() {
        System.out.println("El saldo de la caja de ahorros es " + this.saldo);
    }
}
