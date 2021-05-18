/*
 * Clase Abstracta 
 */
package clases;

/**
 *
 * @author Andrei
 */
public abstract class Vehiculo {
    private int id;
    private String marca;
    private String modelo;
    private String matricula;
    private String color;
    private int dueño;
    private int precio;
    /**
     * Constructor vacio
     */
    public Vehiculo(){};
    /**
     * Constructor con todos los parametos que necesitamos para crear un objeto
     * de la clase Vehiculo completo aunque no se pueda instanciar
     * @param id
     * @param marca
     * @param modelo
     * @param matricula
     * @param color
     * @param dueño
     * @param precio 
     */
    public Vehiculo(int id, String marca, String modelo,String matricula, String color, int dueño,int precio ) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.color = color;
        this.dueño = dueño;
        this.precio=precio;
    }

    
    /**
     * metodo abstarcto con el cual tenemos la obligacion de implementarlo en 
     * las clases que se hereden
     * @return no retorna nada
     */
    @Override
    public abstract String toString();
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the dueño
     */
    public int getDueño() {
        return dueño;
    }

    /**
     * @param dueño the dueño to set
     */
    public void setDueño(int dueño) {
        this.dueño = dueño;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    
}
