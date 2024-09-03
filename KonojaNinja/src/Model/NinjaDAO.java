/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import Database.Conection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class NinjaDAO {
    private Connection con;
    
    public NinjaDAO() {
        Conection db = new Conection();
        this.con = db.getConnection();
    }
    public void createNinja(Ninja ninja) {
        String query = "INSERT INTO Ninja (Nombre, Rango, Aldea) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, ninja.getNombre());
            pstmt.setString(2, ninja.getRango());
            pstmt.setString(3, ninja.getAldea());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al crear el evento en la base de datos.");
            e.printStackTrace();
        }
    }
    public List<Ninja> getAllNinjas() {
        List<Ninja> Ninjas = new ArrayList<>();
        String query = "SELECT * FROM Ninja";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Ninja ninja = new Ninja();
                ninja.setId(rs.getInt("ID_Ninja"));
                ninja.setNombre(rs.getString("Nombre"));
                ninja.setRango(rs.getString("Rango"));
                ninja.setAldea(rs.getString("Aldea"));
                Ninjas.add(ninja);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener eventos de la base de datos.");
            e.printStackTrace();
        }
        return Ninjas;
    }
    
    
    
    
    
    
    
    
}
