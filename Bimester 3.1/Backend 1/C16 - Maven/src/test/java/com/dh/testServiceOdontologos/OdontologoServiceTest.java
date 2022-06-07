package com.dh.testServiceOdontologos;

import com.dh.odontologos.BDDAUX.BBDAux;
import com.dh.odontologos.DAOS.OdontologoDAOH2;
import com.dh.odontologos.Entities.Odontologo;
import com.dh.odontologos.Services.OdontologoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;


import java.sql.*;
import java.util.*;




class OdontologoServiceTest {
    private static final Logger logger = LogManager.getLogger(OdontologoServiceTest.class);

    @BeforeAll
    static void init () throws SQLException {
        BBDAux.crearTablas();
    }

    @Test
    @Order(1)
    void guardarOdontologo() {
        Odontologo odontologoPrueba = new Odontologo(1996, "Fulano", "DeTal");
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDao(new OdontologoDAOH2());

        odontologoService.guardarOdontologo(odontologoPrueba);

        logger.info("Se comienza una busqueda para validar si el registro guardado se encuentra en la tabla");
        Connection connection=null;
        Odontologo odontologoBusqueda=null;

        try{
            connection= DriverManager.getConnection("jdbc:h2:~/parcialprueba6JairoRivera","User","visitante");
            PreparedStatement ps= connection.prepareStatement("SELECT * FROM " +
                    "ODONTOLOGOS WHERE ID=?");
            ps.setInt(1,4);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                odontologoBusqueda= new Odontologo(rs.getInt(1), rs.getInt(2),
                        rs.getString(3),rs.getString(4));
            }

        } catch (Exception e){
            logger.error("Se presentó un error en la busqueda singular del registro 4 de la tabla ODONTOLOGOS");
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                logger.error("Se presentó un error con el cierre de la conexion");
            }
        }

        Assertions.assertEquals(odontologoBusqueda.getNumeroMatricula(), 1996);
    }

    @Test
    void buscarTodosLosOdontologos() {
        OdontologoService odontologoService = new OdontologoService();
        odontologoService.setOdontologoIDao(new OdontologoDAOH2());
        List<Odontologo> listaOdontologsPrueba= odontologoService.buscarTodosLosOdontologos();
        for(Odontologo o : listaOdontologsPrueba){
            logger.info("ID: " + o.getId() + " Nombre: " + o.getNombre() + " Matricula: " + o.getNumeroMatricula());
        }

        Assertions.assertEquals(listaOdontologsPrueba.size(), 3);
    }


}