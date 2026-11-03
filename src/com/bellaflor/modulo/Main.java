package com.bellaflor.modulo;

public class Main {

    public static void main(String[] args) {

        ProductoDAO productoDAO =
                new ProductoDAO();

        productoDAO.insertarProducto(
                "Orquidea Blanca",
                "Orquidea decorativa",
                65000);

        productoDAO.consultarProductos();

        productoDAO.actualizarProducto(
                1,
                70000);

        productoDAO.consultarProductos();

        productoDAO.eliminarProducto(1);

        productoDAO.consultarProductos();
    }
}