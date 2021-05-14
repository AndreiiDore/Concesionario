/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Enum.Gasolina;

/**
 *
 * @author Andrei
 */
public class Coche extends Vehiculo{
    
    private int puertas;
    private String tipoCombustible;
   
    
    public Coche(){};

    public Coche(int id, String marca,String modelo,
            String matricula, String color, int dueño, int precio) {
        super(id, marca, modelo,matricula, color, dueño, precio);
        this.puertas = puertas;
        this.tipoCombustible = tipoCombustible;
    }
    
    
    
    
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
