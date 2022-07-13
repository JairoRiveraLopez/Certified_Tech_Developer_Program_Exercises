package com.DHC35.Resolution;

import com.DHC35.Resolution.Entities.Odontologo;
import com.DHC35.Resolution.Service.IOdontologoService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class IOdontologoServiceTest {
    @Autowired
    IOdontologoService odontologoService;

    @Test
    @Order(1)
    public void agregarOdontologoTest(){
        Odontologo odontologoPrueba = new Odontologo("Rodriguez", "Marina", 9685);

        odontologoService.guardarOdontologo(odontologoPrueba);
        Optional<Odontologo> odontologoPruebaRecuperado = odontologoService.buscarOdontologoXId(1l);

        assertTrue(odontologoPruebaRecuperado.isPresent());
        assertEquals("Rodriguez", odontologoPruebaRecuperado.get().getApellido());
        assertEquals("Marina", odontologoPruebaRecuperado.get().getNombre());
        assertEquals(9685, odontologoPruebaRecuperado.get().getMatricula());
    }
    @Test
    @Order(2)
    public void buscarOdontologoTest(){
        Long idBuscado=1l;

        Optional<Odontologo> odontologoPruebaRecuperado = odontologoService.buscarOdontologoXId(idBuscado);

        assertTrue(odontologoPruebaRecuperado.isPresent());
        assertEquals("Rodriguez", odontologoPruebaRecuperado.get().getApellido());
        assertEquals("Marina", odontologoPruebaRecuperado.get().getNombre());
        assertEquals(9685, odontologoPruebaRecuperado.get().getMatricula());
    }
    @Test
    @Order(3)
    public void listarOdontologosTest(){
        List<Odontologo> listaDePrueba = odontologoService.listarOdontologos();
        assertTrue(listaDePrueba.size() > 0);

        Odontologo odontologoPruebaRecuperado = listaDePrueba.get(0);
        assertEquals("Rodriguez", odontologoPruebaRecuperado.getApellido());
        assertEquals("Marina", odontologoPruebaRecuperado.getNombre());
        assertEquals(9685, odontologoPruebaRecuperado.getMatricula());
    }
    @Test
    @Order(4)
    public void actualizarOdontologoTest(){
        Long idBuscado=1l;
        Odontologo odontoConNuevosDatos = new Odontologo(idBuscado,"Rodriguez","Marina",847);
        odontologoService.actualizarOdontologo(odontoConNuevosDatos);
        Optional<Odontologo> odontologoPruebaRecuperado=odontologoService.buscarOdontologoXId(idBuscado);

        assertEquals("Rodriguez", odontologoPruebaRecuperado.get().getApellido());
        assertEquals("Marina", odontologoPruebaRecuperado.get().getNombre());
        assertEquals(847, odontologoPruebaRecuperado.get().getMatricula());
    }

    @Test
    @Order(5)
    public void eliminarOdontologoTest(){
        Long idBuscado=1l;

        odontologoService.eliminarOdontologo(idBuscado);

        List<Odontologo> listaDePrueba = odontologoService.listarOdontologos();
        assertTrue(listaDePrueba.size() == 0);
    }
}
