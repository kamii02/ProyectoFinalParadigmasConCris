package autonoma.proyectofinal.models;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Diagnostico {

    public Diagnostico() {
    }

    public boolean insertarDiagnosticoBD(Integer pacienteId, List<String> sintomas) throws SQLException {
        DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAO();

        // Mapa para guardar: nombre_sintoma -> sintoma_id
        Map<String, Integer> sintomasEncontrados = new HashMap<>();

        // 1. Buscar el ID de cada síntoma
        for (String nombreSintoma : sintomas) {
            Integer sintomaId = diagnosticoDAO.obtenerIdSintoma(nombreSintoma);
            if (sintomaId != null) {
                sintomasEncontrados.put(nombreSintoma, sintomaId);
            }
        }

        if (sintomasEncontrados.isEmpty()) {
            System.out.println("No se encontraron síntomas válidos en la BD");
            return false;
        }

        // 2. Buscar enfermedades relacionadas con cada síntoma
        Set<Integer> enfermedadesEncontradas = new HashSet<>();

        for (Integer sintomaId : sintomasEncontrados.values()) {
            List<Integer> enfermedades = diagnosticoDAO.buscarEnfermedadesPorSintoma(sintomaId);
            enfermedadesEncontradas.addAll(enfermedades);
        }

        if (enfermedadesEncontradas.isEmpty()) {
            System.out.println("No se encontraron enfermedades relacionadas");
            return false;
        }

        // 3. Insertar diagnóstico en la BD
        boolean exitoso = true;

        for (Integer enfermedadId : enfermedadesEncontradas) {
            for (Integer sintomaId : sintomasEncontrados.values()) {
                boolean resultado = diagnosticoDAO.insertarDiagnostico(pacienteId, sintomaId, enfermedadId);
                if (!resultado) {
                    exitoso = false;
                }
            }
        }

        return exitoso;
    }
}