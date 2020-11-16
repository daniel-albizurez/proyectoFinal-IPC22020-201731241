/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cambio;

/**
 *
 * @author DANIEL
 */
public class DaoCambio extends Dao<Cambio> {

    private static final String TABLE = "cambio";

    private static final String CODIGO = "codigo";
    private static final String USUARIO = "usuario";
    private static final String DESCRICPION = "descripcion";
    private static final String GERENTE = "gerente";
    private static final String FECHA = "fecha";
    private static final String HORA = "hora";
    private static final String NUEVO_VALOR = "nuevo_valor";

    private static final String MARKERS = MARKER + COMA + MARKER + COMA + MARKER + COMA
            + MARKER + COMA + MARKER + COMA + MARKER;

    private static final String INSERT_FIELDS = " (" + USUARIO + COMA + DESCRICPION + COMA + GERENTE + COMA
            + FECHA + COMA + HORA + COMA + NUEVO_VALOR + ")";

    @Override
    protected PreparedStatement prepareInsert(Cambio obj) {
        String query = String.format(INSERT, TABLE + INSERT_FIELDS, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getUsuario());
            statement.setString(2, obj.getDescripcion());
            statement.setInt(3, obj.getGerente());
            statement.setString(4, obj.getFecha());
            statement.setString(5, obj.getHora());
            statement.setString(6, obj.getNuevo_valor());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Cambio arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected PreparedStatement prepareDelete(Cambio obj) {
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
    protected Cambio setObject(ResultSet result) {
        Cambio found = new Cambio();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setUsuario(result.getInt(USUARIO));
                found.setDescripcion(result.getString(DESCRICPION));
                found.setGerente(result.getInt(GERENTE));
                found.setFecha(result.getString(FECHA));
                found.setHora(result.getString(HORA));
                found.setNuevo_valor(result.getString(NUEVO_VALOR));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }

    
}
