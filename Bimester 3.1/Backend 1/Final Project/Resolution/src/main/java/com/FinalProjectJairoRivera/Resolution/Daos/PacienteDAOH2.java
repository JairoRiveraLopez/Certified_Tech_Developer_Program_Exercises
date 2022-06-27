package com.FinalProjectJairoRivera.Resolution.Daos;

import com.FinalProjectJairoRivera.Resolution.Connections.H2Connection;
import com.FinalProjectJairoRivera.Resolution.Domains.Domicilio;
import com.FinalProjectJairoRivera.Resolution.Domains.Paciente;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PacienteDAOH2 implements IDao<Paciente>{

    private static final String SQL_INSERT = "INSERT INTO PACIENTES (APELLIDO, NOMBRE, EMAIL, DNI, FECHA_INGRESO, PACIENTE_DOMICILIO_ID) VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM PACIENTES";
    private static final String SQL_SELECT_DNI = "SELECT * FROM PACIENTES WHERE DNI = ?";
    private static final String SQL_SELECT_ID = "SELECT * FROM PACIENTES WHERE PACIENTE_ID = ?";
    private static final String SQL_DELETE = "DELETE FROM PACIENTES WHERE PACIENTE_ID=?";
    private static final String SQL_UPDATE = "UPDATE PACIENTES SET APELLIDO = ?, NOMBRE = ?, EMAIL = ?, DNI = ?, FECHA-INGRESO = ?, PACIENTE_DOMICILIO_ID = ? WHERE PACIENTE_ID = ?";


    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente> listaPacientes = new ArrayList<>();
        Paciente paciente = null;
        Domicilio domicilioQuery = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
                domicilioQuery = domicilioDAOH2.buscarXId(rs.getInt(7));
                paciente = new Paciente(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getDate(6).toLocalDate(), domicilioQuery);
                listaPacientes.add(paciente);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return listaPacientes;
        }

    @Override
    public Paciente buscarXCriterio(String criterio) {
        Integer DNINum = Integer.parseInt(criterio);
        Connection connection = null;
        Paciente pacienteBusqDNI = null;
        Domicilio domicilioBusqDNI = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_DNI);
            ps.setInt(1, DNINum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
                domicilioBusqDNI = domicilioDAOH2.buscarXId(rs.getInt(7));
                pacienteBusqDNI = new Paciente(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getDate(6).toLocalDate(), domicilioBusqDNI);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pacienteBusqDNI;
    }

    @Override
    public Paciente buscarXId(int id) {
        Connection connection = null;
        Paciente pacienteBusqID = null;
        Domicilio domicilioBusqID = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
                domicilioBusqID = domicilioDAOH2.buscarXId(rs.getInt(7));
                pacienteBusqID = new Paciente(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getDate(6).toLocalDate(), domicilioBusqID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pacienteBusqID;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = H2Connection.getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement psUpdate = null;
        Integer domicilioID = paciente.getDomicilio().getId();

        try{
            connection=H2Connection.getConnection();
            psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, paciente.getApellido());
            psUpdate.setString(2, paciente.getNombre());
            psUpdate.setString(3, paciente.getEmail());
            psUpdate.setInt(4, paciente.getDni());
            psUpdate.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            psUpdate.setInt(6, domicilioID);
            psUpdate.setInt(7, paciente.getId());

            psUpdate.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            domicilioDAOH2.guardar(paciente.getDomicilio());
            connection = H2Connection.getConnection();

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, paciente.getApellido());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getEmail());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(6, paciente.getDomicilio().getId());

            preparedStatement.execute();

            ResultSet key = preparedStatement.getGeneratedKeys();
            while (key.next()){
                paciente.setId(key.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return paciente;
    }
}
