/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer7;
/**
 *
 * @author lacuatoris
 */
public class Buzon {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    private String contenido = "";
    private boolean candado_entrada= false;
    private boolean candado_salida= true;
    //Método para colocar mas contenido en el contenedor
    public synchronized void ingresar(String value,int idproductor,int vuelta) {
        while(candado_entrada!=Boolean.FALSE)
        {
            try {
                //Pausamos el hilo hasta que haya hueco para colocar
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        //Si el contenedor esta open
        if( candado_entrada==Boolean.FALSE)
        {
            if (contenido == "") {
                candado_entrada=Boolean.TRUE;
                System.out.println("***************** INI_PRODUCTOR "+vuelta+"********************");
                System.out.println("El productor " + idproductor + " pone el mensaje en el BUZON: " + value);
                this.contenido=value;
                System.out.println("***************** FIN_PRODUCTOR ********************");
                //Despertamos los hilos pausados
                candado_salida=Boolean.FALSE;
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
        
    }
    public synchronized String retirar(int idproductor,int vuelta) {
        String resultado="";
        while(candado_salida!=Boolean.FALSE)
        {
            try {
                //Pausamos el hilo hasta que haya hueco para colocar
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        //Si el contenedor esta open
        if( candado_salida==Boolean.FALSE)
        {
            //System.out.println(saldo+">"+value);
            if (contenido != "") {
                candado_salida=Boolean.TRUE;
                //Mostramos por pantalla el estado del contenedor
                System.out.println("***************** INI_CONSUMIDOR "+vuelta+"********************");
                System.out.println("El Consumidor " + idproductor + " retira el mensaje del BUZON: " + this.contenido);
                resultado=this.contenido;
                this.contenido="";
                System.out.println("***************** FIN_CONSUMIDOR ********************");
                
                //Despertamos los hilos pausados
                candado_entrada=Boolean.FALSE;
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
       
        
        
       return resultado; 
    }     
}