/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer3;

/**
 *
 * @author lacuatoris
 */
public class hijo3 extends Thread {
    
    int nombre;
    int parametro;
    Thread hilo1;
    hijo3(int nome,int parametro)
    {   
        super(Integer.toString(nome));
        this.nombre=nome;
        this.parametro=parametro;
        System.out.println("hola soy:"+nome);
                   
            if( nombre<5)
            {
                
                hilo1 = new hijo3((this.nombre+1),10);
                this.hilo1.start();
            }
        
        
        
    }
    
    public void run()   
    {
        
        for(int i=1;i<this.parametro;i++)
        {
            
            
            System.out.println(" soy el hilo "+i+" n ejecucion "+this.nombre);
        }
        System.out.println("termina el thread "+this.nombre);
        if(this.nombre!=5)
        {
            try {
                 hilo1.join();
            } catch (InterruptedException e){
                System.out.println("Fío interrumpido.");
            }

           
        }
     }
    
}
