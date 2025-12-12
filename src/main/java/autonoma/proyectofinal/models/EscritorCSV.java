package autonoma.proyectofinal.models;

import java.io.FileWriter;
import java.io.IOException;

public class EscritorCSV {
    
    public EscritorCSV(){
        
    }
    
    public void escribirCSV(String reporte, String nombreArchivo){
        try(FileWriter writer = new FileWriter(nombreArchivo)){
            writer.write(reporte);
            System.out.println("Archivo CSV generado exitosamente: " + nombreArchivo);
        } catch (IOException e){
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
