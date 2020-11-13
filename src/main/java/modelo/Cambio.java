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
public class Cambio {
    private int codigo;
    private int usuario;
    private String descripcion;
    private int gerente;
    private String fecha;
    private String hora;
    private String nuevo_valor;

    public Cambio() {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuario() {
        return usuario;
    }
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getGerente() {
        return gerente;
    }
    public void setGerente(int gerente) {
        this.gerente = gerente;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNuevo_valor() {
        return nuevo_valor;
    }
    public void setNuevo_valor(String nuevo_valor) {
        this.nuevo_valor = nuevo_valor;
    }
    
    
}
