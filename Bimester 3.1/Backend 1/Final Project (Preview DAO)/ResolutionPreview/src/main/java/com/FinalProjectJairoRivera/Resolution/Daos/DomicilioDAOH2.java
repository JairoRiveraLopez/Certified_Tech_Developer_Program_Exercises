package com.FinalProjectJairoRivera.Resolution.Daos;

import com.FinalProjectJairoRivera.Resolution.Connections.H2Connection;
import com.FinalProjectJairoRivera.Resolution.Domains.Domicilio;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class DomicilioDAOH2 implements IDao<Domicilio>{

    private static final String SQL_INSERT = "INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?,?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM DOMICILIOS";
    private static final String SQL_SELECT_CALLENUM = "SELECT * FROM DOMICILIOS WHERE NUMERO = ?";
    private static final String SQL_SELECT_ID = "SELECT * FROM DOMICILIOS WHERE DOMICILIO_ID = ?";
    private static final String SQL_DELETE = "DELETE FROM DOMICILIOS WHERE DOMICILIO_ID=?";
    private static final String SQL_UPDATE = "UPDATE DOMICILIOS SET CALLE = ?, NUMERO = ?, LOCALIDAD = ?, FECHA-PROVINCIA = ? WHERE DOMICILIO_ID = ?";

    @Override
    public List<Domicilio> listarElementos() {
        Connection connection = null;
        List<Domicilio> listaDomicilios = new ArrayList<>();
        Domicilio domicilio = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5));
                listaDomicilios.add(domicilio);
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
        return listaDomicilios;
    }




    @Override
    public Domicilio buscarXCriterio(String criterio) {
        Integer calleNum = Integer.parseInt(criterio);
        Connection connection = null;
        Domicilio domicilio = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_CALLENUM);
            ps.setInt(1, calleNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5));
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
        return domicilio;
    }

    @Override
    public Domicilio buscarXId(int id) {
        Connection connection = null;
        Domicilio domicilio = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5));
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
        return domicilio;
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
    public Domicilio actualizar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement psUpdate = null;
        try{
            connection=H2Connection.getConnection();
            psUpdate = connection.prepareStatement(SQL_UPDATE);
            psUpdate.setString(1, domicilio.getCalle());
            psUpdate.setInt(2, domicilio.getNumero());
            psUpdate.setString(3, domicilio.getLocalidad());
            psUpdate.setString(4, domicilio.getProvincia());
            psUpdate.setInt(5, domicilio.getId());
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
        return domicilio;
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection=H2Connection.getConnection();

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.execute();

            ResultSet key = preparedStatement.getGeneratedKeys();
            while (key.next()){
                domicilio.setId(key.getInt(1));
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
        return domicilio;
    }
}
