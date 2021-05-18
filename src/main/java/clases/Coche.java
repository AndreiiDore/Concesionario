/*
 * Hereda de la clase Abstracta Vehiculo.
 * Tendremos en cuenta de que tendremos que implementar el metodo toString 
 */
package clases;

/**
 *
 * @author Andrei
 */
public class Coche extends Vehiculo{
    
    private int puertas;
    private String tipoCombustible;
   
    /**
     * Constructor vacio
     */
    public Coche(){};

    /**
     * Constructor con todos los datos necesarios para crear el obejeto completo
     * @param id identificador del coche
     * @param marca marca del coche
     * @param modelo modelo de la marca de coche
     * @param matricula matricula del coche
     * @param color color del coche 
     * @param dueño identificador del dueño al cual le pertenece el mismo
     * @param precio precio por el cual esta tasado
     */
    public Coche(int id, String marca,String modelo,
            String matricula, String color, int dueño, int precio) {
        super(id, marca, modelo,matricula, color, dueño, precio);
        this.puertas = puertas;
        this.tipoCombustible = tipoCombustible;
    }
    
    
    
    /**
     * Metodo por el cual vamos a devolver solamente la marca del coche
     * @return marca del coche
     */
    @Override
    public String toString() {
        return getMarca();
    }

    /**
     * @return the puertas
     */
    public int getPuertas() {
        return puertas;
    }

    /**
     * @param puertas the puertas to set
     */
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    /**
     * @return the tipoCombustible
     */
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    /**
     * @param tipoCombustible the tipoCombustible to set
     */
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    
}
