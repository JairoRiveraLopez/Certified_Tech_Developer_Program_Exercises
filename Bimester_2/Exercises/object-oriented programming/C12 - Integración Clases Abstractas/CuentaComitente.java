package com.company.cuentas;

import com.company.Cliente;

public class CuentaComitente extends Cuenta {
    private String cnv;

    public CuentaComitente(Cliente titular, Double saldo, String cnv) {
        super(titular, saldo);
        this.cnv = cnv;
    }

    @Override
    public void depositar(Double monto){
        super.depositar(monto*0.99);

    }

    @Override
    public void extraer(Double monto){
        if (monto <= (getSaldo()*0.5)){
            super.extraer(monto);
        }
        else {
            System.out.println("no podes retirar ese monto");
        }
    }


    public void extraer(Double monto, String cnv){
        if (this.cnv.equals(cnv)){
            super.extraer(monto);
        }
        else {
            System.out.println("la clave es incorrecta");
        }

    }

    public Boolean puedeExtraer(Double monto){
        return getSaldo() >= monto;
    }
}
