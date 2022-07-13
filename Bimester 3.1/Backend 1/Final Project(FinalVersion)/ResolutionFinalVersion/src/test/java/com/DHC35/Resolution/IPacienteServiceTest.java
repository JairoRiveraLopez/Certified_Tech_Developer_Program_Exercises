package com.DHC35.Resolution;

import com.DHC35.Resolution.Entities.Domicilio;
import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Entities.Paciente;
import com.DHC35.Resolution.Service.IPacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class IPacienteServiceTest {
    @Autowired
    IPacienteService pacienteService;

    @Test
    @Order(1)
    public void agregarPacienteTest(){
        Paciente pacientePrueba = new Paciente(
                "Rivera", "Jairo", "jairorive123@gmail.com", 96021405, LocalDate.of(1996, 2, 14),
                new Domicilio("Bernal", 2, "Med", "Ant"));

        pacienteService.guardarPaciente(pacientePrueba);
        Optional<Paciente> pacientePruebaRecuperado = pacienteService.buscarPacienteXId(1l);

        assertTrue(pacientePruebaRecuperado.isPresent());
        assertEquals("Rivera", pacientePruebaRecuperado.get().getApellido());
        assertEquals("Jairo", pacientePruebaRecuperado.get().getNombre());
        assertEquals(96021405, pacientePruebaRecuperado.get().getDni());
    }
    @Test
    @Order(2)
    public void buscarPacienteTest(){
        Long idBuscado=1l;

        Optional<Paciente> pacientePruebaRecuperado = pacienteService.buscarPacienteXId(idBuscado);

        assertTrue(pacientePruebaRecuperado.isPresent());
        assertEquals("Rivera", pacientePruebaRecuperado.get().getApellido());
        assertEquals("Jairo", pacientePruebaRecuperado.get().getNombre());
        assertEquals(96021405, pacientePruebaRecuperado.get().getDni());
    }
    @Test
    @Order(3)
    public void listarPacientesTest(){
        List<Paciente> listaDePrueba = pacienteService.listarPacientes();
        assertTrue(listaDePrueba.size() > 0);

        Paciente pacientePruebaRecuperado = listaDePrueba.get(0);
        assertEquals("Rivera", pacientePruebaRecuperado.getApellido());
        assertEquals("Jairo", pacientePruebaRecuperado.getNombre());
        assertEquals(96021405, pacientePruebaRecuperado.getDni());
    }
    @Test
    @Order(4)
    public void actualizarPacienteTest(){
        Long idBuscado=1l;
        Paciente pacientePruebaNuevosDatos = new Paciente(1L,
                "Rivera", "Jairo", "jairorive123@gmail.com", 85142541, LocalDate.of(1996, 2, 14),
                new Domicilio(1L, "Poblado", 3, "Med", "Ant"));
        pacienteService.actualizarPaciente(pacientePruebaNuevosDatos);
        Optional<Paciente> pacientePruebaRecuperado = pacienteService.buscarPacienteXId(idBuscado);

        assertTrue(pacientePruebaRecuperado.isPresent());
        assertEquals("Rivera", pacientePruebaRecuperado.get().getApellido());
        assertEquals("Jairo", pacientePruebaRecuperado.get().getNombre());
        assertEquals(85142541, pacientePruebaRecuperado.get().getDni());
        assertEquals("Poblado", pacientePruebaRecuperado.get().getDomicilio().getCalle());
        assertEquals(3, pacientePruebaRecuperado.get().getDomicilio().getNumero());
    }

    @Test
    @Order(5)
    public void eliminarPacienteTest(){
        Long idBuscado=1l;

        pacienteService.eliminarPaciente(idBuscado);

        List<Paciente> listaDePrueba = pacienteService.listarPacientes();
        assertTrue(listaDePrueba.size() == 0);
    }
}
