package com.dh.odontologos.BDDAUX;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BBDAux {
    private static final Logger logger = Logger.getLogger(BBDAux.class);
    private static final String SQL_CREATE_TABLES = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
    "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY," +
            "MATRICULA INT NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL);" +

    "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (1598, 'Jairo', 'Rivera');" +
    "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (1785, 'Miranda', 'Olivera');" +
    "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (152, 'Antonio', 'Villamizar');";


    public static void crearTablas() throws SQLException{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/parcialprueba6JairoRivera","User","visitante");
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLES);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


