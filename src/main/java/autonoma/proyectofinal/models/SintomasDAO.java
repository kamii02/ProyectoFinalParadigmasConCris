/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.proyectofinal.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public class SintomasDAO {
    private Connection conn;

    public SintomasDAO() {
        this.conn = MySQLConnection.getInstance().getConnection();
    }
    
    public List<Sintomas> obtenerSintomas() throws SQLException {
        String sql = "SELECT * FROM sintomas";
        List<Sintomas> sintomas;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            sintomas = mapearSintomasObjeto(rs);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignored) {
                    System.out.println("Error clossing result set");
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignored) {
                    System.out.println("Error clossing Prepared Statement");
                }
            }
        }
        return sintomas;
    }

    private List<Sintomas> mapearSintomasObjeto(ResultSet rs) {
        List<Sintomas> sintomas = new ArrayList<>();
        try {
            while (rs.next()) {
                Sintomas s = new Sintomas();
                s.setNombre_sintoma(rs.getString("nombre_sintoma"));
                s.setSintoma_id(rs.getInt("sintoma_id"));
                sintomas.add(s);
            }
        } catch (SQLException ex) {
            System.getLogger(SintomasDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return sintomas;
    }
}
