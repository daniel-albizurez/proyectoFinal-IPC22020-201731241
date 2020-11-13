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
public class Transaccion {
    
    private int codigo;
    private int cuenta;
    private String tipo;
    private double monto;
    private String fecha;
    private String hora;
    private int cajero;

    public Transaccion() {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCuenta() {
        return cuenta;
    }
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
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

    public int getCajero() {
        return cajero;
    }
    public void setCajero(int cajero) {
        this.cajero = cajero;
    }
}
