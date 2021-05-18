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
    /**
     * Metodo por el cual vamos a recoger los datos necesarios para la conexion 
     * a la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException 
     */
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
    /**
     * metodo por el cual vamos a desconectarnos de la base de datos
     * @throws SQLException 
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }
    /**
     * metodo para ver que el usuario que estamos introduciendo existe
     * en nuestra base de datos
     * @param u usuario que comprobamos que existe
     * @return
     * @throws SQLException 
     */
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
    /**
     * metodo por el cual nos muestra la pregunta de seguridad de un usuario
     * que tenga el mismo nombre
     * @param u usuario con el nombre
     * @return pregunta de seguridad 
     * @throws SQLException 
     */
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
        } else {
             return "No se encontro";
        }
        
         
    }
    /**
     * metodo por el cual creamos un usuario en nuestra base de datos
     * para ello vamos a usar la consulta de insert
     * @param u usuario con los datos que le vamos a meter en la base de datos
     * @throws SQLException 
     */
    public void addUser(User u) throws SQLException{
        String sql="insert into usuario(nombre,contraseña,pregunta,respuesta)values(?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2,u.getPassword());
        sentencia.setString(3,u.getPreguntaSeguridad());
        sentencia.setString(4,u.getRespuesta());
        ResultSet resultado = sentencia.executeQuery();
    }
    /**
     * metodo por el cual vamos a combrobar de que la respuesta de seguridad
     * de un usuario es igual a la que mete el usuario que esta usando la
     * aplicacion
     * @param u objeto de tipo usuario que tiene los datos necesarios para la 
     * consulta
     * @return un usuario o nulo
     * @throws SQLException 
     */
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
    /**
     * metodo por el cual un usuario cambia la contraseña
     * @param u usuario con los dats necessarios
     * @throws SQLException 
     */
    public void cambiarContraseña(User u) throws SQLException{
         String sql="update usuario set contraseña = ? where id=?";
         PreparedStatement sentencia = conexion.prepareStatement(sql);
         sentencia.setString(1,u.getPassword());
         sentencia.setInt(2,u.getId());
         sentencia.execute();
    }
}
