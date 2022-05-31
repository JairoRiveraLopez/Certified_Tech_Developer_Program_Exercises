package BDDAux;
import DAOS.MedicamentoDAOH2;
import org.apache.log4j.Logger;

import java.sql.*;
public class BDDAuxCreateTable {
    private static final Logger logger = Logger.getLogger(BDDAuxCreateTable.class);
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS FARMACIA;" +
            "CREATE TABLE FARMACIA (" +
            "ID INT PRIMARY KEY," +
            "CODIGO_NUMERO varchar(100) NOT NULL," +
            "NOMBRE varchar(100) NOT NULL," +
            "LABORATORIO_PRODUCCION varchar(100) NOT NULL," +
            "CANTIDAD int NOT NULL," +
            "PRECIO numeric (10,2) NOT NULL)";

    public static void crearTabla(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/resolucionmesasclase13", "Jairo", "oriaJ");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
        }catch (SQLException e) {
            logger.error("Error al momento de crear la tabla");
        }
    }
}
