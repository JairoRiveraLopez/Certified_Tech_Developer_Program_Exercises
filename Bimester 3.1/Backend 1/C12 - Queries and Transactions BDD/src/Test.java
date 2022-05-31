import org.apache.log4j.Logger;

import java.sql.*;

public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (" +
            "ID INT PRIMARY KEY," +
            "APELLIDO varchar(100) NOT NULL," +
            "NOMBRE varchar(100) NOT NULL," +
            "MATRICULA varchar(255) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (ID, APELLIDO, NOMBRE, MATRICULA) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=? WHERE APELLIDO=? AND NOMBRE=?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";

    public static void main(String[] args) throws SQLException {
        Odontologo rodo = new Odontologo(1L,"Miraflores", "Rodolfo", "ODO-001");

        Connection connection = null;
        try {
            logger.info("Creacion de tabla");
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            logger.info("Insercion datos en la BDD");
            PreparedStatement psInsertar = connection.prepareStatement(SQL_INSERT);

            psInsertar.setLong(1, rodo.getID());
            psInsertar.setString(2, rodo.getApellido());
            psInsertar.setString(3, rodo.getNombre());
            psInsertar.setString(4, rodo.getMatricula());

            psInsertar.execute();

            logger.info("Empezar la modificacion de direccion (Resultado positivo)");

            connection.setAutoCommit(false);

            PreparedStatement psUpdateMatricula1= connection.prepareStatement(SQL_UPDATE);
            psUpdateMatricula1.setString(1, rodo.setMatricula("RODO-001"));
            psUpdateMatricula1.setString(2, rodo.getApellido());
            psUpdateMatricula1.setString(3, rodo.getNombre());

            psUpdateMatricula1.execute();

            Statement consulta = connection.createStatement();
            ResultSet resultadoConsulta = consulta.executeQuery(SQL_SELECT_ALL);

            while (resultadoConsulta.next()) {
                logger.debug("\n" + resultadoConsulta.getInt(1) + "\n" + resultadoConsulta.getString(2)
                        + "\n" + resultadoConsulta.getString(3) + "\n" + resultadoConsulta.getString(4)
                );
            }

            logger.info("Empezar la modificacion de direccion (Resultado Negativo)");

            PreparedStatement psUpdateMatricula2= connection.prepareStatement(SQL_UPDATE);
            psUpdateMatricula2.setString(1, rodo.setMatricula("ERN-001"));
            psUpdateMatricula2.setString(2, "Morales");
            psUpdateMatricula2.setString(3, rodo.getNombre());

            psUpdateMatricula2.execute();
            connection.commit();
            connection.setAutoCommit(true);

            Statement consulta2 = connection.createStatement();
            ResultSet resultadoConsulta2 = consulta2.executeQuery(SQL_SELECT_ALL);

            while (resultadoConsulta2.next()) {
                logger.debug("\n" + resultadoConsulta2.getInt(1) + "\n" + resultadoConsulta2.getString(2)
                        + "\n" + resultadoConsulta2.getString(3) + "\n" + resultadoConsulta2.getString(4)
                );
            }

        }catch (Exception e){
            logger.error("Algo ha fallado en las instrucciones a la BDD", e);
            connection.rollback();
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/desarrollmesasclase12", "Jairo", "oriaJ");
    }
}
