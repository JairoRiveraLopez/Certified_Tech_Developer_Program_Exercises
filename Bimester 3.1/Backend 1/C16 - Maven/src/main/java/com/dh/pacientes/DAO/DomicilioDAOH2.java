package Resolucion_Clase.DAO;

import Resolucion_Clase.Entities.Domicilio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class DomicilioDAOH2 implements IDao<Domicilio>{


        private static final Logger logger = Logger.getLogger(DomicilioDAOH2.class);

        private static final String DB_JDBC_Driver = "org.h2.Driver";
        private static final String DB_URL = "jdbc:h2:~/ultimaprueba2mesasclase14";
        private static final String DB_USER = "Jairo";
        private static final String DB_PASSWD = "oriaJ";
        private static final String SQL_INSERT = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
        private static final String SQL_SELECT = "SELECT * FROM DOMICILIOS WHERE DOMICILIO_ID=?";
        private static final String SQL_SELECT_ALL = "SELECT * FROM DOMICILIOS";
        private static final String SQL_DELETE = "DELETE FROM DOMICILIOS WHERE DOMICILIO_ID=?";


    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("Se comienza una operación de guardado");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.execute();

            ResultSet key = preparedStatement.getGeneratedKeys();
            while (key.next()){
                domicilio.setDomicilio_id(key.getInt(1));
            }

        } catch (Exception e) {
            logger.error("Se presentó una falla en la insercion de datos en la tabla.", e);
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                logger.error("Se presentó una falla en el cierre de la conexion.", e);
            }
    }

        return domicilio;
        }

    @Override
    public void eliminar(Integer id) {
        logger.info("Se comienza una operación de eliminacion");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);


            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);


            // Ejecutar sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            logger.error("Se presentó una falla en la eliminacion del registro# " + id + " en la tabla.", e);
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver ingresado erradamente en la funcionalidad eliminar.", e);
        }
    }


    @Override
    public Domicilio buscar(Integer id){
        logger.info("Se comienza una operación de busqueda singular");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio domicilio = null;

        try {
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);

            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                domicilio = new Domicilio(resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getInt(3),
                        resultado.getString(4),
                        resultado.getString(5));
            }


        } catch (Exception e) {
            logger.error("Se presentó una falla en la insercion de datos en la tabla.", e);
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                logger.error("Se presentó una falla en el cierre de la conexion.", e);
            }
        }
        return domicilio;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        logger.info("Se comienza una operación de busqueda total");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList domicilios = new ArrayList<>();


        try {

            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);

            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            // Evaluar resultado
            while (resultado.next()) {
                Integer id = resultado.getInt("DOMICILIOS_ID");
                String calle = resultado.getString("CALLE");
                Integer numero = resultado.getInt("NUMERO");
                String localidad = resultado.getString("LOCALIDAD");
                String provincia = resultado.getString("PROVINCIA");
                Domicilio domicilio = new Domicilio(id, calle, numero, localidad, provincia);
                domicilios.add(domicilio);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Se presentó una falla en la busqueda de todos los registros de la tabla.", e);
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver ingresado erradamente en la funcionalidad buscarTodos.", e);
        }
        return domicilios;
    }


}
