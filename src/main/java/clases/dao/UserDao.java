/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.dao;

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
        configuration.load(new FileInputStream(new File(App.class.getResource("ConectionBD.properties").getPath())));        
        String host = configuration.getProperty("host");
        String port = configuration.getProperty("port");
        String name = configuration.getProperty("name");
        String username = configuration.getProperty("username");
        String password = configuration.getProperty("password");

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                username, password);
    }
    public void desconectar() throws SQLException {
        conexion.close();
    }
    
    public User verUser(User u) throws SQLException{
        boolean encontrado =false;
        String sql = "select * from usuario where nombre = ? and contraseña = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2, u.getPassword());
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {            
            u.setNombre(resultado.getString(2));
            u.setPassword(resultado.getString(3));
            encontrado = true;
        }
        if (encontrado) {
            return u;
        }else{
            return null;
        }
    }
    public String verPregunta(User u) throws SQLException{
        boolean encontrado=false; 
        String sql="select pregunta from usuario where nombre=?";
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         sentencia.setString(1, u.getNombre());
         ResultSet resultado = sentencia.executeQuery();
         while(resultado.next()){
             u.setNombre(resultado.getString(1));
             encontrado=true;
         }
         if (encontrado) {
             return u.getNombre();
            //return resultado.getNString(0);
        } else {
             return "No se encontro";
        }
        
         
    }
    
    public void addUser(User u) throws SQLException{
        String sql="insert into usuario(nombre,contraseña,pregunta,respuesta)values(?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2,u.getPassword());
        sentencia.setString(3,u.getPreguntaSeguridad());
        sentencia.setString(4,u.getRespuesta());
        ResultSet resultado = sentencia.executeQuery();
    }
    public User verRespuesta(User u) throws SQLException{
        boolean encontrado = false;
        String sql="select id,respuesta from usuario where nombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {            
            u.setId(resultado.getInt(1));
            u.setRespuesta(resultado.getString(2));
            
            encontrado = true;
        }
        if (encontrado) {
            return u;
        }else{
            return null;
        }
    }
    public void cambiarContraseña(User u) throws SQLException{
         String sql="update usuario set contraseña = ? where id=?";
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         sentencia.setString(1,u.getPassword());
         sentencia.setInt(2,u.getId());
         sentencia.execute();
    }
}
