public class ProcesadorTarjetaCredito extends Procesador{
    @Override
    protected Boolean autorizarPorSaldo(Tarjeta t, Double monto) {
        Boolean procederConPago = false;
            if(t instanceof TarjetaCredito){
                TarjetaCredito tarjetaCredito = (TarjetaCredito) t;
                    if(monto < (tarjetaCredito.getCupoLimite()-tarjetaCredito.getSaldoUtilizado())){
                    procederConPago = true;
                    }
    }
            return procederConPago;
    }
}
