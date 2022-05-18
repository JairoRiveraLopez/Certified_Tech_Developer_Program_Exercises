
import java.time.YearMonth;
public abstract class Procesador {

    public String procesarPago (Tarjeta t, Double monto){
        String mensaje = "";
        Boolean validoSaldo = autorizarPorSaldo(t,monto);
        Boolean validoFecha = validarFecha(t);

        if(validoFecha && validoSaldo){
            mensaje = "Producto: " + t.getClass().getSimpleName() + ". Pago procesado.";
        } else if (!validoFecha && validoSaldo){
            mensaje = "Producto: " + t.getClass().getSimpleName() + ". El pago no fue procesado porque la tarjeta esta vencida.";
        } else if (validoFecha && !validoSaldo){
            mensaje = "Producto: " + t.getClass().getSimpleName() + ". El monto a pagar supera el cupo o el saldo disponible.";
        } else{
            mensaje = "Producto: " + t.getClass().getSimpleName() + ". El pago no fue procesado porque la tarjeta esta vencida y porque el monto a pagar supera el cupo o el saldo disponible.";
        }

        return mensaje;

    }
    protected abstract Boolean autorizarPorSaldo(Tarjeta t, Double monto);

    public Boolean validarFecha (Tarjeta t){
        Boolean procederConPago = false;
        if(t.getFechaExpiracion().compareTo(YearMonth.now()) >= 0){
            procederConPago = true;
        }
        return procederConPago;
    }



}
