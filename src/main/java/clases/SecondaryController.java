package clases;

import Enum.Gasolina;
import clases.dao.CarDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SecondaryController {
    
    private static CarDao cdao;
    private Coche cocheSel;
    private static App a;
    
    @FXML
    private TextField marca;
    @FXML
    private TextField modelo;
    @FXML
    private TextField idCoche;
    @FXML
    private TextField matricula;
    @FXML
    private TextField color;
    @FXML
    private TextField id;
    @FXML
    private TextField precio;
    @FXML
    private ListView lista;
    
    private ObservableList <Gasolina> gasofla= FXCollections.observableArrayList(Arrays.asList(Gasolina.values()));
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
//    public void comboPosiciones(){
//        gasolina.setItems(FXCollections.observableArrayList(Arrays.asList(Gasolina.values())));
//    }
    @FXML
    public void initLists() throws ClassNotFoundException, IOException{
       CarDao coche = new CarDao();
       lista.getItems().clear();
        try {
            coche.conectar();
            List<Coche> coches = coche.listCoches();
            lista.setItems(FXCollections.observableArrayList(coches));
            

        } catch (SQLException sqle) {
            System.out.println("error");
        }
        
    }
    @FXML
    public void cargarCoche(Coche c){
        marca.setText(c.getMarca());
        modelo.setText(c.getModelo());
        matricula.setText(c.getMatricula());
        color.setText(c.getColor());
        id.setText(String.valueOf(c.getDueño()));
        precio.setText(String.valueOf(c.getPrecio()));
        idCoche.setText(String.valueOf(c.getId()));
       
    }
    @FXML
    public void seleccionarCoche(Event e){
        cocheSel=(Coche)lista.getSelectionModel().getSelectedItem();
        cargarCoche(cocheSel);
    }
    @FXML
    public void deleteCar(){
        CarDao cocheD = new CarDao();
        Coche coche = new Coche();
        coche.setMarca(marca.getText());
        coche.setModelo(modelo.getText());
        coche.setMatricula(matricula.getText());
        coche.setColor(color.getText());
        coche.setPuertas(Integer.valueOf(precio.getText()));
        coche.setId(Integer.valueOf(idCoche.getText()));
        try {
            cocheD.conectar();
            cocheD.borrarCoche(coche);
            System.out.println("Coche dado de baja");
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
        
    }
    @FXML 
    public void newCar(){
        CarDao cocheD = new CarDao();
        Coche coche = new Coche();
        coche.setMarca(marca.getText());
        coche.setModelo(modelo.getText());
        coche.setMatricula(matricula.getText());
        coche.setColor(color.getText());
        coche.setPrecio(Integer.valueOf(precio.getText()));
        try {
            cocheD.conectar();
            cocheD.nuevoCohe(coche);

        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        
    }
}