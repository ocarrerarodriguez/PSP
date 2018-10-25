/*
 Programa que crea 4 fíos,
os executa e espera a que estes terminen. 
Os fíos escriben 5 veces o número de iteración do bucle e o 
seu nome. En cada iteración, despois de escribir o seu nome,
bloquéanse durante un segundo e volven a estar dispoñibles para a súa execución.  
 */
package eje2;

/**
 *
 * @author lacuatoris
 */
public class Eje2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        Thread hilo1 = new hijo2("Pepe",10);
        Thread hilo2 = new hijo2("Juan",10);
        Thread hilo3 = new hijo2("amigo",10);
        Thread hilo4 = new hijo2("tortuga",10);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}

