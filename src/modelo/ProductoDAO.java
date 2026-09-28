package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.conexionbd;

public class ProductoDAO {

    private conexionbd conexion;

    public ProductoDAO() {
        conexion = new conexionbd();
    }

    public boolean crearProducto(producto p) {
        String sql = "INSERT INTO productos (nombre, precio, cantidad) VALUES (?, ?, ?)";

        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setFloat(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());

            ps.executeUpdate();
            ps.close();
            con.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<producto> listarProductos() {
        ArrayList<producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                producto p = new producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getFloat("precio"),
                        rs.getInt("cantidad")
                );
                lista.add(p);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            return null;
        }

        return lista;
    }

    public boolean modificarProducto(producto p) {
        String sql = "UPDATE productos SET nombre=?, precio=?, cantidad=? WHERE id=?";

        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setFloat(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());
            ps.setInt(4, p.getId());

            ps.executeUpdate();
            ps.close();
            con.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean borrarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id=?";

        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
            con.close();

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
