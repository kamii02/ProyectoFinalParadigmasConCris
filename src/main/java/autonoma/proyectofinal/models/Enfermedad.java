package autonoma.proyectofinal.models;

import java.util.ArrayList;
import java.util.List;

public class Enfermedad {
    private int id;
    private String nombreEnfermedad;
    private String recomendacionBasica;
    private String nombreCategoria;
    private List<String> listaSintomas;

    public Enfermedad() {
        this.listaSintomas = new ArrayList<>();
    }
    
    public Enfermedad(int id, String nombreEnfermedad, List sintomas, String recomendacionBasica, String nombreCategoria) {
        this.id = id;
        this.nombreEnfermedad = nombreEnfermedad;
        this.recomendacionBasica = recomendacionBasica;
        this.nombreCategoria = nombreCategoria;
        this.listaSintomas = new ArrayList<>();
    }
    
    public Enfermedad( String nombreEnfermedad, List sintomas, String recomendacionBasica, String nombreCategoria) {
        this.nombreEnfermedad = nombreEnfermedad;
        this.recomendacionBasica = recomendacionBasica;
        this.nombreCategoria = nombreCategoria;
        this.listaSintomas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getRecomendacionBasica() {
        return recomendacionBasica;
    }

    public void setRecomendacionBasica(String recomendacionBasica) {
        this.recomendacionBasica = recomendacionBasica;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<String> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<String> listaSintomas) {
        this.listaSintomas = listaSintomas;
    } 
}
