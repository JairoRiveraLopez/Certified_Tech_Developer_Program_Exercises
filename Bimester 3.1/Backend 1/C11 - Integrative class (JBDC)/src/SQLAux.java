public class SQLAux {
    public static String sql_drop_create = "DROP TABLE IF EXISTS EMPLEADOS;" +
            "CREATE TABLE EMPLEADOS (" +
            "ID INT PRIMARY KEY," +
            "NOMBRE varchar(100) NOT NULL," +
            "CARGO varchar(100) NOT NULL," +
            "SALARIO DECIMAL(6,2) NOT NULL)";
    public static String sql_insert_1 = "INSERT INTO EMPLEADOS (ID, NOMBRE, CARGO, SALARIO) VALUES (1,'Rodrigo','Auxiliar','600.00')";
    public static String sql_insert_2 = "INSERT INTO EMPLEADOS (ID, NOMBRE, CARGO, SALARIO) VALUES (2,'Alejandro','Coordinador','800.00')";
    public static String sql_insert_3 = "INSERT INTO EMPLEADOS (ID, NOMBRE, CARGO, SALARIO) VALUES (3,'Antonella','Analista','700.00')";
    public static String sql_insert_4 = "INSERT INTO EMPLEADOS (ID, NOMBRE, CARGO, SALARIO) VALUES (3,'Milena','Analista','700.00')";
    public static String sql_insert_5 = "INSERT INTO EMPLEADOS (ID, NOMBRE, CARGO, SALARIO) VALUES (4,'Araceli','Jefe','1200.00')";

    public static String sql_modify_data_insert1 = "UPDATE EMPLEADOS SET CARGO = 'Analista', SALARIO = '700.00' WHERE ID = 1";

    public static String sql_select_insert1 = "SELECT * FROM EMPLEADOS WHERE ID = 1";
    public static String sql_select_insert2 = "SELECT * FROM EMPLEADOS WHERE ID = 2";
    public static String sql_select_insert5 = "SELECT * FROM EMPLEADOS WHERE CARGO LIKE 'Jefe'";
    public static String sql_select_AllInserts = "SELECT * FROM EMPLEADOS";

    public static String sql_delete_insert2 = "DELETE FROM EMPLEADOS WHERE ID = 2";
    public static String sql_delete_insert5 = "DELETE FROM EMPLEADOS WHERE CARGO LIKE 'Jefe'";


}
