package Resolucion_Clase.BDDAUX;
import org.apache.log4j.Logger;
import java.sql.*;

public class BBDAux {
    private static final Logger logger = Logger.getLogger(BBDAux.class);
    private static final String SQL_CREATE_TABLES = "DROP TABLE IF EXISTS DOMICILIOS;" +
    "CREATE TABLE DOMICILIOS (" +
            "DOMICILIO_ID INT AUTO_INCREMENT PRIMARY KEY," +
            "CALLE VARCHAR(200) NOT NULL," +
            "NUMERO INT NOT NULL," +
            "LOCALIDAD VARCHAR(100) NOT NULL," +
            "PROVINCIA VARCHAR(100) NOT NULL);" +

    "DROP TABLE IF EXISTS PACIENTES;" +
            " CREATE TABLE PACIENTES (" +
            "ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(45) NOT NULL," +
            "DNI INT NOT NULL," +
            "FECHA_INGRESO DATE NOT NULL," +
            "PACIENTE_DOMICILIO_ID INT NOT NULL);";



    public static void crearTablas() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/ultimaprueba2mesasclase14", "Jairo", "oriaJ");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


