package clases;

import dao.UserDao;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
    private static UserDao udao;
    @FXML
    private TextField userBox;
    @FXML
    private PasswordField passBox;
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void log() throws IOException{
        String userName = userBox.getText();
        String userPass= passBox.getText();
        
        String sqlConsulta ="select * from usuario where nombre= \""+userName+"\" and contraseña=\""+userPass+"\";";
        //https://byspel.com/como-hacer-un-login-en-java-con-base-de-datos-mysql/3/
    
        
    }
}
