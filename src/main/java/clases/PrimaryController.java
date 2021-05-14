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
//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
    
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
    public void registar() throws IOException{
        App.setRoot("registro");
    }
    public void olvidoPass() throws IOException{
        App.setRoot("olvidoContraseña");
    }
}
