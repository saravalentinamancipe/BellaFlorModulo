package com.bellaflor.modulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductoDAO {

    public void insertarProducto(
            String nombre,
            String descripcion,
            double precio) {

        try {

            Connection conexion =
                    ConexionBD.conectar();

            String sql =
                    "INSERT INTO productos(nombre, descripcion, precio) VALUES (?, ?, ?)";

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);

            ps.executeUpdate();

            System.out.println("Producto insertado");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void consultarProductos() {

        try {

            Connection conexion =
                    ConexionBD.conectar();

            Statement st =
                    conexion.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM productos");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id")
                        + " | "
                        + rs.getString("nombre")
                        + " | "
                        + rs.getString("descripcion")
                        + " | $"
                        + rs.getDouble("precio"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void actualizarProducto(
            int id,
            double nuevoPrecio) {

        try {

            Connection conexion =
                    ConexionBD.conectar();

            String sql =
                    "UPDATE productos SET precio = ? WHERE id = ?";

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setDouble(1, nuevoPrecio);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Producto actualizado");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void eliminarProducto(int id) {

        try {

            Connection conexion =
                    ConexionBD.conectar();

            String sql =
                    "DELETE FROM productos WHERE id = ?";

            PreparedStatement ps =
                    conexion.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}