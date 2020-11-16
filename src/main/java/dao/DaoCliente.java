/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cliente;

/**
 *
 * @author DANIEL
 */
public class DaoCliente extends DaoUsuarios<Cliente>{
    
    public static final String TABLE = "cliente";
    
    public static final String CODIGO = "codigo";
    public static final String RUTA_DPI = "ruta_dpi";
    public static final String FECHA_NACIMIENTO = "fecha_nacimiento";

    private static final String MARKERS = MARKER+COMA+MARKER+COMA+MARKER;
    
    @Override
    protected PreparedStatement prepareInsert(Cliente obj) {
        String query = String.format(INSERT, TABLE, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getCodigo());
            statement.setString(2, obj.getRuta_dpi());
            statement.setString(3, obj.getFecha_nacimiento());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Cliente obj) {
        String fields = asignValue(RUTA_DPI) + COMA + asignValue(FECHA_NACIMIENTO);
        String query = String.format(UPDATE, TABLE, fields)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setString(1, obj.getRuta_dpi());
            statement.setString(2, obj.getFecha_nacimiento());
            statement.setInt(3, obj.getCodigo());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareDelete(Cliente obj) {
        String query = String.format(DELETE, TABLE)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getCodigo());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareSelect(String fields, String conditions) {
        return prepareSelect(TABLE, fields, conditions);
    }

    @Override
    protected Cliente setObject(ResultSet result) {
        Cliente found = new Cliente();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setRuta_dpi(result.getString(RUTA_DPI));
                found.setFecha_nacimiento(result.getString(FECHA_NACIMIENTO));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }
    
}
