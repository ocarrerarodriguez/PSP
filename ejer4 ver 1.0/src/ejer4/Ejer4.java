/*
  Realiza un programa en java que execute tres fíos de forma concurrente.
  Un de eles debe sumar os números pares del 1 ao 1000, outro os impares,
  e outro, os que terminen en dous ou en tres. 
 */
package ejer4;

/**
 *
 * @author lacuatoris
 */
public class Ejer4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread hilo1 = new hijo4("Pepe",1000);
        Thread hilo2 = new hijo4("Juan",1000);
        Thread hilo3 = new hijo4("amigo",1000);
        Thread hilo4 = new hijo4("tortuga",1000);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
    
}
