/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Andrei
 */
public class RegistroController implements Initializable {

    @FXML
    private TextField nombreUsuario;
    @FXML
    private PasswordField contraseniaUsuario;
    @FXML
    private TextField preguntaUsuario;
    @FXML
    private TextField respuestaUsuario;
    @FXML
    private Label mensaje;
    
     private static UserDao udao;
     
    @FXML
    public void registar() throws IOException, SQLException{
        String nombre=nombreUsuario.getText();
        String password=contraseniaUsuario.getText();
        String pregunta=preguntaUsuario.getText();
        String respuesta=respuestaUsuario.getText();
        User alta=new User(nombre,password,pregunta,respuesta);
       // mensaje.setText("Hasta aqui ok");
       try {
            udao= new UserDao();
            udao.conectar();
            udao.addUser(alta);
            mensaje.setText("Usuario dado de Alta\nVaya a la página principal");
        } catch (Exception e) {
            mensaje.setText(e.getMessage());
        }
        
        
    }
    @FXML
    public void atras() throws IOException{
        App.setRoot("primary");
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
