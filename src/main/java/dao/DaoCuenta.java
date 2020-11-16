/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Cuenta;

/**
 *
 * @author DANIEL
 */
public class DaoCuenta extends Dao<Cuenta> {

    private static final String TABLE = "cuenta";

    private static final String CODIGO = "codigo";
    private static final String CLIENTE = "cliente";
    private static final String SALDO = "saldo";
    private static final String FECHA_CREACION = "fecha_creacion";

    private static final String MARKERS = MARKER + COMA + MARKER + COMA + MARKER;

    private static final String INSERT_FIELDS = " (" + CLIENTE + COMA + SALDO + COMA + FECHA_CREACION + ")";

    @Override
    protected PreparedStatement prepareInsert(Cuenta obj) {
        String query = String.format(INSERT, TABLE + INSERT_FIELDS, MARKERS);
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getCliente());
            statement.setDouble(2, obj.getSaldo());
            statement.setString(3, obj.getFecha_creacion());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareUpdate(Cuenta obj) {
        String fields = asignValue(CLIENTE) + COMA
                + asignValue(SALDO) + COMA
                + asignValue(FECHA_CREACION);
        String query = String.format(UPDATE, TABLE, fields)
                + String.format(WHERE, asignValue(CODIGO));
        try {
            PreparedStatement statement = CONNECTION.prepareStatement(query);
            statement.setInt(1, obj.getCliente());
            statement.setDouble(2, obj.getSaldo());
            statement.setString(3, obj.getFecha_creacion());
            statement.setInt(4, obj.getCodigo());
            return statement;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected PreparedStatement prepareDelete(Cuenta obj) {
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
    protected Cuenta setObject(ResultSet result) {
        Cuenta found = new Cuenta();
        try {
            if (result.first()) {
                found.setCodigo(result.getInt(CODIGO));
                found.setCliente(result.getInt(CLIENTE));
                found.setSaldo(result.getDouble(SALDO));
                found.setFecha_creacion(result.getString(FECHA_CREACION));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            found = null;
        }
        return found;
    }
}
