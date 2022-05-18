import java.time.YearMonth;

public abstract class Tarjeta {

    private String numerosFrente;
    private Integer codigoSeguridad;
    private YearMonth fechaExpiracion;

    public Tarjeta(String numerosFrente, Integer codigoSeguridad, int year, int month) {
        this.numerosFrente = numerosFrente;
        this.codigoSeguridad = codigoSeguridad;
        fechaExpiracion = YearMonth.of(year, month);

    }

    public String getNumerosFrente() {
        return numerosFrente;
    }

    public void setNumerosFrente(String numerosFrente) {
        this.numerosFrente = numerosFrente;
    }

    public Integer getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(Integer codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public YearMonth getFechaExpiracion() {
        return fechaExpiracion;
    }

    public YearMonth setFechaExpiracion(int year, int month) {
        fechaExpiracion = YearMonth.of(year, month);
        return fechaExpiracion;
    }
}
