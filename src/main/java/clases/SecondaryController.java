package clases;


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
import javafx.scene.control.Label;
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
    @FXML
    private Label errorBox;
    @FXML
    private Label exitoBox;
    
    
   /**
    * metodo para volver a la pantalla de login
    * @throws IOException 
    */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    /**
     * metodo por el cual vamos a inicializar la lista de vehiculos que tengamos 
     * en nuestra base de datos
     * @throws ClassNotFoundException
     * @throws IOException 
     */
    @FXML
    public void initLists() throws ClassNotFoundException, IOException{
       CarDao coche = new CarDao();
       lista.getItems().clear();
        try {
            coche.conectar();
            List<Coche> coches = coche.listCoches();
            lista.setItems(FXCollections.observableArrayList(coches));
            

        } catch (SQLException sqle) {
            errorBox.setText(sqle.getMessage());
        }
        
    }
    /**
     * metodo por el cual vamos a poner la informacion de cada vehiculo en las
     * cajas correspondientes
     * @param c coche que vamos a cargar en nuestra vista mas detallada
     */
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
    /**
     * Metodo para seleccionar un coche de nuestra lista
     * @param e Evento
     */
    @FXML
    public void seleccionarCoche(Event e){
        cocheSel=(Coche)lista.getSelectionModel().getSelectedItem();
        cargarCoche(cocheSel);
    }
    /**
     * metodo por el cual vamos a borrar un coche de nuesta base de datos
     */
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
            exitoBox.setText("Coche añadido");
        } catch (Exception e) {
            errorBox.setText(e.getMessage());
        }
        
    }
    /**
     * metodo por el cual vamos a añadir un nuevo coche a nuestra base de datos
     */
    @FXML 
    public void newCar(){
        CarDao cocheD = new CarDao();
        Coche coche = new Coche();
        coche.setMarca(marca.getText());
        coche.setModelo(modelo.getText());
        coche.setMatricula(matricula.getText());
        coche.setColor(color.getText());
        coche.setPrecio(Integer.valueOf(precio.getText()));
        coche.setDueño(Integer.valueOf(id.getText()));
        try {
            cocheD.conectar();
            cocheD.nuevoCohe(coche);
            exitoBox.setText("Un coche mas para la coleccion");

        } catch (Exception e) {
            errorBox.setText(e.getMessage());
            System.out.println(e.getMessage());
        }
        
    }
}