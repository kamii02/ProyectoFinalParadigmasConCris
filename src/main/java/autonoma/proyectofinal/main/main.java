package autonoma.proyectofinal.main;
import autonoma.proyectofinal.models.*;
import java.sql.SQLException;
import autonoma.proyectofinal.views.VentanaPrincipal;
import java.util.List;
import org.jpl7.Query;

public class main {

public static void main(String[] args) throws SQLException {
        String rules = "consult('proyecto.pl')";
       
        Query q = new Query(rules);

        if (q.hasSolution()) {
            System.out.println("Archivo Prolog cargado correctamente.");
        }
        FactsBuilder.construirFactsEnfermedad();
        List<Enfermedad> lista = PrologQueryExecutor.getSolutions("enfermedad(Nombre,sintomas(Sintomas),categoria(Categoria),recomendaciones(Recomendaciones))");
        for(Enfermedad e : lista){
            System.out.println("Nombre: " + e.getNombreEnfermedad());
            System.out.println("Sintomas: " + e.getListaSintomas());
            System.out.println("Categoria: " + e.getNombreCategoria());
            System.out.println("Recomendaciones: " + e.getRecomendacionBasica());
        }
        
        VentanaPrincipal ventanaprincipal = new VentanaPrincipal();
        ventanaprincipal.setVisible(true);
        ventanaprincipal.setLocationRelativeTo(null);
    }
}