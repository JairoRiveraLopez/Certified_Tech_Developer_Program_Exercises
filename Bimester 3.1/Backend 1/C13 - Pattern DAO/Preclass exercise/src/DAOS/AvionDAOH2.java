package DAOS;

import Entities.Avion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class AvionDAOH2 implements IDao<Avion>{
    private static final Logger logger = Logger.getLogger(AvionDAOH2.class);

    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/prueba6preclase13";
    private static final String DB_USER = "Jairo";
    private static final String DB_PASSWD = "oriaJ";
    private static final String SQL_INSERT = "INSERT INTO AVIONES (ID, MARCA, MODELO, MATRICULA, FECHA_ENTRADA_SERVICIO) VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM AVIONES WHERE ID=?";
    private static final String SQL_SELECT = "SELECT * FROM AVIONES WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM AVIONES";

    public AvionDAOH2 (){

    }

    @Override
    public Avion guardar(Avion avion) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // Levantar el driver
        try{
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setLong(1, avion.getID());
            preparedStatement.setString(2, avion.getMarca());
            preparedStatement.setString(3, avion.getModelo());
            preparedStatement.setString(4, avion.getMatricula());
            preparedStatement.setDate(5, avion.getFechaEntradaServicio());

            // Ejecutar sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return avion;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        // Levantar el driver
        try{
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, id);


            // Ejecutar sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Avion buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;

        // Levantar el driver
        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setLong(1, id);


            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            // Evaluar resultado
            while (resultado.next()) {
                Long idAvion = resultado.getLong("ID");
                String marca = resultado.getString("MARCA");
                String modelo = resultado.getString("MODELO");
                String matricula = resultado.getString("MATRICULA");
                String fechaEntradaServicio = String.valueOf((resultado.getDate("FECHA_ENTRADA_SERVICIO")));
                avion = new Avion(idAvion, marca, modelo, matricula, fechaEntradaServicio);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return avion;
    }

    @Override
    public List<Avion> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList aviones = new ArrayList<>();

        // Levantar el driver
        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);

            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            // Evaluar resultado
            while (resultado.next()) {
                Long idAvion = resultado.getLong("ID");
                String marca = resultado.getString("MARCA");
                String modelo = resultado.getString("MODELO");
                String matricula = resultado.getString("MATRICULA");
                String fechaEntradaServicio = String.valueOf((resultado.getDate("FECHA_ENTRADA_SERVICIO")));
                Avion avion = new Avion(idAvion, marca, modelo, matricula, fechaEntradaServicio);

                aviones.add(avion);

            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return aviones;
    }
}
