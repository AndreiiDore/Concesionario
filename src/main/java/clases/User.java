/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Andrei
 */
public class User {
    private int id;
    private String nombre;
    private String password;
    private String preguntaSeguridad;
    private String respuesta;
    
    
    public User(){}
    
    public User(String nombre){
        this.nombre=nombre;
    }
    
    

    public User(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    
    
    
    
    

    public User(String nombre, String respuesta,String preguntaSeguridad,String password) {
        this.nombre = nombre;
        this.password = password;
        this.preguntaSeguridad = preguntaSeguridad;
        this.respuesta = respuesta;
    }

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the preguntaSeguridad
     */
    public String getPreguntaSeguridad() {
        return preguntaSeguridad;
    }

    /**
     * @param preguntaSeguridad the preguntaSeguridad to set
     */
    public void setPreguntaSeguridad(String preguntaSeguridad) {
        this.preguntaSeguridad = preguntaSeguridad;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
    
    
}
