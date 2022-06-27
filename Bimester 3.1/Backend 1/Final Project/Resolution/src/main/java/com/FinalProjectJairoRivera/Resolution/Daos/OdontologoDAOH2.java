package com.FinalProjectJairoRivera.Resolution.Daos;


import com.FinalProjectJairoRivera.Resolution.Connections.H2Connection;
import com.FinalProjectJairoRivera.Resolution.Domains.Odontologo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OdontologoDAOH2 implements IDao<Odontologo>{

    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (APELLIDO, NOMBRE, MATRICULA) VALUES (?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    private static final String SQL_SELECT_MATR = "SELECT * FROM ODONTOLOGOS WHERE MATRICULA = ?";
    private static final String SQL_SELECT_ID = "SELECT * FROM ODONTOLOGOS WHERE ODONTOLOGO_ID = ?";
    private static final String SQL_DELETE = "DELETE FROM ODONTOLOGOS WHERE ODONTOLOGO_ID=?";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET APELLIDO = ?, NOMBRE = ?, MATRICULA = ? WHERE ODONTOLOGO_ID = ?";

    @Override
    public List<Odontologo> listarElementos() {
        Connection connection = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();
        Odontologo odontologo = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getInt(4));
                listaOdontologos.add(odontologo);
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
        return listaOdontologos;
    }

    @Override
    public Odontologo buscarXCriterio(String criterio) {
        Integer matricula = Integer.parseInt(criterio);
        Connection connection = null;
        Odontologo odontologo = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_MATR);
            ps.setInt(1, matricula);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getInt(4));
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
        return odontologo;
    }

    @Override
    public Odontologo buscarXId(int id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1),
                        rs.getString(2), rs.getString(3),
                        rs.getInt(4));
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
        return odontologo;
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
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement psUpdate = null;
        try{
            connection=H2Connection.getConnection();
            psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, odontologo.getApellido());
            psUpdate.setString(2, odontologo.getNombre());
            psUpdate.setInt(3, odontologo.getMatricula());
            psUpdate.setInt(4, odontologo.getId());

            psUpdate.executeUpdate();
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
        return odontologo;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection=H2Connection.getConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setInt(3, odontologo.getMatricula());
            preparedStatement.execute();
            ResultSet key = preparedStatement.getGeneratedKeys();
            while (key.next()){
                odontologo.setId(key.getInt(1));
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
        return odontologo;
    }
}
