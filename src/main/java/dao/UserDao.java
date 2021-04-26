/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import clases.App;
import clases.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Andrei
 */
public class UserDao {
    private Connection conexion;
    
    public void conectar() throws ClassNotFoundException,SQLException,IOException{
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = configuration.getProperty("localhost");
        String port = configuration.getProperty("3306");
        String name = configuration.getProperty("concesionario");
        String username = configuration.getProperty("root");
        String password = configuration.getProperty("andreidore");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    
    public User verUser(String nombre, String pass) throws SQLException{ 
        String sql = "select * from usuario where nombre = ? and contraseña = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        sentencia.setString(2, pass);
        ResultSet resultado = sentencia.executeQuery();
        User us = new User();
        while (resultado.next()) {            
            us.setName(resultado.getString(1));
            us.setPassword(resultado.getString(2));
            
        }
        return us;
    }
}
