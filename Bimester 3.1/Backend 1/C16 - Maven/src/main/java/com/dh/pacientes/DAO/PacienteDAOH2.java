package com.dh.pacientes.DAO;


import com.dh.pacientes.Entities.Domicilio;
import com.dh.pacientes.Entities.Paciente;
import org.apache.log4j.Logger;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PacienteDAOH2 implements IDao<Paciente>{

    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);

    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/ultimaprueba3mesasclase14";
    private static final String DB_USER = "Jairo";
    private static final String DB_PASSWD = "oriaJ";
    private static final String SQL_INSERT = "INSERT INTO PACIENTES (NOMBRE, DNI, FECHA_INGRESO, PACIENTE_DOMICILIO_ID) VALUES (?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    private static final String SQL_DELETE = "DELETE FROM PACIENTES WHERE ID=?";


    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("Se comienza una operación de guardado");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            domicilioDAOH2.guardar(paciente.getDomicilio());

            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setInt(2, paciente.getDNI());
            preparedStatement.setDate(3, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(4, paciente.getDomicilio().getDomicilio_id());

            preparedStatement.execute();

            ResultSet key = preparedStatement.getGeneratedKeys();
            while (key.next()){
                paciente.setId(key.getInt(1));
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

        return paciente;
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
    public Paciente buscar(Integer id) {
        logger.info("Se comienza una operación de busqueda singular");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);

            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                paciente = new Paciente(resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getInt(3),
                        resultado.getDate(4).toLocalDate(),
                        domicilioDAOH2.buscar(resultado.getInt(5)));
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
        return paciente;


    }

    @Override
    public List<Paciente> buscarTodos() {
        logger.info("Se comienza una operación de busqueda total");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList pacientes = new ArrayList<>();


        try {
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);

            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            // Evaluar resultado
            while (resultado.next()) {
                Integer id = resultado.getInt("ID");
                String nombre = resultado.getString("NOMBRE");
                Integer DNI = resultado.getInt("DNI");
                LocalDate localidad = resultado.getDate("FECHA_INGRESO").toLocalDate();
                Domicilio domicilio = domicilioDAOH2.buscar(resultado.getInt(5));
                Paciente paciente = new Paciente(id, nombre, DNI, localidad, domicilio);
                pacientes.add(paciente);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Se presentó una falla en la busqueda de todos los registros de la tabla.", e);
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver ingresado erradamente en la funcionalidad buscarTodos.", e);
        }
        return pacientes;
    }


}
