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
        //Properties configuration = new Properties();
        //configuration.load(new FileInputStream(new File(App.class.getResource("connectionDB.properties").getPath())));
        String host = "localhost";
        String port = "3306";
        String name = "concesionario";
        String username = "root";
        String password = "andreidore";

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
         String sql="select pregunta from usuario where nombre=?";
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         sentencia.setString(1, u.getNombre());
         ResultSet resultado = sentencia.executeQuery();
         while(resultado.next()){
             return resultado.getString(1);
         }
        return "No se encontro";
         
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
}
