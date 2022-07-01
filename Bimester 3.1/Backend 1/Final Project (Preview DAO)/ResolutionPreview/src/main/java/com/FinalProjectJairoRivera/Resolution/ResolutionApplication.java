package com.FinalProjectJairoRivera.Resolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ResolutionApplication {

	public static void main(String[] args) {
		prepararBD();
		SpringApplication.run(ResolutionApplication.class, args);
	}
	private static void prepararBD(){
		Connection connection=null;
		try{
			Class.forName("org.h2.Driver");
			connection= DriverManager.getConnection("jdbc:h2:~/FinalProjectResolucion6.0" +
							";INIT=RUNSCRIPT FROM 'create.sql'",
					"JairoRivera","0o99i88u7");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try{
				connection.close();
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}

}
