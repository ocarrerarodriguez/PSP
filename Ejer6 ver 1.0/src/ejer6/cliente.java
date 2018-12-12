/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer6;

import java.util.Random;

/**
 *
 * @author lacuatoris
 */
public class cliente implements Runnable {
    private  Random aleatorio;
    private final Conta contenedor;
    private final int idproductor;
    private final int TIEMPOESPERA = 1000;
    private int i;
    public cliente(Conta contenedor, int idproductor) 
    {
        this.contenedor = contenedor;
        this.idproductor = idproductor;
        this.aleatorio = new Random();
        this.i=0;
    }
    @Override
    public void run() {
        for(i=0;i<10;i++)
        {
            //cantidad aleatoria a colocar
            int poner = aleatorio.nextInt(120);
            //Colocamos llamando al metodo del contenedor 
            contenedor.ingresar(poner,this.idproductor,i);
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
