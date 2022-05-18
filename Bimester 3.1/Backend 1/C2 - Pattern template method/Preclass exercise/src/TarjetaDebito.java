public class TarjetaDebito extends Tarjeta{
    private Double saldoDisponible;

    public TarjetaDebito(String numerosFrente, Integer codigoSeguridad, int year, int month, Double saldoDisponible) {
        super(numerosFrente, codigoSeguridad, year, month);
        this.saldoDisponible = saldoDisponible;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void reducirSaldoDisponible(Double monto) {
        saldoDisponible -= monto;
    }


}
