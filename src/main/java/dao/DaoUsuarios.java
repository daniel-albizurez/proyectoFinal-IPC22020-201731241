/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;

/**
 *
 * @author DANIEL
 * @param <T>
 */
public abstract class DaoUsuarios<T extends Usuario> extends Dao<T> {
    
    private final DaoUsuario daoUsuario = new DaoUsuario();

    @Override
    public boolean insert(T obj) {
        boolean success;
        try {
            CONNECTION.setAutoCommit(false);
            if ((success = (daoUsuario.insert(obj) && super.insert(obj)))) {
                CONNECTION.commit();
            }else{
                CONNECTION.rollback();
            }
            CONNECTION.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            success = false;
        }
        return success;
    }

    @Override
    public boolean update(T obj) {
        return daoUsuario.update(obj) && super.update(obj);
    }
    
    
    @Override
    public boolean delete(T obj) {
        return super.delete(obj) && daoUsuario.delete(obj);
    }

    @Override
    public T select(String condition) {
        T found = super.select(condition);
        Usuario user = daoUsuario.select(
                "codigo" + EQUALS + QUOTE + found.getCodigo() + QUOTE);
        found.setTipo(user.getTipo());
        found.setNombre(user.getNombre());
        found.setTipo_documento(user.getTipo_documento());
        found.setNo_documento(user.getNo_documento());
        found.setDireccion(user.getDireccion());
        found.setSexo(user.getSexo());
        return found;
    }
    
}
