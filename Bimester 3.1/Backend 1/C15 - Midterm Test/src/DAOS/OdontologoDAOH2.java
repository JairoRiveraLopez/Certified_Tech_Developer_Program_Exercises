package DAOS;

import java.util.ArrayList;
import java.util.List;

import Entities.Odontologo;
import org.apache.log4j.Logger;
import java.sql.*;
public class OdontologoDAOH2 implements IDao<Odontologo>{
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);
    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/parcialprueba5JairoRivera";
    private static final String DB_USER = "User";
    private static final String DB_PASSWD = "visitante";
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Se comienza una operacion de guardado");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Crear conexion y sentencia
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            // Especificar datos a insertar
            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

            // Ejecutar sentencia
            preparedStatement.execute();

            // Traer como consulta las ID generadas de la insercion para setear en la clase que retorna
            ResultSet key = preparedStatement.getGeneratedKeys();
            while (key.next()){
                odontologo.setId(key.getInt(1));
            }

        } catch (Exception e) {
        logger.error("Se presento una falla en la insercion de datos en la tabla ODONTOLOGOS.", e);
    } finally {
        try {
            connection.close();
        } catch (Exception e){
            logger.error("Se presentó una falla en el cierre de la conexion.", e);
        }
    }
        return odontologo;
    }


    @Override
    public List<Odontologo> buscarTodos() {
        logger.info("Se comienza una operacion de busqueda de todos los registros de la tabla ODONTOLOGOS");
        // Crear conexion y sentencia
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        // Lista que almacena los datos de la consulta
        ArrayList odontologos = new ArrayList<>();

        try {
            // Crear conexion y sentencia
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);

            // Generar consulta a partir de la sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            // Evaluar resultado
            while (resultado.next()) {
                Integer id = resultado.getInt("ID");
                Integer matricula = resultado.getInt("MATRICULA");
                String nombre = resultado.getString("NOMBRE");
                String apellido = resultado.getString("APELLIDO");

                Odontologo odontologo = new Odontologo(matricula, nombre, apellido);
                odontologo.setId(id);

                odontologos.add(odontologo);
            }

        } catch (Exception e) {
            logger.error("Se presento una falla en la busqueda de todos los registros de la tabla ODONTOLOGOS.", e);
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                logger.error("Se presento una falla en el cierre de la conexion.", e);
            }
        }
        return odontologos;
    }
}
