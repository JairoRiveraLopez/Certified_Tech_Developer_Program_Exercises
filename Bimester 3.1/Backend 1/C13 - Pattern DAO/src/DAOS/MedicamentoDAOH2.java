package DAOS;

import Entities.Medicamento;
import java.sql.*;
import java.util.*;
import org.apache.log4j.Logger;

public class MedicamentoDAOH2 implements IDao <Medicamento>{
    private static final Logger logger = Logger.getLogger(MedicamentoDAOH2.class);

    private static final String DB_JDBC_Driver = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/resolucionmesasclase13";
    private static final String DB_USER = "Jairo";
    private static final String DB_PASSWD = "oriaJ";
    private static final String SQL_INSERT = "INSERT INTO FARMACIA (ID, CODIGO_NUMERO, NOMBRE, LABORATORIO_PRODUCCION, CANTIDAD, PRECIO) VALUES (?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM FARMACIA WHERE ID=?";
    private static final String SQL_SELECT = "SELECT * FROM FARMACIA WHERE ID=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM FARMACIA";

    public MedicamentoDAOH2() {
    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        logger.info("Se comienza una operación de guardado");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);


            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setLong(1, medicamento.getId());
            preparedStatement.setString(2, medicamento.getCodigoNumerico());
            preparedStatement.setString(3, medicamento.getNombre());
            preparedStatement.setString(4, medicamento.getLaboratorioDeProduccion());
            preparedStatement.setInt(5, medicamento.getCantidad());
            preparedStatement.setDouble(6, medicamento.getPrecio());


            // Ejecutar sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            logger.error("Se presentó una falla en la insercion de datos en la tabla.", e);
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver ingresado erradamente en la funcionalidad guardar.", e);
        }

        return medicamento;
    }

    @Override
    public void eliminar(Long id) {
        logger.info("Se comienza una operación de eliminacion");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);


            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, id);


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
    public Medicamento buscar(Long id) {
        logger.info("Se comienza una operación de busqueda singular");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamento = null;


        try{
            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setLong(1, id);


            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                Long ID = resultado.getLong("ID");
                String codigoNumerico = resultado.getString("CODIGO_NUMERO");
                String nombre = resultado.getString("NOMBRE");
                String laboratorioProduccion = resultado.getString("LABORATORIO_PRODUCCION");
                Integer cantidad = resultado.getInt("CANTIDAD");
                Double precio = resultado.getDouble("PRECIO");
                medicamento = new Medicamento(ID, codigoNumerico, nombre, laboratorioProduccion, cantidad, precio);
            }

            preparedStatement.close();

        } catch (SQLException e) {
            logger.error("Se presentó una falla en la busqueda del registro# " + id + " en la tabla.", e);
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver ingresado erradamente en la funcionalidad buscar.", e);
        }

        return medicamento;
    }

    @Override
    public List<Medicamento> buscarTodos() {
        logger.info("Se comienza una operación de busqueda total");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList medicamentos = new ArrayList<>();


        try {

            Class.forName(DB_JDBC_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            // Crear sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);

            // Ejecutar sentencia
            ResultSet resultado = preparedStatement.executeQuery();

            // Evaluar resultado
            while (resultado.next()) {
                Long ID = resultado.getLong("ID");
                String codigoNumerico = resultado.getString("CODIGO_NUMERO");
                String nombre = resultado.getString("NOMBRE");
                String laboratorioProduccion = resultado.getString("LABORATORIO_PRODUCCION");
                Integer cantidad = resultado.getInt("CANTIDAD");
                Double precio = resultado.getDouble("PRECIO");
                Medicamento medicamento = new Medicamento(ID, codigoNumerico, nombre, laboratorioProduccion, cantidad, precio);
                medicamentos.add(medicamento);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            logger.error("Se presentó una falla en la busqueda de todos los registros de la tabla.", e);
        } catch (ClassNotFoundException e) {
            logger.error("JDBC driver ingresado erradamente en la funcionalidad buscarTodos.", e);
        }
        return medicamentos;
    }
}
