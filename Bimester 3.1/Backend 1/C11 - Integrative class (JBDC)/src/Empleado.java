import org.apache.log4j.Logger;

import java.sql.*;

public class Empleado {

    private static final Logger logger = Logger.getLogger(Empleado.class);
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        logger.info("Inicializa nuestro sistema.");

        try {
            // Se estalece conexión
            connection = getConnection();
            // Se crea la tabla
            Statement statement = connection.createStatement();
            statement.execute(SQLAux.sql_drop_create);
            // Se insertan los datos en la table
            Statement statementInsert = connection.createStatement();
            statementInsert.execute(SQLAux.sql_insert_1);
            statementInsert.execute(SQLAux.sql_insert_2);
            statementInsert.execute(SQLAux.sql_insert_3);
            try {
                statementInsert.execute(SQLAux.sql_insert_4);
            } catch (Exception e) {
                logger.error("No puede ingresarse un dato que contenga el mismo ID de un registro previo.", e);
            }
            statementInsert.execute(SQLAux.sql_insert_5);

            ResultSet rsSelect = statement.executeQuery(SQLAux.sql_select_AllInserts);
            logger.info("Se insertan los datos en la BDD");
            while (rsSelect.next()) {
                logger.debug(rsSelect.getInt(1) + "-" + rsSelect.getString(2)
                        + "-" + rsSelect.getString(3) + "-" + rsSelect.getString(4));
            }

            logger.info("Se va a hacer un aumento en el empleado llamado 'Rodrigo'");
            ResultSet rsModify = statement.executeQuery(SQLAux.sql_select_insert1);
            rsModify.next();
            logger.debug(rsModify.getInt(1) + "-" + rsModify.getString(2)
                    + "-" + rsModify.getString(3) + "-" + rsModify.getString(4));
            statementInsert.execute(SQLAux.sql_modify_data_insert1);

            ResultSet rsSelect2 = statement.executeQuery(SQLAux.sql_select_AllInserts);
            logger.info("Comprobacion cambio en la BDD (Modificacion Rodrigo)");
            while (rsSelect2.next()) {
                logger.debug(rsSelect2.getInt(1) + "-" + rsSelect2.getString(2)
                        + "-" + rsSelect2.getString(3) + "-" + rsSelect2.getString(4));
            }

            logger.info("A continuacion se eliminara un empleado (En este caso Alejandro)");
            ResultSet rsSelectBeforeDelete = statement.executeQuery(SQLAux.sql_select_insert2);
            Statement statementDelete = connection.createStatement();
            rsSelectBeforeDelete.next();
            logger.debug(rsSelectBeforeDelete.getInt(1) + "-" + rsSelectBeforeDelete.getString(2)
                    + "-" + rsSelectBeforeDelete.getString(3) + "-" + rsSelectBeforeDelete.getString(4));
            statementDelete.execute(SQLAux.sql_delete_insert2);

            logger.info("Comprobacion cambio en la BDD (Eliminacio Alejandro)");
            ResultSet rsSelect3 = statement.executeQuery(SQLAux.sql_select_AllInserts);
            while (rsSelect3.next()) {
                logger.debug(rsSelect3.getInt(1) + "-" + rsSelect3.getString(2)
                        + "-" + rsSelect3.getString(3) + "-" + rsSelect3.getString(4));
            }

            logger.info("A continuacion se eliminara un empleado (En este caso Araceli)");
            ResultSet rsSelectBeforeDelete2 = statement.executeQuery(SQLAux.sql_select_insert5);
            rsSelectBeforeDelete2.next();
            logger.debug(rsSelectBeforeDelete2.getInt(1) + "-" + rsSelectBeforeDelete2.getString(2)
                    + "-" + rsSelectBeforeDelete2.getString(3) + "-" + rsSelectBeforeDelete2.getString(4));
            statementDelete.execute(SQLAux.sql_delete_insert5);

            logger.info("Comprobacion cambio en la BDD (Eliminacio Araceli)");
            ResultSet rsSelect4 = statement.executeQuery(SQLAux.sql_select_AllInserts);
            while (rsSelect4.next()) {
                logger.debug(rsSelect4.getInt(1) + "-" + rsSelect4.getString(2)
                        + "-" + rsSelect4.getString(3) + "-" + rsSelect4.getString(4));
            }

        } catch (Exception e) {
            logger.error("Ha ocurrido algo inesperado en la instruccion al servidor", e);
        }

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/resolucionclase12", "Jairo", "1234");
    }
    }
