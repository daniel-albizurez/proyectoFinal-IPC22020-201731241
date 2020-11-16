/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Solicitud;

/**
 *
 * @author DANIEL
 */
public class DaoSolicitud extends Dao<Solicitud> {

    private static final String TABLE = "solicitud";

    private static final String CODIGO = "codigo";
    private static final String SOLICITANTE = "solicitante";
    private static final String CUENTA = "cuenta";
    private static final String FECHA = "fecha";
    private static final String ESTADO = "estado";

    private static final String MARKERS = MARKER + COMA + MARKER + COMA + MARKER
            + COMA + MARKER;

    private static final String INSERT_FIELDS = " (" + SOLICITANTE + COMA + CUENTA + COMA
            + FECHA + COMA + ESTADO + ")";

    @Override
    protected PreparedStatement prepareInsert(Solicitud obj) {
        String query = String.format(INSERT, TABLE + INSERT_FIELDS, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getSolicitnate());
            statement.setInt(2, obj.getCuenta());
            statement.setString(3, obj.getFecha());
            statement.setBoolean(4, obj.isAceptada());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Solicitud obj) {
        String fields = asignValue(SOLICITANTE) + COMA
                + asignValue(CUENTA) + COMA
                + asignValue(FECHA) + COMA
                + asignValue(ESTADO);
        String query = String.format(UPDATE, TABLE, fields)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getSolicitnate());
            statement.setInt(2, obj.getCuenta());
            statement.setString(3, obj.getFecha());
            statement.setBoolean(4, obj.isAceptada());
            statement.setBoolean(4, obj.isAceptada());
            statement.setInt(5, obj.getCodigo());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareDelete(Solicitud obj) {
        String query = String.format(DELETE, TABLE)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareSelect(String fields, String condition) {
        return prepareSelect(TABLE, fields, condition);
    }

    @Override
    protected Solicitud setObject(ResultSet result) {
        Solicitud found = new Solicitud();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setSolicitnate(result.getInt(SOLICITANTE));
                found.setCuenta(result.getInt(CUENTA));
                found.setFecha(result.getString(FECHA));
                found.setAceptada(result.getBoolean(ESTADO));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
}
