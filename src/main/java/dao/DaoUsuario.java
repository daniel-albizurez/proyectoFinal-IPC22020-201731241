/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Usuario;

/**
 *
 * @author DANIEL
 */
public class DaoUsuario extends Dao<Usuario> {

    public static final String TABLE = "usuario";

    public static final String CODIGO = "codigo";
    public static final String TIPO = "tipo";
    public static final String NOMBRE = "nombre";
    public static final String TIPO_DOCUMENTO = "tipo_documento";
    public static final String NO_DOCUMENTO = "no_documento";
    public static final String DIRECCION = "direccion";
    public static final String SEXO = "sexo";
    public static final String PASSWORD = "password";

    private static final String MARKERS = MARKER + COMA + MARKER + COMA + MARKER + COMA
            + MARKER + COMA + MARKER + COMA + MARKER + COMA
            + MARKER;

    private static final String INSERT_FIELDS = " (" + TIPO + COMA + NOMBRE + COMA + TIPO_DOCUMENTO + COMA
            + NO_DOCUMENTO + COMA + DIRECCION + COMA + SEXO + COMA
            + PASSWORD+")";

    @Override
    protected PreparedStatement prepareInsert(Usuario obj) {
        String query = String.format(INSERT, TABLE + INSERT_FIELDS, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getTipo());
            statement.setString(2, obj.getNombre());
            statement.setString(3, obj.getTipo_documento());
            statement.setString(4, obj.getNo_documento());
            statement.setString(5, obj.getDireccion());
            statement.setString(6, obj.getSexo());
            statement.setString(7, obj.getPassword());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Usuario obj) {
        String fields = asignValue(TIPO) + COMA
                + asignValue(NOMBRE) + COMA
                + asignValue(TIPO_DOCUMENTO) + COMA
                + asignValue(NO_DOCUMENTO) + COMA
                + asignValue(DIRECCION) + COMA
                + asignValue(SEXO) + COMA
                + ((obj.getPassword() != null || !obj.getPassword().isBlank()) ? asignValue(PASSWORD) : "");
        String query = String.format(UPDATE, TABLE, fields)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getTipo());
            statement.setString(2, obj.getNombre());
            statement.setString(3, obj.getTipo_documento());
            statement.setString(4, obj.getNo_documento());
            statement.setString(5, obj.getDireccion());
            statement.setString(6, obj.getSexo());
            if (statement.getParameterMetaData().getParameterCount() == 7) {
                statement.setString(7, obj.getPassword());
                statement.setInt(8, obj.getCodigo());
            } else {
                statement.setInt(7, obj.getCodigo());
            }
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareDelete(Usuario obj) {
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
    protected Usuario setObject(ResultSet result) {
        Usuario found = new Usuario();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setTipo(result.getInt(TIPO));
                found.setNombre(result.getString(NOMBRE));
                found.setTipo_documento(result.getString(TIPO_DOCUMENTO));
                found.setNo_documento(result.getString(NO_DOCUMENTO));
                found.setDireccion(result.getString(DIRECCION));
                found.setSexo(result.getString(SEXO));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }

}
