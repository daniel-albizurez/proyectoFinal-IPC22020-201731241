/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Gerente;

/**
 *
 * @author DANIEL
 */
public class DaoGerente extends DaoUsuarios<Gerente>{
    
    private static final String TABLE = "gerente";
    
    private static final String CODIGO = "codigo";
    private static final String TURNO = "turno";

    private static final String MARKERS = MARKER+COMA+MARKER;
    
    @Override
    protected PreparedStatement prepareInsert(Gerente obj) {
        String query = String.format(INSERT, TABLE, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getCodigo());
            statement.setString(2, obj.getTurno());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Gerente obj) {
        String fields = asignValue(TURNO);
        String query = String.format(UPDATE, TABLE, fields)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setString(1, obj.getTurno());
            statement.setInt(2, obj.getCodigo());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareDelete(Gerente obj) {
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
    protected Gerente setObject(ResultSet result) {
        Gerente found = new Gerente();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setTurno(result.getString(TURNO));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }
    
}
