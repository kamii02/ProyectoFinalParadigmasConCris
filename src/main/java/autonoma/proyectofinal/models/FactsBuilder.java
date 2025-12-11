package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FactsBuilder {
    private Connection conn;
    
    public FactsBuilder(){
        this.conn = MySQLConnection.getInstance().getConnection();
    }
    
    public static boolean construirFactsEnfermedad(){
        EnfermedadDAO dao = new EnfermedadDAO();
        try {
            List<Enfermedad> lista = dao.buscarTodos();

            for (Enfermedad t : lista) {
                StringBuilder sb = new StringBuilder();
                sb.append("assertz(enfermedad(")
                        .append(t.getNombreEnfermedad()).append(", sintomas([");
                for (int i = 0; i < t.getListaSintomas().size(); i++) {
                    sb.append(t.getListaSintomas().get(i));
                    if (i < t.getListaSintomas().size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]), categoria(")
                        .append(t.getNombreCategoria()).append("), recomendaciones([")
                        .append(t.getRecomendacionBasica()).append("])))");
                PrologQueryExecutor.createDynamicFact(sb.toString());
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving data");
        }
        return true;
    }   
}
