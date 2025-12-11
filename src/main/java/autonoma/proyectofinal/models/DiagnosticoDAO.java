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

    // Insertar un registro de diagnóstico
    public boolean insertarDiagnostico(Integer pacienteId, Integer sintomaId, Integer enfermedadId) throws SQLException {
        String sql = "INSERT INTO Diagnostico (pac_paciente_id, sin_sintoma_id, enf_enfermedad_id) VALUES (?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, pacienteId);
            ps.setInt(2, sintomaId);
            ps.setInt(3, enfermedadId);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}