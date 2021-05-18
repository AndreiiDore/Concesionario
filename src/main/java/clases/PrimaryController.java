package clases;

import clases.dao.UserDao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
    private static UserDao udao;
    private static App a;
    @FXML
    private TextField userBox;
    @FXML
    private PasswordField passBox;
    @FXML
    private Label mensaje;
    /**
     * metodo por el cual vamos a hacer el login de un usuario
     * @throws IOException 
     */
    @FXML
    private void log() throws IOException{
        String userName = userBox.getText();
        String userPass= passBox.getText();
        try {
            udao = new UserDao();
            User orig =new User(userName,userPass);
            
            udao.conectar();
            User comp =udao.verUser(orig);

            if (comp!=null) {
                a.setNombreUser(userName);
                App.setRoot("secondary");
            } else {
                mensaje.setText("Usuario o contraseña incorrecta");
            }
        } catch (Exception e) {
            mensaje.setText(e.getMessage());
        }
    }
    /**
     * metodo que nos va a pasar a otra pantalla en la que podemos registrar 
     * a nuevos usuarios
     * @throws IOException 
     */
    public void registar() throws IOException{
        App.setRoot("registro");
    }
    /**
     * metodo por el cual vamos a pasar a otra pantalla en la que podemos recuperar
     * la contraseña de un usuario
     * @throws IOException 
     */
    public void olvidoPass() throws IOException{
        App.setRoot("olvidoContraseña");
    }
}
