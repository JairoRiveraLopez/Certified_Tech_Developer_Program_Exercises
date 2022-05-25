package Resolucion_ejerciciopreclase_patronfacade;

import java.util.ArrayList;
import java.util.List;

public class ServicioBancario implements IServicioBancario{
    private ServicioAutenticacion servicioAutenticacion;
    private ServicioCuenta servicioCuenta;
    private ServicioCaja servicioCaja;
    private List<Cuenta> cuentas;

    public ServicioBancario() {
        this.servicioAutenticacion = new ServicioAutenticacion();
        this.servicioCuenta = new ServicioCuenta();
        this.servicioCaja = new ServicioCaja();
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
        }

    @Override
    public void retirarDinero(Integer DNI, String contrasenia, Double saldoARetirar) {
        if (servicioAutenticacion.validarUsuarioYContrasenia(cuentas, DNI, contrasenia)) {
            Cuenta cuenta = this.servicioCuenta.getCuenta(cuentas, DNI);
            if (cuenta != null){
                this.servicioCaja.entregarDinero(cuenta, saldoARetirar);
            }
        }
    }
}


