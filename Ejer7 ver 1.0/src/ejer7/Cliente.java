/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer7;

import java.util.Random;

/**
 *
 * @author lacuatoris
 */
public class Cliente implements Runnable {
    private  Random aleatorio;
    private final Buzon buzon;
    private final int idproductor;
    private final int TIEMPOESPERA = 1000;
    private String comida ;
    
    public Cliente(Buzon buzon,int idproductor,String comida) 
    {
        this.buzon = buzon;
        this.idproductor = idproductor;
        this.comida = comida;
        
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            //cantidad aleatoria a colocar
            String poner ="comida: "+this.comida+" numero "+i;
            //Colocamos llamando al metodo del contenedor 
            buzon.ingresar(poner,this.idproductor,i);
            try
            {
            	//pausa entre producciones  
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + idproductor + ": Error en run -> " + e.getMessage());
            }
        }
    }
    
}