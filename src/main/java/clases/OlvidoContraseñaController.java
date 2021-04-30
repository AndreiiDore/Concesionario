/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.dao.UserDao;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Andrei
 */
public class OlvidoContraseñaController implements Initializable {
    @FXML
    private TextField nombreUsuario;
    @FXML
    private TextField preguntaUsuario;
    @FXML
    private Label mensajeError;
    @FXML
    private TextField respuestaSeguridad;
    @FXML
    private PasswordField nuevaContraseña;
    private static UserDao udao;
    
    @FXML
    public void checkNombre(){
        User usuario =new User(nombreUsuario.getText());
        udao = new UserDao();
        try{
            udao.conectar();
            String pregunta=udao.verPregunta(usuario);
            preguntaUsuario.setText(pregunta);
        }catch(Exception e){
            mensajeError.setText(e.getMessage());
        }
    }
    @FXML
    public void ckeckPregunta(){
        udao= new UserDao();
        User usuario = new User(nombreUsuario.getText(),preguntaUsuario.getText(),
                respuestaSeguridad.getText(),nuevaContraseña.getText());
        User comparacion =new User();
        try {
            udao.conectar();
            comparacion=udao.verRespuesta(usuario);
            if (comparacion.getRespuesta().equals(usuario.getRespuesta())) {
                udao.cambiarContraseña(usuario);
            mensajeError.setText("Contraseña actualizada");
            }else{
                mensajeError.setText("No se pudo actualizar la contraseña");
            }
            
       } catch (Exception e) {
            mensajeError.setText(e.getMessage());
        }
    }
//    public void ckeckPregunta(){
//        udao=new UserDao();
//        String usuario=nombreUsuario.getText();
//        String respuestaTexto=respuestaSeguridad.getText();
//        int respuesta=Integer.parseInt(respuestaTexto);
//        int respuestaBBDD=0;
//        String nuevaPass=nuevaContraseña.getText();
//        try {
//            respuestaBBDD=udao.verRespuesta(usuario);
//        } catch (Exception e) {
//            mensajeError.setText(e.getMessage());
//        }
//        if (respuestaBBDD==respuesta) {
//            try {
//                udao.cambiarContraseña(usuario,nuevaPass);
//            } catch (Exception e) {
//                mensajeError.setText(e.getMessage());
//            }
//            
//        } else {
//            mensajeError.setText("No se pudo hacer el cambio de contraseña");
//        }
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
