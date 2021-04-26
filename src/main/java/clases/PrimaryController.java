package clases;

import dao.UserDao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
    private static UserDao udao;
    @FXML
    private TextField userBox;
    @FXML
    private PasswordField passBox;
    @FXML
    private Label mensaje;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    private boolean checkLog() throws IOException{
        String userName = userBox.getText();
        String userPass= passBox.getText();
        try {
            udao.conectar();
            User comparacion = new User();
            comparacion=udao.verUser(userName, userPass);
            if (comparacion.getName().equals(userName)&&comparacion.getPassword().equals(userPass)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            mensaje.setText(e.getMessage());
            return false;
        }   
    }
    @FXML
    private void log() throws IOException{
        if (checkLog()) {
            App.setRoot("secondary");
        }else{
            mensaje.setText("Usuario o Contraseña erronea");
        }
    }
}
