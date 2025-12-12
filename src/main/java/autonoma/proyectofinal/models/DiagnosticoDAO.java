package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosticoDAO {

    private Connection conn;

    public DiagnosticoDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public List<Diagnostico> buscarTodos() throws SQLException {
        String sql = """
                     select
                     pac.nombre_paciente as 'nombre_paciente',
                     dia.sintomas as 'sintomas',
                     dia.enfermedades as 'enfermedades',
                     dia.recomendaciones as 'recomendaciones'
                     from diagnosticos as dia
                     join pacientes as pac on pac.paciente_id = dia.pac_paciente_id;
                     """;
        List<Diagnostico> diagnosticos;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            diagnosticos = mapearDiagnosticoDAO(rs);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                    System.out.println("Error closing result set");
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                    System.out.println("Error closing prepared statement");
                }
            }
        }

        return diagnosticos;
    }

    private List<Diagnostico> mapearDiagnosticoDAO(ResultSet rs){
        List<Diagnostico> diagnosticos = new ArrayList<>();
        try {
            while (rs.next()) {
                    Diagnostico d = new Diagnostico();
                    d.setNombre_paciente(rs.getString("nombre_paciente"));
                    d.setSintomas(rs.getString("sintomas"));
                    d.setEnfermedades(rs.getString("enfermedades"));
                    d.setRecomendaciones(rs.getString("recomendaciones"));
                    diagnosticos.add(d);
                }
            }
        catch (SQLException ex) {
            System.getLogger(EnfermedadDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return diagnosticos;
    }
}