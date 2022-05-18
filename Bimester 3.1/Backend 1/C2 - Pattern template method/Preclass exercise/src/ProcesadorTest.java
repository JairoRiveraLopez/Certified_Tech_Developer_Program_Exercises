import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorTest {

    @Test
    void Procesar_Pago_Tarjeta_Debito_Test_Positivo() {
        TarjetaDebito DEB001 = new TarjetaDebito("03698587415", 345, 2026, 9, 100.00);
        ProcesadorTarjetaDebito pruebaDebito = new ProcesadorTarjetaDebito();
        assertEquals(pruebaDebito.procesarPago(DEB001, 90.00), "Producto: TarjetaDebito. Pago procesado.");
    }

    @Test
    void Procesar_Pago_Tarjeta_Debito_Test_Negativo_Fecha() {
        TarjetaDebito DEB002 = new TarjetaDebito("03698587345", 345, 2021, 9, 100.00);
        ProcesadorTarjetaDebito pruebaDebito = new ProcesadorTarjetaDebito();
        assertEquals(pruebaDebito.procesarPago(DEB002, 90.00), "Producto: TarjetaDebito. El pago no fue procesado porque la tarjeta esta vencida.");
    }

    @Test
    void Procesar_Pago_Tarjeta_Debito_Test_Negativo_Saldo() {
        TarjetaDebito DEB001 = new TarjetaDebito("03698587415", 345, 2026, 9, 100.00);
        ProcesadorTarjetaDebito pruebaDebito = new ProcesadorTarjetaDebito();
        assertEquals(pruebaDebito.procesarPago(DEB001, 190.00), "Producto: TarjetaDebito. El monto a pagar supera el cupo o el saldo disponible.");
    }

    @Test
    void Procesar_Pago_Tarjeta_Credito_Test_Positivo() {
        TarjetaCredito CRE001 = new TarjetaCredito("19885746369", 002, 2030, 2, 1000.0, 0.0);
        ProcesadorTarjetaCredito pruebaCredito = new ProcesadorTarjetaCredito();
        assertEquals(pruebaCredito.procesarPago(CRE001, 90.00), "Producto: TarjetaCredito. Pago procesado.");
    }

    @Test
    void Procesar_Pago_Tarjeta_Credito_Test_Negativo_Fecha() {
        TarjetaCredito CRE002 = new TarjetaCredito("19885746341", 002, 2020, 2, 1000.0, 0.0);
        ProcesadorTarjetaCredito pruebaCredito = new ProcesadorTarjetaCredito();
        assertEquals(pruebaCredito.procesarPago(CRE002, 90.00), "Producto: TarjetaCredito. El pago no fue procesado porque la tarjeta esta vencida.");
    }

    @Test
    void Procesar_Pago_Tarjeta_Credito_Test_Negativo_Saldo() {
        TarjetaCredito CRE001 = new TarjetaCredito("19885746369", 002, 2030, 2, 1000.0, 0.0);
        ProcesadorTarjetaCredito pruebaCredito = new ProcesadorTarjetaCredito();
        assertEquals(pruebaCredito.procesarPago(CRE001, 1100.00), "Producto: TarjetaCredito. El monto a pagar supera el cupo o el saldo disponible.");
    }

}