package autonoma.proyectofinal.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;

public class PrologQueryExecutor {
    public static void createDynamicFact(String fact){
        Query q = new Query(fact);
        if (q.hasSolution()) {
            System.out.println("Hecho dinamico agregado: " + fact);
        }
    }
    
    public static List<Enfermedad> getSolutions(String rule) {
        List<Enfermedad> lista = new ArrayList<>();
        Query q = new Query(rule);
        while (q.hasMoreSolutions()) {
            Map<String, Term> solution = q.nextSolution(); // nextSolution(); -> Sgte solución de una consulta en Prolog
            
            String nombre = null;
            Term nombreT = solution.get("Nombre");
            if (nombreT != null) {
                nombre = nombreT.toString();
            }

            List<String> sintomas = null;
            Term sintomasT = solution.get("Sintomas");
            if (sintomasT != null) {
                sintomas = prologListToJavaList(sintomasT);
            }
            
            String categoria = null;
            Term categoriaT = solution.get("Categoria");
            if(categoriaT != null){
                categoria = categoriaT.toString();
            }

            String recomendaciones = null;
            Term recomendacionesT = solution.get("Recomendaciones");
            if (recomendacionesT != null){
                recomendaciones = recomendacionesT.toString();
            }
            Enfermedad e = new Enfermedad(nombre, sintomas, categoria, recomendaciones);
            lista.add(e);
        }

        q.close();
        return lista;
    }
    
    private static List<String> prologListToJavaList(Term t){
        List <String> lista = new ArrayList();
        Term list = t;
        
        while (list.isListPair()){
            Term head = list.arg(1);
            lista.add(head.toString());
            list = list.arg(2);
        }
        
        return lista;
    } 
}
