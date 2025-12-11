/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectofinal.models;

/**
 *
 * @author camil
 */
public class Sintomas {
    private int sintoma_id;
    private String nombre_sintoma;

    public Sintomas() {
    }

    public Sintomas(int sintoma_id, String nombre_sintoma) {
        this.sintoma_id = sintoma_id;
        this.nombre_sintoma = nombre_sintoma;
    }

    public int getSintoma_id() {
        return sintoma_id;
    }

    public void setSintoma_id(int sintoma_id) {
        this.sintoma_id = sintoma_id;
    }

    public String getNombre_sintoma() {
        return nombre_sintoma;
    }

    public void setNombre_sintoma(String nombre_sintoma) {
        this.nombre_sintoma = nombre_sintoma;
    }
    
    
}
