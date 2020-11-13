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
public class Cliente extends Usuario{
    private static final int TIPO = 3;
    private String ruta_dpi;
    private String fecha_nacimiento;

    public Cliente() {
        super(TIPO);
    }

    public String getRuta_dpi() {
        return ruta_dpi;
    }
    public void setRuta_dpi(String ruta_dpi) {
        this.ruta_dpi = ruta_dpi;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
       
}
