package Resolucion_ejerciciopreclase_patronfacade;

public class Cuenta {
    private Integer DNI;
    private String contrasenia;
    private Double saldo;

    public Cuenta(){

    }

    public Cuenta(Integer DNI, String contrasenia, Double saldo) {
        this.DNI = DNI;
        this.contrasenia = contrasenia;
        this.saldo = saldo;
    }

    public Integer getDNI() {
        return DNI;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
