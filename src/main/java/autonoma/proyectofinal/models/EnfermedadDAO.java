package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnfermedadDAO {
    private Connection conn;   // <–– the connection stays here as an attribute

    public EnfermedadDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public List<Enfermedad> buscarTodos() throws SQLException {
        String sql = """
                     select e.nombre_enfermedad as "nombre_enfermedad", e.recomendacion_basica as "recomendacion_basica",
                     s.nombre_sintoma as "nombre_sintoma",
                     c.nombre_categoria as "nombre_categoria"
                     from enfermedades as e
                     join sintomas_enfermedades as se on e.enfermedad_id = se.enf_enfermedad_id
                     join sintomas as s on s.sintoma_id = se.sin_sintoma_id
                     join categorias as c on c.categoria_id = e.cat_categoria_id;
                     """;
        List<Enfermedad> enfermedades;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            enfermedades = mapearEnfermedadDAO(rs);
        } finally {
            if (rs != null) {
                try {
                    rs.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing result set");
                }
            }
                
            if (ps != null){
                try {
                    ps.close(); 
                } catch (SQLException ignored) {
                    System.out.println("Error closing prepared statement");
                }
            }
        }

        return enfermedades;
    }
    
    
    private List<Enfermedad> mapearEnfermedadDAO(ResultSet rs){
        List<Enfermedad> enfermedades = new ArrayList<>();
        Set<String> enfermedadesSinDuplicados = new HashSet<>();
        
        try {
            while (rs.next()) {
                if(!enfermedadesSinDuplicados.contains(rs.getString("nombre_enfermedad"))){
                    enfermedadesSinDuplicados.add(rs.getString("nombre_enfermedad"));
                    enfermedadesSinDuplicados.add(rs.getString("nombre_categoria"));
                    enfermedadesSinDuplicados.add(rs.getString("recomendacion_basica"));
                    Enfermedad e = new Enfermedad();
                    
                    e.setNombreEnfermedad(rs.getString("nombre_enfermedad"));
                    e.getListaSintomas().add(rs.getString("nombre_sintoma"));
                    e.setNombreCategoria(rs.getString("nombre_categoria"));
                    e.setRecomendacionBasica(rs.getString("recomendacion_basica"));
                    enfermedades.add(e);
                }else{
                    for(int  i=0; i<enfermedades.size(); i++){
                        if(enfermedades.get(i).getNombreEnfermedad().equals(rs.getString("nombre_enfermedad"))){
                            enfermedades.get(i).getListaSintomas().add(rs.getString("nombre_sintoma"));
                            break;
                        }
                    }
                }
                
            }
        } catch (SQLException ex) {
            System.getLogger(EnfermedadDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return enfermedades;
    }
}
