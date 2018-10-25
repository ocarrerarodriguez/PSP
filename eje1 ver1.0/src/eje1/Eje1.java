

/*
    Programa en Java que cree dous fíos e os executa.
    Os fíos escriben dez veces un número de iteración do bucle e seu nome. 
    En cada iteración, despois de escribir o seu nome, se bloquean durante un tempo 
    aleatorio de segundos e después volven a estar dispoñibles para a súa execución. 
 */
package eje1;

/**
 *
 * @author lacuatoris
 */
public class Eje1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        Thread hilo1 = new hijo1("Pepe",10);
        Thread hilo2 = new hijo1("Juan",10);
        hilo1.start();
        hilo2.start();
    }
}
