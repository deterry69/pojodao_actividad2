package dao;

import pojo.Pelicula;
import pojo.Actor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {
    private String url = "jdbc:mysql://localhost:3307/entregable";
    private String user = "root";
    private String pass = "1234";

    public void insertar(Pelicula p) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "INSERT INTO peliculas (titulo, genero, duracion, presupuesto) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getTitulo());
            pstmt.setString(2, p.getGenero());
            pstmt.setInt(3, p.getDuracion());
            pstmt.setDouble(4, p.getPresupuesto());
            pstmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void actualizar(Pelicula p, int id) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "UPDATE peliculas SET titulo=?, genero=?, duracion=?, presupuesto=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getTitulo());
            pstmt.setString(2, p.getGenero());
            pstmt.setInt(3, p.getDuracion());
            pstmt.setDouble(4, p.getPresupuesto());
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void borrar(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "DELETE FROM peliculas WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void obtenerConTotalActores() {
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT p.titulo, COUNT(r.actor_id) as total FROM peliculas p LEFT JOIN reparto r ON p.id = r.pelicula_id GROUP BY p.id";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println("Película: " + rs.getString("titulo") + " | Actores: " + rs.getInt("total"));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public List<Pelicula> obtenerTop3Presupuesto() {
        List<Pelicula> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            String sql = "SELECT * FROM peliculas ORDER BY presupuesto DESC LIMIT 3";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) { lista.add(mapear(rs)); }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
        return lista;
    }

    private Pelicula mapear(ResultSet rs) throws SQLException {
        Pelicula p = new Pelicula();
        p.setId(rs.getInt("id"));
        p.setTitulo(rs.getString("titulo"));
        p.setGenero(rs.getString("genero"));
        p.setDuracion(rs.getInt("duracion"));
        p.setPresupuesto(rs.getDouble("presupuesto"));
        return p;
    }
}