public class ProcesadorTarjetaDebito extends Procesador{
    @Override
    protected Boolean autorizarPorSaldo(Tarjeta t, Double monto) {
        Boolean procederConPago = false;
        if(t instanceof TarjetaDebito){
            TarjetaDebito tarjetaDebito = (TarjetaDebito) t;
            if(tarjetaDebito.getSaldoDisponible() >= monto){
                procederConPago = true;
            }
        }
        return procederConPago;
    }
}
