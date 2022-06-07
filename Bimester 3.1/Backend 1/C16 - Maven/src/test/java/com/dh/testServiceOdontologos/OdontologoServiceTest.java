package Services;

import DAOS.OdontologoDAOH2;
import Entities.Odontologo;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.*;

import org.apache.log4j.Logger;

class OdontologoServiceTest {
    private static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);

    @BeforeAll
    public static void crearYCargarBDD(){
        Connection connection = null;
        logger.info("Se comienza creacion tabla ODONTOLOGOS y se insertan 3 registros");
        try{
            Class.forName("org.h2.Driver");
            connection= DriverManager.getConnection("jdbc:h2:~/parcialprueba5JairoRivera;INIT=RUNSCRIPT FROM 'create.sql'","User","visitante");
        } catch (Exception e){
            logger.error("Se presento un error en la creacion y cargue de la tabla ODONTOLOGOS");
        }
        finally {
            try{
                connection.close();
            }
            catch (Exception ex){
                logger.error("Se presento un error con el cierre de la conexion");
            }
        }
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
            connection= DriverManager.getConnection("jdbc:h2:~/parcialprueba5JairoRivera","User","visitante");
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