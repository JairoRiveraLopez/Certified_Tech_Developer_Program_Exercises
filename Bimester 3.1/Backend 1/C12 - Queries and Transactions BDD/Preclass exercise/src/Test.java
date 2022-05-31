import org.apache.log4j.Logger;

import java.sql.*;

public class Test {
    private static final Logger logger = Logger.getLogger(Test.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS PACIENTES;" +
            "CREATE TABLE PACIENTES (" +
            "ID INT PRIMARY KEY," +
            "NOMBRE varchar(100) NOT NULL," +
            "APELLIDO varchar(100) NOT NULL," +
            "DOMICILIO varchar(255) NOT NULL," +
            "DNI bigint NOT NULL," +
            "FECHA_ALTA date NOT NULL," +
            "USUARIO varchar(255) NOT NULL," +
            "PASSWORD varchar(50) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO PACIENTES (ID, NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA, USUARIO, PASSWORD) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET DOMICILIO=? WHERE USUARIO=? AND PASSWORD=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";

    public static void main(String[] args) throws Exception{

        Paciente usuario = new Paciente("Jairo", "Rivera", "Cll 3", 1216719942, "JAIRIV", "12345", "1996-02-14");

        Connection connection = null;
        try{
            logger.info("Creacion de tabla");
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            logger.info("Insercion datos en la BDD");
            PreparedStatement psInsertar = connection.prepareStatement(SQL_INSERT);

            psInsertar.setInt(1, 1);
            psInsertar.setString(2, usuario.getNombre());
            psInsertar.setString(3, usuario.getApellido());
            psInsertar.setString(4, usuario.getDomicilio());
            psInsertar.setInt(5, usuario.getDNI());
            psInsertar.setDate(6, usuario.getFechaDeAlta());
            psInsertar.setString(7, usuario.getUsuario());
            psInsertar.setString(8, usuario.getPassword());

            psInsertar.execute();

            logger.info("Empezar la modificacion de direccion (Resultado positivo)");

            connection.setAutoCommit(false);

            PreparedStatement psUpdateDireccion1 = connection.prepareStatement(SQL_UPDATE);
            psUpdateDireccion1.setString(1, usuario.setDomicilio("Cra 80"));
            psUpdateDireccion1.setString(2, usuario.getUsuario());
            psUpdateDireccion1.setString(3, usuario.getPassword());

            psUpdateDireccion1.execute();

            Statement consulta = connection.createStatement();
            ResultSet resultadoConsulta = consulta.executeQuery(SQL_SELECT_ALL);

            while (resultadoConsulta.next()) {
                logger.debug("\n" + resultadoConsulta.getInt(1) + "\n" + resultadoConsulta.getString(2)
                        + "\n" + resultadoConsulta.getString(3) + "\n" + resultadoConsulta.getString(4)
                        + "\n" + resultadoConsulta.getInt(5) + "\n" + resultadoConsulta.getDate(6)
                        + "\n" + resultadoConsulta.getString(7) + "\n" + resultadoConsulta.getString(8)
                );
            }

            logger.info("Empezar la modificacion de direccion (Resultado Negativo)");

            PreparedStatement psUpdateDireccion2 = connection.prepareStatement(SQL_UPDATE);
            psUpdateDireccion2.setString(1, usuario.setDomicilio("Calle 52"));
            psUpdateDireccion2.setString(2, usuario.getUsuario());
            psUpdateDireccion2.setString(3, "9876");

            psUpdateDireccion2.execute();

            connection.commit();
            connection.setAutoCommit(true);

            Statement consulta2 = connection.createStatement();
            ResultSet resultadoConsulta2 = consulta2.executeQuery(SQL_SELECT_ALL);
            while (resultadoConsulta2.next()) {
                logger.debug("\n" + resultadoConsulta2.getInt(1) + "\n" + resultadoConsulta2.getString(2)
                        + "\n" + resultadoConsulta2.getString(3) + "\n" + resultadoConsulta2.getString(4)
                        + "\n" + resultadoConsulta2.getInt(5) + "\n" + resultadoConsulta2.getDate(6)
                        + "\n" + resultadoConsulta2.getString(7) + "\n" + resultadoConsulta2.getString(8)
                );
            }

        }
        catch (Exception e){
            logger.error("Algo ha fallado en las instrucciones a la BDD", e);
            connection.rollback();
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/desarrollopreclase12", "Jairo", "oriaJ");
    }
}
