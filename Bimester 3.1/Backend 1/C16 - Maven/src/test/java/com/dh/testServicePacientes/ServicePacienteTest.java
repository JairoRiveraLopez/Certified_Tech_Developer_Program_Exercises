package Resolucion_Clase.Services;

import Resolucion_Clase.BDDAUX.BBDAux;
import Resolucion_Clase.DAO.DomicilioDAOH2;
import Resolucion_Clase.DAO.PacienteDAOH2;
import Resolucion_Clase.Entities.Domicilio;
import Resolucion_Clase.Entities.Paciente;
import org.junit.jupiter.api.*;
import org.apache.log4j.Logger;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;


class ServicePacienteTest {
    private static final Logger logger = Logger.getLogger(ServicePacienteTest.class);
    private ServicePaciente servicePaciente = new ServicePaciente();
    private ServiceDomicilio serviceDomicilio = new ServiceDomicilio();

    @Test
    void guardarYBuscarPaciente() throws SQLException {
        BBDAux.crearTablas();
        servicePaciente.setPacienteIdao(new PacienteDAOH2());
        servicePaciente.guardarPaciente(new Paciente("Jairo", 15169874, LocalDate.of(1996, 2, 14), new Domicilio("Cll 3", 49, "Medellin", "Antioquia")));
        Paciente pacienteprueba = (Paciente) servicePaciente.buscarPaciente(1);
        Assertions.assertEquals(pacienteprueba.getDNI(), 15169874);
        Assertions.assertEquals(pacienteprueba.getNombre(), "Jairo");
    }

    @Test
    void eliminarPacienteYObtenerDireccion() throws SQLException {
        BBDAux.crearTablas();
        servicePaciente.setPacienteIdao(new PacienteDAOH2());
        serviceDomicilio.setDomicilioIdao(new DomicilioDAOH2());
        servicePaciente.guardarPaciente(new Paciente("Jairo", 15169874, LocalDate.of(1996, 2, 14), new Domicilio("Cll 3", 49, "Medellin", "Antioquia")));
        servicePaciente.eliminarPaciente(1);

        Domicilio domicilioPrueba = serviceDomicilio.buscarDomicilio(1);
        Assertions.assertEquals(domicilioPrueba.getCalle(), "Cll 3");
        Assertions.assertEquals(domicilioPrueba.getNumero(), 49);
        Assertions.assertEquals(domicilioPrueba.getLocalidad(), "Medellin");
    }

    @Test
    void buscarTodosLosPacientes() throws SQLException {
        BBDAux.crearTablas();
        servicePaciente.setPacienteIdao(new PacienteDAOH2());

        servicePaciente.guardarPaciente(new Paciente("Jairo", 15169874, LocalDate.of(1996, 2, 14), new Domicilio("Cll 3", 49, "Medellin", "Antioquia")));
        servicePaciente.guardarPaciente(new Paciente("Andres", 15169874, LocalDate.of(1996, 2, 14), new Domicilio("Cll 50", 20, "Bogota", "Cundinamarca")));

        List<Paciente> listaPrueba = servicePaciente.buscarTodos();
        Assertions.assertEquals(listaPrueba.size(), 2);
    }

}