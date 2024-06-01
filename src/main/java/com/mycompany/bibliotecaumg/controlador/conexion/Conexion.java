/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliotecaumg.controlador.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author willymorales
 */
public class Conexion {
    

public class ConnectionDBA {
    private static final String DATABASE="bdlibreria2025";
    private static final String SERVER_NAME="pbdlibreria2025.postgres.database.azure.com";
    private static final String PORT ="5432";
    private static final String URL="jdbc:postgresql://"+SERVER_NAME+":"+PORT+"/"+DATABASE;
    private static final String SERVER_ADMIN_LOGIN_NAME="User2024";
    private static final String PASSWORD_ADMIN_LOGIN_PASSWORD="Biblioteca2024/";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, SERVER_ADMIN_LOGIN_NAME, PASSWORD_ADMIN_LOGIN_PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return connection;
    }
}
    
}
