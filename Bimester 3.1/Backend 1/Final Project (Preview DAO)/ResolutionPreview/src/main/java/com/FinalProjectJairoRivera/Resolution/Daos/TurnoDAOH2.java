package com.FinalProjectJairoRivera.Resolution.Daos;

import com.FinalProjectJairoRivera.Resolution.Connections.H2Connection;
import com.FinalProjectJairoRivera.Resolution.Domains.Odontologo;
import com.FinalProjectJairoRivera.Resolution.Domains.Paciente;
import com.FinalProjectJairoRivera.Resolution.Domains.Turno;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TurnoDAOH2 implements IDao<Turno>{
    private static final Logger logger = Logger.getLogger(TurnoDAOH2.class);
    private static final String SQL_INSERT = "INSERT INTO TURNOS (PACIENTE_ID, ODONTOLOGO_ID, FECHA) VALUES (?,?,?);";
    private static final String SQL_SELECT_ALL = "SELECT * FROM TURNOS";
    private static final String SQL_SELECT_ID = "SELECT * FROM TURNOS WHERE TURNO_ID = ?";
    private static final String SQL_SELECT_DATE = "SELECT * FROM TURNOS WHERE FECHA = ?";
    private static final String SQL_DELETE = "DELETE FROM TURNOS WHERE TURNO_ID = ?";
    private static final String SQL_UPDATE = "UPDATE TURNOS SET PACIENTE_ID = ?, ODONTOLOGO_ID = ?, FECHA = ? WHERE TURNO_ID = ?";
    @Override
    public List listarElementos() {
        Connection connection = null;
        List<Turno> listaTurnos = new ArrayList<>();
        Turno turno = null;

        try {
            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                turno = new Turno(rs.getInt(1),
                        pacienteDAOH2.buscarXId(rs.getInt(2)),
                        odontologoDAOH2.buscarXId(rs.getInt(3)),
                        rs.getDate(4).toLocalDate());
                listaTurnos.add(turno);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return listaTurnos;
    }

    @Override
    public Turno buscarXCriterio(String criterio) {
        Connection connection = null;
        Turno turno = null;
        try {
            SimpleDateFormat sqlformat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date formatoFechaSql = sqlformat.parse(criterio);
            java.sql.Date fechaConsulta = new java.sql.Date(formatoFechaSql.getTime());

            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_DATE);
            ps.setDate(1, fechaConsulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                turno = new Turno(rs.getInt(1),
                        pacienteDAOH2.buscarXId(rs.getInt(2)),
                        odontologoDAOH2.buscarXId(rs.getInt(3)),
                        rs.getDate(4).toLocalDate());
            }

        } catch (Exception e) {
            logger.error("El formato de la fecha debe ser como el siguiente ejemplo: '2006-06-24'", e);
        } finally {
            try{
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return turno;
    }

    @Override
    public Turno buscarXId(int id) {
        Connection connection = null;
        Turno turno = null;

        try{
            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                turno = new Turno(rs.getInt(1),
                        pacienteDAOH2.buscarXId(rs.getInt(2)),
                        odontologoDAOH2.buscarXId(rs.getInt(3)),
                        rs.getDate(4).toLocalDate());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return turno;
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
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Turno actualizar(Turno turno) {
        Connection connection = null;
        if (verificarPacienteOdontologo(turno)) {
            try {
                connection = H2Connection.getConnection();
                PreparedStatement psUpdate = null;
                psUpdate = connection.prepareStatement(SQL_UPDATE);
                psUpdate.setInt(1, turno.getPaciente().getId());
                psUpdate.setInt(2, turno.getOdontologo().getId());
                psUpdate.setDate(3, Date.valueOf(turno.getFecha()));
                psUpdate.setInt(4, turno.getId());
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
        }
        return turno;
    }

    @Override
    public Turno guardar(Turno turno) {
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            connection=H2Connection.getConnection();
            ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, turno.getPaciente().getId());
            ps.setInt(2, turno.getOdontologo().getId());
            ps.setDate(3, Date.valueOf(turno.getFecha()));
            ps.execute();
            ResultSet key = ps.getGeneratedKeys();
            while (key.next()){
                turno.setId(key.getInt(1));
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
        return turno;
    }
    boolean verificarPacienteOdontologo(Turno turno) {
        IDao<Paciente> pacienteDAOH2 = new PacienteDAOH2();
        IDao<Odontologo> odontologoDAOH2 = new OdontologoDAOH2();
        int pacienteId = turno.getPaciente().getId();
        int odontologoId = turno.getOdontologo().getId();
        if (pacienteDAOH2.buscarXId(pacienteId) != null && odontologoDAOH2.buscarXId(odontologoId) != null) {
            return true;
        }
        if (pacienteDAOH2.buscarXId(pacienteId) == null) {
            logger.error("Paciente no encontrado en la Base de Datos.");
        } else if (odontologoDAOH2.buscarXId(odontologoId) == null) {
            logger.error("Odontologo no encontrado en la Base de Datos.");
        }
        return false;
    }
}
