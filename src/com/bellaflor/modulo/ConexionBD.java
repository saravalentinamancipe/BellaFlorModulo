package com.bellaflor.modulo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/bella_flor";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection conectar() {

        try {

            Connection conexion =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            System.out.println("Conexion exitosa");

            return conexion;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }
}