/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Transaccion;

/**
 *
 * @author DANIEL
 */
public class DaoTransaccion extends Dao<Transaccion> {

    private static final String TABLE = "transaccion";

    private static final String CODIGO = "codigo";
    private static final String CUENTA = "cuenta";
    private static final String TIPO = "tipo";
    private static final String MONTO = "monto";
    private static final String FECHA = "fecha";
    private static final String HORA = "hora";
    private static final String CAJERO = "cajero";

    private static final String MARKERS = MARKER + COMA + MARKER + COMA + MARKER + COMA
            + MARKER + COMA + MARKER + COMA + MARKER;

    private static final String INSERT_FIELDS = " (" + CUENTA + COMA + TIPO + COMA
            + MONTO + COMA + FECHA + COMA + HORA + COMA
            + CAJERO + ")";

    @Override
    protected PreparedStatement prepareInsert(Transaccion obj) {
        String query = String.format(INSERT, TABLE + INSERT_FIELDS, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getCuenta());
            statement.setString(2, obj.getTipo());
            statement.setDouble(3, obj.getMonto());
            statement.setString(4, obj.getFecha());
            statement.setString(5, obj.getHora());
            statement.setInt(6, obj.getCajero());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Transaccion obj) {
        String fields = asignValue(CUENTA) + COMA
                + asignValue(TIPO) + COMA
                + asignValue(MONTO) + COMA
                + asignValue(FECHA) + COMA
                + asignValue(HORA) + COMA
                + asignValue(CAJERO);
        String query = String.format(UPDATE, TABLE, fields)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getCuenta());
            statement.setString(2, obj.getTipo());
            statement.setDouble(3, obj.getMonto());
            statement.setString(4, obj.getFecha());
            statement.setString(5, obj.getHora());
            statement.setInt(6, obj.getCajero());
            statement.setInt(7, obj.getCodigo());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareDelete(Transaccion obj) {
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
    protected Transaccion setObject(ResultSet result) {
        Transaccion found = new Transaccion();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setCuenta(result.getInt(CUENTA));
                found.setTipo(result.getString(TIPO));
                found.setMonto(result.getDouble(MONTO));
                found.setFecha(result.getString(FECHA));
                found.setHora(result.getString(HORA));
                found.setCajero(result.getInt(CAJERO));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }

    
}
