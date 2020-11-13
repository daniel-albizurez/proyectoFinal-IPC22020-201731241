/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DANIEL
 */
public class Usuario {
    
    private int codigo;
    private int tipo;
    private String nombre;
    private String tipo_documento;
    private String no_documento;
    private String direccion;
    private String sexo;
    private String password;

    public Usuario(int tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }
    private void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }
    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNo_documento() {
        return no_documento;
    }
    public void setNo_documento(String no_documento) {
        this.no_documento = no_documento;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    private String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
