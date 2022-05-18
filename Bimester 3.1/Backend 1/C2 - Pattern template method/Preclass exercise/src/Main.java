public class Main {
    public static void main(String[] args) {
        TarjetaDebito DEB001 = new TarjetaDebito("03698587415", 345, 2026, 9, 100.00);
        TarjetaCredito CRE001 = new TarjetaCredito("19885746369", 002, 2030, 2, 1000.0, 0.0);

        TarjetaDebito DEB002 = new TarjetaDebito("03698587345", 345, 2021, 9, 100.00);
        TarjetaCredito CRE002 = new TarjetaCredito("19885746341", 002, 2020, 2, 1000.0, 0.0);

        ProcesadorTarjetaDebito pruebaDebito = new ProcesadorTarjetaDebito();
        System.out.println(pruebaDebito.procesarPago(DEB001, 19.0));
        System.out.println(pruebaDebito.procesarPago(DEB001, 190.0));
        System.out.println(pruebaDebito.procesarPago(DEB002, 19.0));
        System.out.println(pruebaDebito.procesarPago(DEB002, 190.0));

        ProcesadorTarjetaCredito pruebaCredito = new ProcesadorTarjetaCredito();
        System.out.println(pruebaCredito.procesarPago(CRE001, 19.0));
        System.out.println(pruebaCredito.procesarPago(CRE001, 1200.0));
        System.out.println(pruebaCredito.procesarPago(CRE002, 50.0));
        System.out.println(pruebaCredito.procesarPago(CRE002, 1100.0));

    }
}
