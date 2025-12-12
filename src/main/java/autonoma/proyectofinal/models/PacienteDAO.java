package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {
    private Connection conn;

    public PacienteDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }

    public Boolean agregarPaciente(String N, String A, int E) throws SQLException {
        String sql = "INSERT INTO pacientes (nombre_paciente, apellido, edad) VALUES (? , ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, N);
            ps.setString(2, A);
            ps.setInt(3, E);
            int f = ps.executeUpdate();

            return f > 0;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                    System.out.println("Error clossing Prepared Statement");
                }
            }
        }
    }
    
    public int obtenerIdPaciente(String N) throws SQLException {
        String sql = "SELECT paciente_id FROM pacientes WHERE nombre_paciente = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, N);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("paciente_id");
            }
            return -1;

        } catch (SQLException e) {
            System.out.println("Error al obtener ID del paciente: " + e.getMessage());
            return -1;
        }
    }

}