package com.DHC35.Resolution;

import com.DHC35.Resolution.Entities.Domicilio;
import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Entities.Turno;
import com.DHC35.Resolution.Service.IOdontologoService;
import com.DHC35.Resolution.Service.IPacienteService;
import com.DHC35.Resolution.Service.ITurnoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ITurnoServiceTest {
    @Autowired
    IPacienteService pacienteService;

    @Autowired
    IOdontologoService odontologoService;

    @Autowired
    ITurnoService turnoService;

    @Test
    @Order(1)
    public void agregarTurnoTest(){
        Paciente pacientePrueba = new Paciente(
                "Rivera", "Jairo", "jairorive123@gmail.com", 96021405, LocalDate.of(1996, 2, 14),
                new Domicilio("Bernal", 2, "Med", "Ant"));
        pacienteService.guardarPaciente(pacientePrueba);

        Odontologo odontologoPrueba = new Odontologo("Rodriguez", "Marina", 9685);
        odontologoService.guardarOdontologo(odontologoPrueba);

        List<Paciente> listaPacientes = pacienteService.listarPacientes();
        Paciente pacientePruebaRecuperado = listaPacientes.get(0);
        List<Odontologo> listaOdontologos = odontologoService.listarOdontologos();
        Odontologo odontologoPruebaRecuperado = listaOdontologos.get(0);

        turnoService.guardarTurno(
                new Turno(odontologoPruebaRecuperado, pacientePruebaRecuperado, LocalDate.of(2022, 7, 1)));

        List<Turno> listaTurnos = turnoService.listarTurnos();
        Turno turnoRecuperado = listaTurnos.get(0);

        assertNotNull(turnoRecuperado);
        assertEquals(1L, turnoRecuperado.getOdontologo().getId());
        assertEquals(1L, turnoRecuperado.getPaciente().getId());
        assertEquals(LocalDate.of(2022, 7, 1), turnoRecuperado.getFecha());
    }
    @Test
    @Order(2)
    public void listarTurnosTest(){
        List<Turno> listaTurnos = turnoService.listarTurnos();
        Turno turnoRecuperado = listaTurnos.get(0);

        assertNotNull(turnoRecuperado);
        assertEquals(1L, turnoRecuperado.getOdontologo().getId());
        assertEquals(1L, turnoRecuperado.getPaciente().getId());
        assertEquals(LocalDate.of(2022, 7, 1), turnoRecuperado.getFecha());
    }
}
