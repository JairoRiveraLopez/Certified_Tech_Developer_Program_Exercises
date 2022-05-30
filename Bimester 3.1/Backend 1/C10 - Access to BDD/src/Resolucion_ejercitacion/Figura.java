package Resolucion_ejercitacion;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Figura {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        String sql_drop_create = "DROP TABLE IF EXISTS FIGURAS;" +
                "CREATE TABLE FIGURAS (" +
                "ID INT PRIMARY KEY," +
                "TIPOFIGURA varchar(100) NOT NULL," +
                "COLOR varchar(100) NOT NULL)";
        String sql_insert1 = "INSERT INTO FIGURAS (ID, TIPOFIGURA, COLOR) VALUES (1,'Circulo','Rojo')";
        String sql_insert2 = "INSERT INTO FIGURAS (ID, TIPOFIGURA, COLOR) VALUES (2,'Circulo','Azul')";
        String sql_insert3 = "INSERT INTO FIGURAS (ID, TIPOFIGURA, COLOR) VALUES (3,'Circulo','Verde')";
        String sql_insert4 = "INSERT INTO FIGURAS (ID, TIPOFIGURA, COLOR) VALUES (4,'Cuadrado','Rojo')";
        String sql_insert5 = "INSERT INTO FIGURAS (ID, TIPOFIGURA, COLOR) VALUES (5,'Cuadrado','Amarillo')";
        String sql_select = "SELECT * FROM FIGURAS WHERE COLOR like 'Rojo'";

        try {
            // Se estalece conexión
            connection = getConnection();
            // Se crea la tabla
            Statement statement = connection.createStatement();
            statement.execute(sql_drop_create);
            // Se insertan los datos en la table
            Statement statementInsert = connection.createStatement();
            statementInsert.execute(sql_insert1);
            statementInsert.execute(sql_insert2);
            statementInsert.execute(sql_insert3);
            statementInsert.execute(sql_insert4);
            statementInsert.execute(sql_insert5);
            ResultSet rs = statement.executeQuery(sql_select);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "-" + rs.getString(2)
                        + "-" + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/resolucionclase12", "Jairo", "1234");
    }
}


