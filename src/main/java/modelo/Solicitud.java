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
public class Solicitud {
    private int codigo;
    private int solicitnate;
    private int cuenta;
    private String fecha;
    private boolean aceptada;

    public Solicitud() {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSolicitnate() {
        return solicitnate;
    }
    public void setSolicitnate(int solicitnate) {
        this.solicitnate = solicitnate;
    }

    public int getCuenta() {
        return cuenta;
    }
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isAceptada() {
        return aceptada;
    }
    public void setAceptada(boolean aceptada) {
        this.aceptada = aceptada;
    } 
}
