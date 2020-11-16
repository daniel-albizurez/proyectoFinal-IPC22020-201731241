/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Asociacion;

/**
 *
 * @author DANIEL
 */
public class DaoAsociacion extends Dao<Asociacion>{
    
    private static final String TABLE = "asociacion";
    
    private static final String CLIENTE = "cliente";
    private static final String CUENTA = "cuenta";
    
    private static final String MARKERS = MARKER+COMA+MARKER;

    @Override
    protected PreparedStatement prepareInsert(Asociacion obj) {
        String query = String.format(INSERT, TABLE, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getCliente());
            statement.setInt(2, obj.getCuenta());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Asociacion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected PreparedStatement prepareDelete(Asociacion obj) {
        String query = String.format(DELETE, TABLE)
                + String.format(WHERE, asignValue(CLIENTE) + AND + asignValue(CUENTA));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getCliente());
            statement.setInt(2, obj.getCuenta());
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
    protected Asociacion setObject(ResultSet result) {
        Asociacion found = new Asociacion();
        try {
            if (result.first()) {
                found.setCliente(result.getInt(CLIENTE));
                found.setCuenta(result.getInt(CUENTA));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }
}
