/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer6;

/**
 *
 * @author lacuatoris
 */
public class Conta {
    private int saldo = 200;
    private boolean candado= false;
    //Método para colocar mas contenido en el contenedor
    public synchronized void ingresar(int value,int idproductor,int vuelta) {
        //Si el contenedor esta open
        if( candado==Boolean.FALSE)
        {
            candado=Boolean.TRUE;
            
            System.out.println("***************** INI_PRODUCTOR "+vuelta+"********************");
            System.out.println("CANTIDAD EN CONTENEDOR: " + saldo);
            this.saldo+=value;
            System.out.println("El productor " + idproductor + " pone: " + value+" resta el saldo: "+ this.saldo);
            System.out.println("***************** FIN_PRODUCTOR ********************");
            //Despertamos los hilos pausados
            candado=Boolean.FALSE;
            notifyAll();
        }
        else
        {
            try {
                //Pausamos el hilo hasta que haya hueco para colocar
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
    }
    
    public synchronized int retirar(int value,int idproductor,int vuelta) {
        int resultado=0;
        //Si el contenedor esta open
        if( candado==Boolean.FALSE)
        {
            //System.out.println(saldo+">"+value);
            if (saldo >value) {
                candado=Boolean.TRUE;
                
                //Mostramos por pantalla el estado del contenedor
                System.out.println("***************** INI_CONSUMIDOR "+vuelta+"********************");
                System.out.println("CANTIDAD EN CONTENEDOR: " + this.saldo);
                this.saldo -= value;
                System.out.println("El consumidor " + idproductor + " retira: " + value+" resta el saldo: "+ this.saldo);
                System.out.println("***************** FIN_CONSUMIDOR ********************");
                resultado=value;
                //Despertamos los hilos pausados
                candado=Boolean.FALSE;
                notifyAll();
            }else
            {
                try {
                //Pausamos el hilo hasta que haya hueco para colocar
                wait();
                } catch (InterruptedException e) {
                    System.err.println("Contenedor: Error en put -> " + e.getMessage());
                }
            }
        }
        else
        {
            try {
                //Pausamos el hilo hasta que haya hueco para colocar
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }    
        
        
       return resultado; 
    } 
        
        
       
    
}

			
		