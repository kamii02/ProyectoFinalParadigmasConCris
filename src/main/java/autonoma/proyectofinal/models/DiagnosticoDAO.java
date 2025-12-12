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

    // Obtener el ID de un síntoma por su nombre
    public Integer obtenerIdSintoma(String nombreSintoma) throws SQLException {
        String sql = "SELECT sintoma_id FROM Sintomas WHERE nombre_sintoma = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer sintomaId = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombreSintoma);
            rs = ps.executeQuery();

            if (rs.next()) {
                sintomaId = rs.getInt("sintoma_id");
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                }
            }
        }

        return sintomaId;
    }

    // Buscar enfermedades que tengan un síntoma específico
    public List<Integer> buscarEnfermedadesPorSintoma(Integer sintomaId) throws SQLException {
        String sql = "SELECT enf_enfermedad_id FROM Sintomas_Enfermedades WHERE sin_sintoma_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> enfermedadIds = new ArrayList<>();

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sintomaId);
            rs = ps.executeQuery();

            while (rs.next()) {
                enfermedadIds.add(rs.getInt("enf_enfermedad_id"));
            }

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                }
            }
        }

        return enfermedadIds;
    }
    public boolean insertarDiagnosticoCompleto(int pacienteId, String sintomas, String enfermedades, String recomendaciones) throws SQLException {
        String sql = "INSERT INTO diagnosticos (pac_paciente_id, sintomas, enfermedades, recomendaciones) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pacienteId);
            ps.setString(2, sintomas);
            ps.setString(3, enfermedades);
            ps.setString(4, recomendaciones);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar diagnóstico: " + e.getMessage());
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    public List<Diagnostico> buscarTodos() throws SQLException {
        String sql = "select pac.nombre_paciente as 'nombre_paciente', dia.sintomas as 'sintomas', dia.enfermedades as 'enfermedades', dia.recomendaciones as 'recomendaciones' from diagnosticos as dia join pacientes as pac on pac.paciente_id = dia.pac_paciente_id";
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