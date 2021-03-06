/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.dao;

import clases.App;
import clases.Coche;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Andrei
 */
public class CarDao {
    private Connection conexion;
    /**
     * Metodo por el cual vamos a recoger los datos necesarios de la conexion
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
     * metodo que vamos a usar para desconectarnos
     * @throws SQLException 
     */
    public void desconectar() throws SQLException {
        conexion.close();
    }
    /**
     * Metodo por el cual iniciamos la lista para poder ver los coches que 
     * deseemos en cada momento
     * @return
     * @throws SQLException 
     */
    public List<Coche> listCoches() throws SQLException {
        List<Coche> coches = new ArrayList<>();
        String sql = "call verCoches";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            Coche carricohe = new Coche();
            carricohe.setId(resultado.getInt(1));
            carricohe.setMarca(resultado.getString(2));
            carricohe.setModelo(resultado.getString(3));
            carricohe.setMatricula(resultado.getString(4));
            carricohe.setColor(resultado.getString(5));
            carricohe.setDue??o(resultado.getInt(6));
            carricohe.setPrecio(resultado.getInt(7));

            coches.add(carricohe);
        }


        return coches;
    }
    /**
     * Metodo por el cual vamos a borrar un coche por el id que tenga el mismo
     * @param c coche con los datos necesarios
     * @throws SQLException 
     */
    public void borrarCoche(Coche c) throws SQLException{
        String sql = "delete from coche where id =?;";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1,c.getId());
        sentencia.executeQuery();
    }
    /**
     * Metodo por el cual vamos a recoger un coche y vamos a sustituir las
     * interrogantes con los valores que queramos
     * @param c coche que recogemos
     * @throws SQLException 
     */
    public void nuevoCohe(Coche c) throws SQLException{
        String sql="insert into coche (marca,modelo,matricula,color,duenio,precio) values(?,?,?,?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setString(1,c.getMarca());
        sentencia.setString(2,c.getModelo());
        sentencia.setString(3,c.getMatricula());
        sentencia.setString(4,c.getColor());
        sentencia.setInt(5,c.getDue??o());
        sentencia.setInt(6,c.getPrecio());
        sentencia.executeQuery();
}
}
