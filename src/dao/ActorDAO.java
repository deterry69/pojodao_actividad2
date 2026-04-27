package dao;

import pojo.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    private String url = "jdbc:mysql://localhost:3307/entregable";
    private String user = "root";
    private String pass = "1234";

    public void insertar(Actor a) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO actores (nombre, nacionalidad, edad) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a.getNombre());
            pstmt.setString(2, a.getNacionalidad());
            pstmt.setInt(3, a.getEdad());
            pstmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void asignarAPelicula(int idActor, int idPelicula, String personaje) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO reparto (actor_id, pelicula_id, personaje) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idActor);
            pstmt.setInt(2, idPelicula);
            pstmt.setString(3, personaje);
            pstmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void obtenerConteoNacionalidad() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // EL FAMOSO GROUP BY QUE TE PIDIÓ EL PROFE
            String sql = "SELECT nacionalidad, COUNT(*) as total FROM actores GROUP BY nacionalidad";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println("Nacionalidad: " + rs.getString("nacionalidad") + " | Total: " + rs.getInt("total"));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public double obtenerEdadMedia() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT AVG(edad) FROM actores";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            if (rs.next()) return rs.getDouble(1);
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
        return 0;
    }

    private Actor mapear(ResultSet rs) throws SQLException {
        Actor a = new Actor();
        a.setId(rs.getInt("id"));
        a.setNombre(rs.getString("nombre"));
        a.setNacionalidad(rs.getString("nacionalidad"));
        a.setEdad(rs.getInt("edad"));
        return a;
    }
}