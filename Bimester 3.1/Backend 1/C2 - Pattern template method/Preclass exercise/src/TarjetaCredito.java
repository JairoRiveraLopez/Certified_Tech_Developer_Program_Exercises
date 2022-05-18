public class TarjetaCredito extends Tarjeta{
    private Double cupoLimite;
    private Double saldoUtilizado;

    public TarjetaCredito(String numerosFrente, Integer codigoSeguridad, int year, int month, Double cupoLimite, Double saldoUtilizado) {
        super(numerosFrente, codigoSeguridad, year, month);
        this.cupoLimite = cupoLimite;
        this.saldoUtilizado = saldoUtilizado;
    }



    public Double getCupoLimite() {
        return cupoLimite;
    }

    public void setCupoLimite(Double cupoLimite) {
        this.cupoLimite = cupoLimite;
    }

    public Double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void aumentarSaldoUtilizado(Double monto) {
        this.saldoUtilizado += monto;
    }
}
