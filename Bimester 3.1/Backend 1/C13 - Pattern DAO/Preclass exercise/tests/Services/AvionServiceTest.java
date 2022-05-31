package Services;

import DAOS.AvionDAOH2;
import Entities.Avion;
import org.junit.Before;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.List;
import org.apache.log4j.Logger;

class AvionServiceTest {
    private static final Logger logger = Logger.getLogger(AvionServiceTest.class);
    private AvionService avionService = new AvionService();

    final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS AVIONES;" +
            "CREATE TABLE AVIONES (" +
            "ID INT PRIMARY KEY," +
            "MARCA varchar(100) NOT NULL," +
            "MODELO varchar(100) NOT NULL," +
            "MATRICULA varchar(255) NOT NULL," +
            "FECHA_ENTRADA_SERVICIO date NOT NULL)";


    @Test
    void guardarAvion() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/prueba6preclase13", "Jairo", "oriaJ");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (SQLException e) {
            logger.error("Error al momento de crear la tabla");
        }

        avionService.setAvionIDao(new AvionDAOH2());
        avionService.guardarAvion(new Avion(1L,"Ford", "ULT-001", "960214", "2001-12-12"));
        avionService.guardarAvion(new Avion(2L,"Boeing", "AST-001", "859641", "2011-2-18"));
        Avion avion = avionService.buscarAvion(2L);
        Assertions.assertEquals(avion.getMarca(), "Boeing");
        Assertions.assertEquals(avion.getModelo(), "AST-001");
        Assertions.assertEquals(avion.getMatricula(), "859641");
    }

    @Test
    void eliminarAvion() throws SQLException{

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/prueba6preclase13", "Jairo", "oriaJ");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (SQLException e) {
            logger.error("Error al momento de crear la tabla");
        }

        avionService.setAvionIDao(new AvionDAOH2());
        avionService.guardarAvion(new Avion(1L,"Ford", "ULT-001", "960214", "2001-12-12"));
        avionService.guardarAvion(new Avion(2L,"Boeing", "AST-001", "859641", "2011-2-18"));

        avionService.eliminarAvion(2L);
        List<Avion> aviones = avionService.buscarTodos();
        Assertions.assertEquals(aviones.size(), 1);

    }

    @Test
    void buscarAvion() throws SQLException{

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/prueba6preclase13", "Jairo", "oriaJ");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (SQLException e) {
            logger.error("Error al momento de crear la tabla");
        }

        avionService.setAvionIDao(new AvionDAOH2());
        avionService.guardarAvion(new Avion(1L,"Ford", "ULT-001", "960214", "2001-12-12"));
        avionService.guardarAvion(new Avion(2L,"Boeing", "AST-001", "859641", "2011-2-18"));

        Avion avion = avionService.buscarAvion(1L);
        Assertions.assertEquals(avion.getMarca(), "Ford");
        Assertions.assertEquals(avion.getModelo(), "ULT-001");
        Assertions.assertEquals(avion.getMatricula(), "960214");
    }

    @Test
    void buscarTodos() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/prueba6preclase13", "Jairo", "oriaJ");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (SQLException e) {
            logger.error("Error al momento de crear la tabla");
        }

        avionService.setAvionIDao(new AvionDAOH2());
        avionService.guardarAvion(new Avion(1L,"Ford", "ULT-001", "960214", "2001-12-12"));
        avionService.guardarAvion(new Avion(2L,"Boeing", "AST-001", "859641", "2011-2-18"));

        List<Avion> aviones = avionService.buscarTodos();

        Assertions.assertEquals(aviones.size(), 2);

    }
}